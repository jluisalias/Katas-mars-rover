package com.java.katas.marsrover.coordinate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CoordinateTest {

    private Coordinate coordinateSUT;

    @ParameterizedTest
    @MethodSource("coordinatesArguments")
    public void returnFormattedCoordinate_ShouldReturnTheCoordinateInTheStringRoverFormat(String formattedCoordinate,
            int x, int y) {
        coordinateSUT = new Coordinate(x, y);
        assertEquals(formattedCoordinate, coordinateSUT.returnFormattedCoordinate());
    }

    @ParameterizedTest
    @MethodSource("coordinatesArguments")
    public void returnX_ShouldReturnTheXCoordinate(String formattedCoordinate,
            int x, int y) {
        coordinateSUT = new Coordinate(x, y);
        assertEquals(x, coordinateSUT.x());
    }

    @ParameterizedTest
    @MethodSource("coordinatesArguments")
    public void returnY_ShouldReturnTheYCoordinate(String formattedCoordinate,
            int x, int y) {
        coordinateSUT = new Coordinate(x, y);
        assertEquals(y, coordinateSUT.y());
    }

    @ParameterizedTest
    @MethodSource("coordinatesArguments")
    public void equals_ShouldCompareByXAndY(String formattedCoordinate,
            int x, int y) {
        coordinateSUT = new Coordinate(x, y);
        Coordinate anotherCoordinate = new Coordinate(x, y);
        assertTrue(coordinateSUT.equals(anotherCoordinate));
    }

    @ParameterizedTest
    @MethodSource("coordinatesArguments")
    public void hashCode_ShouldReturnSameHashForEqualCoordinates(String formattedCoordinate,
            int x, int y) {
        coordinateSUT = new Coordinate(x, y);
        Coordinate anotherCoordinate = new Coordinate(x, y);
        assertEquals(coordinateSUT.hashCode(), (anotherCoordinate.hashCode()));
    }

    /*
     * PARAMETERIZED METHOD ARGUMENTS PROVIDERS
     */

    private static Stream<Arguments> coordinatesArguments() {
        return Stream.of(
                arguments("1:0", 1, 0),
                arguments("0:1", 0, 1),
                arguments("2:1", 2, 1),
                arguments("3:4", 3, 4),
                arguments("1:3", 1, 3));
    }
}
