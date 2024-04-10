package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogger();
    public static void main(String[] args) throws Exception {
        logger.info("** Starting Maze Runner");
        Configuration config = Configuration.load(args);
        Controller control = new Controller(config);
        control.run();
        logger.info("** End of MazeRunner");
    }
}
