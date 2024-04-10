package com.java.katas.marsrover.grid;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.boot.test.context.SpringBootTest;

import com.java.katas.marsrover.coordinate.Coordinate;
import com.java.katas.marsrover.direction.Direction;
import com.java.katas.marsrover.direction.East;
import com.java.katas.marsrover.direction.North;
import com.java.katas.marsrover.direction.South;
import com.java.katas.marsrover.direction.West;

@SpringBootTest
public class GridTest {

    private Grid gridSUT;

    @ParameterizedTest
    @MethodSource("returnNextCoordinateArguments")
    public void returnNextCoordinate_ShouldReturnTheCoordinateAccordingTheDirection(
            List<Coordinate> obstacles, Coordinate input, Direction direction, Coordinate output) {
        gridSUT = new Grid(obstacles);
        assertEquals(output, gridSUT.returnNextCoordinate(input, direction));
    }

    @ParameterizedTest
    @MethodSource("isThereAnObstacleInTheCoordinateArguments")
    public void isThereAnObstacleInTheCoordinate_ShouldReturnTrueIfThereIsAnObstacle(
            List<Coordinate> obstacles, Coordinate input, boolean expectedOutput) {
        gridSUT = new Grid(obstacles);
        assertEquals(expectedOutput, gridSUT.isThereAnObstacleInTheCoordinate(input));
    }

    /*
     * PARAMETERIZED METHOD ARGUMENTS PROVIDERS
     */

    private static Stream<Arguments> returnNextCoordinateArguments() {
        List<Coordinate> fakeObstacles = Collections.singletonList(new Coordinate(3, 1));
        return Stream.of(
                arguments(Collections.emptyList(), new Coordinate(0, 0), North
                        .getNorth(), new Coordinate(0, 1)),
                arguments(Collections.emptyList(), new Coordinate(0, 0), West
                        .getWest(), new Coordinate(9, 0)),
                arguments(fakeObstacles, new Coordinate(2, 1), East
                        .getEast(), new Coordinate(3, 1)),
                arguments(fakeObstacles, new Coordinate(2, 1), South
                        .getSouth(), new Coordinate(2, 0)),
                arguments(Collections.emptyList(), new Coordinate(3, 2), West
                        .getWest(), new Coordinate(2, 2)));
    }

    private static Stream<Arguments> isThereAnObstacleInTheCoordinateArguments() {
        List<Coordinate> fakeObstacles = Collections.singletonList(new Coordinate(3, 1));
        return Stream.of(
                arguments(Collections.emptyList(), new Coordinate(0, 0), false),
                arguments(Collections.emptyList(), new Coordinate(0, 0), false),
                arguments(fakeObstacles, new Coordinate(3, 1), true),
                arguments(fakeObstacles, new Coordinate(2, 1), false),
                arguments(fakeObstacles, new Coordinate(3, 1), true));
    }
}
