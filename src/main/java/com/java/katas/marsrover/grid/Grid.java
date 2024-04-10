package com.java.katas.marsrover.grid;

import java.util.Collections;
import java.util.List;

import com.java.katas.marsrover.coordinate.Coordinate;
import com.java.katas.marsrover.direction.Direction;

public class Grid {
    private static final int MAX_HEIGHT = 10;
    private static final int MAX_WIDTH = 10;

    private final List<Coordinate> obstacles;

    public Grid() {
        this.obstacles = Collections.emptyList();
    }

    public Grid(List<Coordinate> obstacles) {
        this.obstacles = obstacles;
    }

    public Coordinate returnNextCoordinate(Coordinate coordinate, Direction direction) {
        int x = coordinate.x();
        int y = coordinate.y();

        final String directionName = direction.returnName();

        if (directionName.equals("North")) {
            y = (y + 1) % MAX_HEIGHT;
        }
        if (directionName.equals("East")) {
            x = (x + 1) % MAX_WIDTH;
        }
        if (directionName.equals("South")) {
            y = y > 0 ? (y - 1) : MAX_HEIGHT - 1;
        }
        if (directionName.equals("West")) {
            x = x > 0 ? (x - 1) : MAX_WIDTH - 1;
        }

        return new Coordinate(x, y);
    }

    public boolean isThereAnObstacleInTheCoordinate(Coordinate coordinate) {
        return this.obstacles.contains(coordinate);
    }
}
