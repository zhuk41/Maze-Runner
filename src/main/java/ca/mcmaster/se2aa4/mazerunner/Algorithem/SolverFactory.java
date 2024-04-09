package ca.mcmaster.se2aa4.mazerunner.Algorithem;

import ca.mcmaster.se2aa4.mazerunner.Maze.Maze;

import java.util.HashMap;
import java.util.Map;

public class SolverFactory {
    private static SolverFactory  solverFactory = null;
    private final Map<String,MazeSolver> solverList;
    private SolverFactory(){
        solverList = new HashMap<>();
        solverList.put("righthand", new RightHandSolver());
        solverList.put("bfs",new BreathFirstSearch());
    }
    public static SolverFactory getInstance(){
        if (solverFactory==null){
            solverFactory = new SolverFactory();
        }
        return solverFactory;
    }
    public MazeSolver getSolver(String name){
        return solverList.get(name);
    }
}
