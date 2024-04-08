package ca.mcmaster.se2aa4.mazerunner.Algorithem;

import ca.mcmaster.se2aa4.mazerunner.Maze.Maze;

import java.util.HashMap;
import java.util.Map;

public class SolverFactory {
    private final Map<String,MazeSolver> solverList;
    public SolverFactory(Maze the_maze){
        solverList = new HashMap<>();
        solverList.put("righthand", new RightHandSolver().withMaze(the_maze));
        solverList.put("bfs",new BreathFirstSearch().withMaze(the_maze));
    }
    public MazeSolver getSolver(String name){
        return solverList.get(name);
    }
}
