package CLI;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

public class CommandLineClass {

    public static final Option OPTION_INPUT_FILE_PATH = new Option("f", "fileName", true, "Reads Data from csv files");
    public static final Option OPTION_IGNORE_LIST = new Option("i", "ignore-list", false, "Columns to exclude from comparison");

    public static Options getOptions() {
        Options optionsList = new Options();
        optionsList.addOption(OPTION_IGNORE_LIST);
        optionsList.addOption(OPTION_INPUT_FILE_PATH);

        return optionsList;
    }

    public static void runCommand(CommandLine command){

    }
}
