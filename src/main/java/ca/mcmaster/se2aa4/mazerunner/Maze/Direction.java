package ca.mcmaster.se2aa4.mazerunner.Maze;

public enum Direction{
    NORTH,
    EAST,
    SOUTH,
    WEST;
    public Direction right() {
        return switch (this) {
            case EAST -> SOUTH;
            case SOUTH -> WEST;
            case WEST -> NORTH;
            default -> EAST;
        };
    }

    public Direction left() {
        return switch (this) {
            case EAST -> NORTH;
            case NORTH -> WEST;
            case WEST -> SOUTH;
            default -> EAST;
        };
    }
}
