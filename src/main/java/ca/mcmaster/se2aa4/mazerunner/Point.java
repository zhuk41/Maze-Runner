package ca.mcmaster.se2aa4.mazerunner;

public class Point {
    int row;
    int column;
    public Point(int the_row, int the_column){
         row = the_row;
         column = the_column;
    }
    public boolean equals(Point point){
        return (point.row == this. row) && (point.column == this.column);
    }
    /*public void print(){
        System.out.println(row+","+column);
    }*///used for testing

}
