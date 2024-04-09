package ca.mcmaster.se2aa4.mazerunner;

import java.io.File;
import org.apache.commons.cli.*;

public record Configuration(File file,String path,String method,String baseline) {
    public static Configuration load(String[] args) throws ParseException {
        Options options = new Options();
        final String fileArg = "i";
        final String pathArg = "p";
        final String methodArg = "method";
        final String baselineArg = "baseline";
        options.addOption(fileArg, true,"File name for maze" );
        options.addOption(pathArg, true,"Path for testing in maze" );
        options.addOption(methodArg,true,"Algorithm used.");
        options.addOption(baselineArg,true,"Algorithm compared to.");
        CommandLineParser parser = new DefaultParser();
        File file = null;
        String path = null;
        String method = null;
        String baseline = null;
        CommandLine cmd = parser.parse(options, args);
        if (cmd.hasOption(fileArg)) {
            file = new File(cmd.getOptionValue(fileArg));
        }
        if (cmd.hasOption(pathArg)){
            path = cmd.getOptionValue(pathArg);
        }
        if (cmd.hasOption(methodArg)){
            method = cmd.getOptionValue(methodArg);
        }
        if (cmd.hasOption(baselineArg)) {
            baseline = (cmd.getOptionValue(baselineArg));
        }
        return new Configuration(file,path,method,baseline);
    }

}
