package ca.mcmaster.se2aa4.mazerunner.maze;

import java.util.Objects;

public class DirectedPoint {
    private final Direction direction;
    private final Point location;
    public DirectedPoint(Point p,Direction direction) {
        location = p;
        this.direction = direction;
    }
    public Direction getDirection(){
        return direction;
    }
    public Point nearbyPoint(Direction d){
        return location.nearbyPoint(d);
    }
    public Point getLocation(){
        return location;
    }
    @Override
    public boolean equals(Object o){
        if (o instanceof DirectedPoint dP){
            return location.equals(dP.getLocation())
                    && dP.getDirection() == this.getDirection();
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(direction, location);
    }
}
