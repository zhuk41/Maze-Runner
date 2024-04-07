package ca.mcmaster.se2aa4.mazerunner;


import ca.mcmaster.se2aa4.mazerunner.Algorithem.MazeSolver;
import ca.mcmaster.se2aa4.mazerunner.Algorithem.SolverFactory;
import ca.mcmaster.se2aa4.mazerunner.Path.Path;
import ca.mcmaster.se2aa4.mazerunner.Maze.Maze;
import ca.mcmaster.se2aa4.mazerunner.Maze.TxtMaze;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class Main {

    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) throws Exception {
        logger.info("** Starting Maze Runner");
        Maze maze = null;
        Configuration config = Configuration.load(args);
        try {
            logger.info("**** Reading the maze from file " + config.file().getName());
            maze = new TxtMaze(config.file(), true);
        } catch (IOException e) {
            logger.error("/!\\ An error has occured /!\\");
            logger.info("PATH NOT COMPUTED");
            e.printStackTrace();
        }
        if (config.path() != null){
            logger.info("**** Testing path ");
            PathVerifier path_verifier = new PathVerifier(maze);
            Path path = new Path(config.path()
                    .replaceAll(" ",""))
                    .unFactorize();
            path.printPath();
            boolean is_real_path = path_verifier.verify(path);
            if (is_real_path){
                System.out.println("*** Path is Correct");
            } else {
                System.out.println("*** Path is Wrong");
            }
        }
        else{
            logger.info("**** Computing path");
            SolverFactory solverFactory = new SolverFactory(maze);
            MazeSolver solver = solverFactory.getSolver(config.method());
            Path path = solver.solve();
            path.printPath();
            path.printFactorizedPath();

        }
        logger.info("** End of MazeRunner");
    }
}
