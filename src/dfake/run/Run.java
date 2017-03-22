package dfake.run;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.antlr.v4.runtime.RecognitionException;

import dfake.DFakeException;
import smtlib.Program;
import smtlib.SExpr;

/*
 * Note: this does not correctly deal with "shadowing" declarations in a push/pop scope.
 * Just don't do this :)
 */

public class Run {

   protected Program p; 
   protected String scratchBase;
   protected PrintWriter scratch;

   protected static final String DONE = "@DONE";

   protected Process process;
   protected BufferedWriter toSolver;
   protected BufferedReader fromSolver;
   
   protected Result result = null; 
   
   
   public Run(Program p, String scratchBase) {

      this.p = p; 
      this.scratchBase = scratchBase;
      this.scratch = getScratch(scratchBase);

      //System.out.println("Solver command: " + getSolverCommand());
      ProcessBuilder processBuilder = new ProcessBuilder(getSolverCommand());
      processBuilder.redirectErrorStream(true);
      try {
         process = processBuilder.start();
      } catch (IOException e) {
         throw new DFakeException("Unable to start solver by executing: "
               + processBuilder.command().get(0), e);
      }
      addShutdownHook();
      toSolver = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
      fromSolver = new BufferedReader(new InputStreamReader(process.getInputStream()));
   }


   private PrintWriter getScratch(String scratchBase) {
      if (scratchBase == null) {
         return null;
      }

      String filename = scratchBase + "." + getSolverExtension();
      try {
         return new PrintWriter(new FileOutputStream(filename), true);
      } catch (FileNotFoundException e) {
         throw new DFakeException("Unable to open scratch file: " + filename, e);
      }
   }

   private List<String> getSolverCommand() {
      List<String> command = new ArrayList<>();
      command.add(getSolverPath());
      command.addAll(Arrays.asList(getSolverOptions()));
      return command;
   }

   private String getSolverPath() {
      String executable = getSolverExecutable();
      String home = System.getenv(getSolverHomeVariable());
      if (home != null) {
         return new File(getBinDir(home), executable).toString();
      }
      return executable;
   }

   private static File getBinDir(String homeString) {
      File home = new File(homeString);
      File bin = new File(home, "bin");
      if (bin.isDirectory()) {
         return bin;
      } else {
         return home;
      }
   }

   protected String getSolverName() { return "dReal"; }

   protected String getSolverExtension() { return ".smt2"; }

   protected String getSolverExecutable() {
      return getSolverName();
   }

   protected String[] getSolverOptions() {
	   String[] options = new String[2];
	   options[1] = "--in";
	   options[0] = "--model";
	   return options;
   }

   protected String getSolverHomeVariable() {
      return getSolverName().toUpperCase() + "_HOME";
   }

   private void addShutdownHook() {
      Runtime.getRuntime().addShutdownHook(new Thread("shutdown-hook") {
         @Override
         public void run() {
            Run.this.stop();
         }
      });
   }

   public synchronized void stop() {
      /**
       * This must be synchronized since two threads (an Engine or a shutdown
       * hook) may try to stop the solver at the same time
       */

      if (process != null) {
         process.destroy();
         process = null;
      }

      if (scratch != null) {
         scratch.close();
         scratch = null;
      }
   }

   public void scratch(String str) {
      if (scratch != null) {
         scratch.println(str);
      }
   }

   public void comment(String str) {
      scratch("; " + str);
   }

   public void pause(int ms) {
      try {
    	  Thread.sleep(ms);
      } catch (InterruptedException e ) {}
   }
   
   public void exec() {
      send(p.toString());
      close();
      String status = readFromSolver();
      if (isSat(status)) {
         result = new SatResult(status);
      } else if (isUnsat(status)) {
         result = new UnsatResult();
      } else {
    	 result = new UnknownResult(status); 
         //throw new IllegalArgumentException("Unknown result: " + result);
      }
   }

   public Result getResult() { return result; }
   protected void send(SExpr sexp) {
      send(sexp.toString());
   }
   
   protected void close() {
	   try {
		   toSolver.close();
		   toSolver = null;
	   } catch (IOException e) {
	       throw new DFakeException("Unable to write to " + getSolverName() + ", "
	            + "probably due to internal DFake error", e);
	   }
   }

   protected void send(String str) {
      scratch(str);
      try {
         toSolver.append(str);
         toSolver.newLine();
         toSolver.flush();
      } catch (IOException e) {
         throw new DFakeException("Unable to write to " + getSolverName() + ", "
               + "probably due to internal DFake error", e);
      }
   }

   protected String readFromSolver() {
      try {
         String line;
         StringBuilder content = new StringBuilder();
         while (true) {
            line = fromSolver.readLine();
            comment(getSolverName() + ": " + line);
            if (line == null) {
               break; // throw new DFakeException(getSolverName() + " terminated unexpectedly");
            } else if (line.trim().startsWith("Solution:")) {
                // first line of SAT result
               content.append("sat" + System.lineSeparator());
            } else if (line.trim().startsWith("delta-sat")) {
                // last line of SAT result - discard.
                break;
            }
            else if (line.trim().startsWith("unsat")) {
               // last line of UNSAT result
               content.append(line);
               content.append(System.lineSeparator());
               break;
            } else if (line.contains("error \"") || line.contains("Error:")) {
               // Flush the output since errors span multiple lines
               while ((line = fromSolver.readLine()) != null) {
                  comment(getSolverName() + ": " + line);
               }
               throw new DFakeException(getSolverName()
                     + " error (see scratch file for details)");
            } else {
               content.append(line);
               content.append(System.lineSeparator());
            }
         }
         return content.toString();
      } catch (RecognitionException e) {
         throw new DFakeException("Error parsing " + getSolverName() + " output", e);
      } catch (IOException e) {
         throw new DFakeException("Unable to read from " + getSolverName(), e);
      }
   }

   protected boolean isSat(String output) {
       return output.trim().startsWith("sat");
   }

   protected boolean isUnsat(String output) {
      return output.trim().startsWith("unsat");
   }
}
