package dfake.run;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import dfake.DFakeException;
import dfake.DFakeSettings;
import smtlib.Cons;
import smtlib.Location;
import smtlib.Program;
import smtlib.SExpr;
import smtlib.Util;
import smtlib.visitor.FlattenVisitor;
import smtlib.visitor.InlineFunctionVisitor;
import smtlib.visitor.RemoveDivVisitor;

public class MainLoop {

   public List<SExpr> currentStream;
   public Run lastRun;
   public DFakeSettings settings;

   public MainLoop(DFakeSettings settings) {
      currentStream = new ArrayList<>();
      this.settings = settings;
   }

   protected String getScratchBase() {
      if (settings.scratch) {
         return settings.filename + ".dreal";
      } else {
         return null;
      }
   }
   
   protected int count = 0;
   
   protected void tempScratch(Program p) {
       count++; 
      String filename = getScratchBase() + count + ".smt2";
      try {
         PrintWriter pw = new PrintWriter(new FileOutputStream(filename), true);
         pw.append(p.toString());
         pw.close();
      } catch (FileNotFoundException e) {
         throw new DFakeException("Unable to open scratch file: " + filename, e);
      }
   }

   public void doRun() {
      Program p = new Program(Location.NULL, currentStream);
      p = InlineFunctionVisitor.Program(p);
      p = RemoveDivVisitor.Program(p);
      p = FlattenVisitor.ProgramExit(p);
      if (settings.scratch) {
    	  tempScratch(p);
      }
      // System.out.println("Doing a run!");
      lastRun = new Run(p, getScratchBase());
      lastRun.exec();
      // System.out.println("Did a run!");
      lastRun.stop();
      if (lastRun.result instanceof SatResult) {
    	  System.out.println("sat");
      } else if (lastRun.result instanceof UnsatResult) {
    	  System.out.println("unsat");
      } else if (lastRun.result instanceof UnknownResult) {
    	  System.out.println("unknown");
      } else {
    	  System.out.println("Rats! Error!");
    	  // Don't really know what to do here...should I throw an exception?
      }
   }
   
   public void addSExpr(SExpr expr) {
      if (Util.consHeadMatchesString(expr, "check-sat")) {
    	  currentStream.add(expr);
         doRun();
      } else if (Util.consHeadMatchesString(expr, "get-model")){
         // MWW: may want to add add'l information here or return 
         // alternate string if result is UNSAT or UNKNOWN.
         System.out.println(lastRun.result.toString()); 
      } else if (Util.consHeadMatchesString(expr, "echo")) {
    	 System.out.println(((Cons)expr).args.get(1).toString());
      } else if (Util.consHeadMatchesString(expr, "set-option")) {
    	  System.err.println("Warning: " + expr.toString() + "ignored");
      } else if (Util.consHeadMatchesString(expr, "exit")) {
    	  // kill it!
    	  System.exit(0);
      } else {
         // keep on adding on to list of model s-expressions.
         currentStream.add(expr);
      }
   }
}
