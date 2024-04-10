package ca.mcmaster.se2aa4.mazerunner.maze;

import java.util.Objects;

public class Point{
    private final int  row;
    private final int  column;
    public Point(int row, int column){
         this.row = row;
         this.column = column;
    }
    public Point nearbyPoint(Direction d){
        return switch (d) {
            case NORTH -> new Point(this.row - 1, this.column);
            case EAST -> new Point(this.row, this.column + 1);
            case SOUTH -> new Point(this.row + 1, this.column);
            case WEST -> new Point(this.row, this.column - 1);
        };
    }
    public int getRow(){
        return row;
    }
    public int getColumn(){
        return column;
    }
    @Override
    public boolean equals(Object o){
        if (o instanceof Point){
            return ((Point) o).row == this. row && ((Point) o).column == this.column;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }
}
