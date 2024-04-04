package com.java.katas.marsrover.direction;

/**
 * I'll apply here the singleton pattern, so no more than one instance will be
 * created.
 */
public final class West implements Direction {

    private static West singletonWestInstance;

    private West() {
        super();
    }

    public static West getWest() {
        if (singletonWestInstance == null) {
            singletonWestInstance = new West();
        }
        return singletonWestInstance;
    }

    @Override
    public Direction turnRight() {
        return North.getNorth();
    }

    @Override
    public Direction turnLeft() {
        return South.getSouth();
    }

    @Override
    public String returnName() {
        return this.getClass().getSimpleName();
    }

    @Override
    public String returnDirectionCoordinate() {
        return "W";
    }

}
