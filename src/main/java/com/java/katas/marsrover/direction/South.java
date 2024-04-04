package com.java.katas.marsrover.direction;

/**
 * I'll apply here the singleton pattern, so no more than one instance will be
 * created.
 */
public final class South implements Direction {

    private static South singletonSouthInstance;

    private South() {
        super();
    }

    public static South getSouth() {
        if (singletonSouthInstance == null) {
            singletonSouthInstance = new South();
        }
        return singletonSouthInstance;
    }

    @Override
    public Direction turnRight() {
        return West.getWest();
    }

    @Override
    public Direction turnLeft() {
        return East.getEast();
    }

    @Override
    public String returnName() {
        return this.getClass().getSimpleName();
    }

    @Override
    public String returnDirectionCoordinate() {
        return "S";
    }

}
