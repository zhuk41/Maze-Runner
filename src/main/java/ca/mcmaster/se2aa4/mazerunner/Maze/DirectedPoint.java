package ca.mcmaster.se2aa4.mazerunner.Maze;

public class DirectedPoint {
    private final Direction direction;
    private final Point location;
    public DirectedPoint(Point p,Direction the_direction) {
        location = p;
        direction = the_direction;
    }
    public Direction getDirection(){
        return direction;
    }
    public Point nearbyPoint(Direction d){
        return location.NearbyPoint(d);
    }
    public Point getLocation(){
        return location;
    }
    @Override
    public boolean equals(Object o){
        if (o instanceof DirectedPoint dP){
            return (location.equals(dP.getLocation()))
                    && (dP.getDirection() == this.getDirection());
        }
        return false;
    }
}
