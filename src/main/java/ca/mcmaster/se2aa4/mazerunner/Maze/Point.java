package ca.mcmaster.se2aa4.mazerunner.Maze;

public class Point{
    private final int  row;
    private final int  column;
    public Point(int the_row, int the_column){
         row = the_row;
         column = the_column;
    }
    public Point NearbyPoint(Direction d){
        return switch (d) {
            case NORTH -> (new Point(this.row - 1, this.column));
            case EAST -> (new Point(this.row, this.column + 1));
            case SOUTH -> (new Point(this.row + 1, this.column));
            case WEST -> (new Point(this.row, this.column - 1));
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
            return (((Point) o).row == this. row) && (((Point) o).column == this.column);
        }
        return false;
    }
}
