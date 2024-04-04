package com.java.katas.marsrover.direction;

/**
 * I'll apply here the singleton pattern, so no more than one instance will be
 * created.
 */
public final class East implements Direction {

    private static East singletonEastInstance;

    private East() {
        super();
    }

    public static East getEast() {
        if (singletonEastInstance == null) {
            singletonEastInstance = new East();
        }
        return singletonEastInstance;
    }

    @Override
    public Direction turnRight() {
        return South.getSouth();
    }

    @Override
    public Direction turnLeft() {
        return North.getNorth();
    }

    @Override
    public String returnName() {
        return this.getClass().getSimpleName();
    }

    @Override
    public String returnDirectionCoordinate() {
        return "E";
    }

}
