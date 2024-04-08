package ca.mcmaster.se2aa4.mazerunner.Explorer;

import ca.mcmaster.se2aa4.mazerunner.Maze.Direction;
import ca.mcmaster.se2aa4.mazerunner.Maze.*;
public class Explorer {
    private Point location;
    private Direction facing;
    public Explorer(Point start, Direction starting_direction){
        facing = starting_direction;
        location = start;
    }
    public void turnRight(){
        facing = facing.right();
    }
    public void turnLeft(){
        facing = facing.left();
    }
    public void moveForward() {
        location = location.NearbyPoint(facing);
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