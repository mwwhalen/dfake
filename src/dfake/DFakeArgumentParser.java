package dfake;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Options;

public class DFakeArgumentParser extends ArgumentParser {
	private static final String SCRATCH = "scratch";
	public static final String STDIN = "in";
   private static final String TIMEOUT = "timeout";

	private final DFakeSettings settings;

	private DFakeArgumentParser() {
		this("DFake", new DFakeSettings());
	}

	private DFakeArgumentParser(String name, DFakeSettings settings) {
		super(name, settings);
		this.settings = settings;
	}

	@Override
	protected Options getOptions() {
		Options options = super.getOptions();
		options.addOption(SCRATCH, false, "produce files for debugging purposes");
		options.addOption(STDIN, false, "read input from stdin rather than an input file");
      options.addOption(TIMEOUT, true, "maximum runtime in seconds (default: 100)");
		return options;
	}

	public static DFakeSettings parse(String[] args) {
		DFakeArgumentParser parser = new DFakeArgumentParser();
		parser.parseArguments(args);
		parser.checkSettings();
		return parser.settings;
	}

	@Override
	protected void parseCommandLine(CommandLine line) {
		
	   super.parseCommandLine(line);

		if (line.hasOption(SCRATCH)) {
			settings.scratch = true;
		}
		if (line.hasOption(STDIN)) {
		   settings.stdIn = true;
		}
      if (line.hasOption(TIMEOUT)) {
         settings.timeout = parseNonnegativeInt(line.getOptionValue(TIMEOUT));
      }
	}


	private void checkSettings() {
	   if (settings.stdIn == false &&
	       settings.filename == null) {
   	   printHelp();
         System.exit(ExitCodes.INVALID_OPTIONS);
	   }
	}


}
