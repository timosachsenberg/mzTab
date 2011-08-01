package uk.ac.ebi.pride.tools.mztab_exporter;

import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;

@SuppressWarnings("static-access")
public class CliOptions {

	public enum OPTIONS {
		CHECK_FILE("check_file"),
		HELP("help"),
		CONVERT("convert"),
		FORMAT("format");

		private String value;

		OPTIONS(String value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return value;
		}
	}

	private static final Options options = new Options();

	static {

		Option help = new Option(
				OPTIONS.HELP.toString(),
				"print this message.");

		Option checkFile = OptionBuilder
				.withArgName("file")
				.hasArg()
				.withDescription(
						"tries to parse the given mzTab file.")
				.create(OPTIONS.CHECK_FILE.toString());
		
		Option format = OptionBuilder
					.withArgName("format")
					.hasArg()
					.withDescription("specifies the input file format. Possible values are [PRIDE].")
					.create(OPTIONS.FORMAT.toString());
		
		Option convert = OptionBuilder
				.withArgName("file")
				.hasArg()
				.withDescription("converts the given PRIDE XML file to an mztab file.")
				.create(OPTIONS.CONVERT.toString());

		options.addOption(help);
		options.addOption(checkFile);
		options.addOption(format);
		options.addOption(convert);
	}

	public static Options getOptions() {
		return options;
	}
}