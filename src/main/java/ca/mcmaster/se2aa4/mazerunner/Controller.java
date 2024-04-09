package ca.mcmaster.se2aa4.mazerunner;

import ca.mcmaster.se2aa4.mazerunner.Algorithem.MazeSolver;
import ca.mcmaster.se2aa4.mazerunner.Algorithem.SolverFactory;
import ca.mcmaster.se2aa4.mazerunner.Maze.Maze;
import ca.mcmaster.se2aa4.mazerunner.Maze.TxtMaze;
import ca.mcmaster.se2aa4.mazerunner.Path.Path;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class Controller {
    private final Logger logger = LogManager.getLogger();
    Configuration config;
    Maze maze;
    Timer timer;
    public Controller(Configuration configArgs){
        config = configArgs;
        timer = new Timer();
        timer.start();
        try {
            logger.info("**** Reading the maze from file " + config.file().getName());
            maze = new TxtMaze(config.file(), true);
        } catch (IOException e) {
            logger.error("/!\\ An error has happened /!\\");
            logger.info("PATH NOT COMPUTED");
            e.printStackTrace(System.out);
        }
        timer.stop();
        System.out.printf("Time taken to create maze: %1.2fms\n",timer.getMilliseconds());
    }
    public void run(){
        if (config.path() != null){
            logger.info("**** Testing path ");
            pathTest();
        }
        if (config.method() != null && config.baseline()!= null){
            benchmark();
        }
        else if (config.method() != null){

            logger.info("**** Computing path");
            solve();
        }
    }
    private void pathTest(){
        PathVerifier path_verifier = new PathVerifier(maze);
        Path path = new Path(config.path());
        path.printPath();
        boolean is_real_path = path_verifier.verify(path);
        if (is_real_path){
            System.out.println("*** Path is Correct");
        } else {
            System.out.println("*** Path is Wrong");
        }
    }
    private void benchmark(){
        SolverFactory solverFactory = SolverFactory.getInstance();

        MazeSolver newSolver = solverFactory.getSolver(config.method()).withMaze(maze);
        MazeSolver baseSolver = solverFactory.getSolver(config.baseline()).withMaze(maze);

        timer.start();
        Path newPath = newSolver.solve();
        timer.stop();
        System.out.printf("Time taken to solve maze with %s: %1.2fms\n",config.method(),timer.getMilliseconds());

        timer.start();
        Path basePath = baseSolver.solve();
        timer.stop();
        System.out.printf("Time taken to solve maze with %s: %1.2fms\n",config.baseline(),timer.getMilliseconds());

        double speedUp = (double)(basePath.length()) / (newPath.length());
        System.out.printf("Speedup: %1.2f\n", speedUp);
    }
    private void solve(){
        SolverFactory solverFactory = SolverFactory.getInstance();
        MazeSolver solver = solverFactory.getSolver(config.method()).withMaze(maze);
        Path path = solver.solve();
        path.printPath();
        path.printFactorizedPath();
    }
}
