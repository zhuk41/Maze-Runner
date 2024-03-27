package ca.mcmaster.se2aa4.mazerunner;

import java.io.File;
import org.apache.commons.cli.*;

public record Configuration(File file,String path) {
    public static Configuration load(String[] args) throws ParseException {
        Options options = new Options();
        options.addOption("i", true,"File name for maze" );
        options.addOption("p", true,"Path for testing in maze" );
        CommandLineParser parser = new DefaultParser();
        File file = null;
        String path = null;
        CommandLine cmd = parser.parse(options, args);
        if (cmd.hasOption("i")) {
            file = new File(cmd.getOptionValue("i"));
        }
        if (cmd.hasOption('p')){
            path = cmd.getOptionValue('p');
        }
        return new Configuration(file,path);

    }

}
