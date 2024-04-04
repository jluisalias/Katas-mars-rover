package com.java.katas.marsrover.direction;

/**
 * Interface to implement the directions and turns by the State design pattern
 * So, the 4 directions could be considered as a machine of 4 states, where:
 * - State North can go East, turning right, and West turning left.
 * - State West can go North, turning right, and South turning left.
 * - State South can go West, turning right, and East turning left.
 * - State East can go South, turning right, and North turning left.
 */
public interface Direction {
    Direction turnRight();

    Direction turnLeft();

    String returnName();

    String returnDirectionCoordinate();
}
