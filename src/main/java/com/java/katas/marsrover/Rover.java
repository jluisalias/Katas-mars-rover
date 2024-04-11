package com.java.katas.marsrover;

import java.util.Arrays;

import com.java.katas.marsrover.coordinate.Coordinate;
import com.java.katas.marsrover.direction.Direction;
import com.java.katas.marsrover.direction.North;
import com.java.katas.marsrover.grid.Grid;

public class Rover {
    private final Grid grid;
    private Coordinate currentCoordinate = new Coordinate(0, 0);
    private Direction currentDirection = North.getNorth();
    private boolean hitAnObstacle = false;

    public Rover(Grid grid) {
        this.grid = grid;
    }

    String perform(String commands) {
        Arrays.stream(commands.split(""))
                .forEach(command -> {
                    if (!hitAnObstacle) {
                        if (command.equals("L")) {
                            currentDirection = currentDirection.turnLeft();
                        } else if (command.equals("R")) {
                            currentDirection = currentDirection.turnRight();
                        } else if (command.equals("M")) {
                            Coordinate nextCoordinateCandidate = grid.returnNextCoordinate(currentCoordinate,
                                    currentDirection);
                            if (grid.isThereAnObstacleInTheCoordinate(nextCoordinateCandidate)) {
                                hitAnObstacle = true;
                            } else {
                                currentCoordinate = nextCoordinateCandidate;
                            }
                        } else {

                        }
                    }
                });
        return printRoverOutput();
    }

    private String printRoverOutput() {
        final StringBuilder sBuilder = new StringBuilder();
        if (hitAnObstacle) {
            sBuilder.append("0:");
        }
        sBuilder.append(currentCoordinate.returnFormattedCoordinate());
        sBuilder.append(":").append(currentDirection.returnDirectionCoordinate());
        return sBuilder.toString();
    }
}
