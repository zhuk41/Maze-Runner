package ca.mcmaster.se2aa4.mazerunner;

public class Timer {
    long start;
    long stop;
    public void start(){
        start = System.nanoTime();
    }
    public void stop(){
        stop = System.nanoTime();
    }
    public double getMilliseconds(){
        return (double)(stop -  start) / 1000000;
    }
}
