package ca.mcmaster.se2aa4.mazerunner;

public class Skeleton {
    Point location;
    Direction facing;
    Skeleton(Point start, Direction starting_direction){
        facing = starting_direction;
        location = start;
    }
    public void turnRight(){
        facing = Direction.right(facing);
    }
    public void turnLeft(){
        facing = Direction.left(facing);
    }
    public void moveForward() {
        switch (facing){
            case NORTH -> location.row = location.row-1;
            case EAST -> location.column =location.column+1;
            case SOUTH -> location.row = location.row+1;
            case WEST -> location.column =location.column-1;
        }
    }
    public boolean atPoint(Point point){
        return point.equals(location);
    }
    public boolean isWall(Direction direction,Maze maze){
        return switch (direction) {
            case NORTH -> maze.isWall(new Point(location.row - 1, location.column));
            case EAST -> maze.isWall(new Point(location.row, location.column + 1));
            case SOUTH -> maze.isWall(new Point(location.row + 1, location.column));
            case WEST -> maze.isWall(new Point(location.row, location.column - 1));
        };
    }


}