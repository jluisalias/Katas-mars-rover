package com.java.katas.marsrover.direction;

/**
 * I'll apply here the singleton pattern, so no more than one instance will be
 * created.
 */
public final class North implements Direction {

    private static North singletonNorthInstance;

    private North() {
        super();
    }

    public static North getNorth() {
        if (singletonNorthInstance == null) {
            singletonNorthInstance = new North();
        }
        return singletonNorthInstance;
    }

    @Override
    public Direction turnRight() {
        return East.getEast();
    }

    @Override
    public Direction turnLeft() {
        return West.getWest();
    }

    @Override
    public String returnName() {
        return this.getClass().getSimpleName();
    }

    @Override
    public String returnDirectionCoordinate() {
        return "N";
    }
}
