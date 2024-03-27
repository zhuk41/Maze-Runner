package ca.mcmaster.se2aa4.mazerunner.Maze;

public enum Direction{
    NORTH,
    EAST,
    SOUTH,
    WEST;
    public static Direction left(Direction forward){
        return getDirection(forward, NORTH, WEST, SOUTH, EAST);
    }
    public static Direction right(Direction forward){
        return getDirection(forward, SOUTH, EAST, NORTH, WEST);
    }
    private static Direction getDirection(Direction forward, Direction direction, Direction direction2, Direction direction3, Direction direction4) {
        return switch (forward) {
            case EAST -> direction;
            case NORTH -> direction2;
            case WEST -> direction3;
            case SOUTH -> direction4;
        };
    }
}
