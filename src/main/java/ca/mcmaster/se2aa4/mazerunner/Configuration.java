package ca.mcmaster.se2aa4.mazerunner;

import java.io.File;
import org.apache.commons.cli.*;

public record Configuration(File file,Path path) {
    public static Configuration load(String[] args) throws ParseException {
        Options options = new Options();
        options.addOption("i", true,"File name for maze" );
        options.addOption("p", true,"Path for testing in maze" );
        CommandLineParser parser = new DefaultParser();
        File file = null;
        Path path = null;
        CommandLine cmd = parser.parse(options, args);
        if (cmd.hasOption("i")) {
            file = new File(cmd.getOptionValue("i"));
        }
        if (cmd.hasOption('p')){
            path = new Path(cmd.getOptionValue('p').replaceAll(" ",""));
        }
        return new Configuration(file,path);

    }

}
