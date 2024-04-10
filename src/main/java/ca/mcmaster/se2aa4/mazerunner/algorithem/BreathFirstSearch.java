package ca.mcmaster.se2aa4.mazerunner.algorithem;

import ca.mcmaster.se2aa4.mazerunner.maze.DirectedPoint;
import ca.mcmaster.se2aa4.mazerunner.maze.Maze;
import ca.mcmaster.se2aa4.mazerunner.path.Path;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class BreathFirstSearch implements MazeSolver {
    private Maze maze;
    @Override
    public MazeSolver withMaze(Maze maze) {
        this.maze = maze;
        return this;
    }

    @Override
    public Path solve() {

        Queue<DirectedPoint> pointQueue = new LinkedList<>();
        Map<DirectedPoint, DirectedPoint> previousPointMap = new HashMap<>(); //location and direction of previous point

        DirectedPoint current = new DirectedPoint(maze.getStart(), maze.getStartDirection());

        do {
            if (!maze.isWall(current.nearbyPoint(current.getDirection()))) {
                DirectedPoint next = new DirectedPoint(
                        current.nearbyPoint(current.getDirection()),
                        current.getDirection());
                pointQueue.add(next);
                previousPointMap.put(next, current);

            }
            if (!maze.isWall(current.nearbyPoint(current.getDirection().right()))) {
                DirectedPoint next = new DirectedPoint(
                        current.nearbyPoint(current.getDirection().right()),
                        current.getDirection().right());
                pointQueue.add(next);
                previousPointMap.put(next, current);
            }
            if (!maze.isWall(current.nearbyPoint(current.getDirection().left()))) {
                DirectedPoint next = new DirectedPoint(
                        current.nearbyPoint(current.getDirection().left()),
                        current.getDirection().left());
                pointQueue.add(next);
                previousPointMap.put(next, current);
            }
            current = pointQueue.poll();
        }
        while (current!= null && !current.getLocation().equals(maze.getExit()));
        if (current== null){
            throw new IllegalArgumentException("Invalid Maze");
        }

        StringBuilder rawPath = new StringBuilder();
        while (!current.getLocation().equals(maze.getStart())){
            DirectedPoint previous = previousPointMap.get(current);
            rawPath.append("F");
            if (current.getDirection() == previous.getDirection().right()){
                rawPath.append("R");
            }
            else if (current.getDirection() == previous.getDirection().left()) {
                rawPath.append("L");
            }
            current =previous;
        }
        rawPath.reverse();
        return new Path(rawPath.toString());
    }
}
