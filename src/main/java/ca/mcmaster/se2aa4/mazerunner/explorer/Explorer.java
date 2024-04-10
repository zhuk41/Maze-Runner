package ca.mcmaster.se2aa4.mazerunner.explorer;

import ca.mcmaster.se2aa4.mazerunner.maze.Direction;
import ca.mcmaster.se2aa4.mazerunner.maze.*;
public class Explorer {
    private Point location;
    private Direction facing;
    public Explorer(Point start, Direction startingDirection){
        facing = startingDirection;
        location = start;
    }
    public void turnRight(){
        facing = facing.right();
    }
    public void turnLeft(){
        facing = facing.left();
    }
    public void moveForward() {
        location = location.nearbyPoint(facing);
    }
    public boolean atPoint(Point point){
        return point.equals(location);
    }
    public Point getLocation(){
        return location;
    }

    public Direction getFacing() {
        return facing;
    }
}