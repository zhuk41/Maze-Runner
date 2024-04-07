package ca.mcmaster.se2aa4.mazerunner.Algorithem;

import ca.mcmaster.se2aa4.mazerunner.Maze.Maze;

public class SolverFactory {
    Maze maze;
    public SolverFactory(Maze the_maze){
        maze = the_maze;
    }
    public MazeSolver getSolver(String name){
        if (name.equals("righthand")){
            return new RightHandSolver().withMaze(maze);
        }
        throw new IllegalArgumentException();
    }


}
