package com.java.katas.marsrover;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.Collections;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;

import com.java.katas.marsrover.coordinate.Coordinate;
import com.java.katas.marsrover.grid.Grid;

@SpringBootTest
class RoverShould {
	private Rover rover;

	@BeforeEach
	public void initialize() {
		rover = new Rover(new Grid(Collections.singletonList(new Coordinate(3, 1))));
	}

	@ParameterizedTest
	@ValueSource(strings = { "", "LLLL", "MLMLMLML", "RRRR", "MRMRMRMR", "MRMRMRMR" })
	public void differentCombinationsThatEndInTheSameStartingCoordinateAndDirection(String commands) {
		assertEquals("0:0:N", rover.perform(commands));
	}

	@ParameterizedTest
	@MethodSource("leftRotationArguments")
	public void leftRotation(String expectedResult, String commands) {
		assertEquals(expectedResult, rover.perform(commands));
	}

	@ParameterizedTest
	@MethodSource("rightRotationArguments")
	public void rightRotation(String expectedResult, String commands) {
		assertEquals(expectedResult, rover.perform(commands));
	}

	@ParameterizedTest
	@MethodSource("northMovementArguments")
	public void moveNorth(String expectedResult, String commands) {
		assertEquals(expectedResult, rover.perform(commands));
	}

	@ParameterizedTest
	@MethodSource("eastMovementArguments")
	public void moveEast(String expectedResult, String commands) {
		assertEquals(expectedResult, rover.perform(commands));
	}

	@ParameterizedTest
	@MethodSource("southMovementArguments")
	public void moveSouth(String expectedResult, String commands) {
		assertEquals(expectedResult, rover.perform(commands));
	}

	@ParameterizedTest
	@MethodSource("westMovementArguments")
	public void moveWest(String expectedResult, String commands) {
		assertEquals(expectedResult, rover.perform(commands));
	}

	@ParameterizedTest
	@MethodSource("tenRandomCommandsArguments")
	public void randomMovementTests(String expectedResult, String commands) {
		assertEquals(expectedResult, rover.perform(commands));
	}

	@ParameterizedTest
	@MethodSource("hitTheObstacleArguments")
	public void hitTheObstacleTests(String expectedResult, String commands) {
		assertEquals(expectedResult, rover.perform(commands));
	}

	/*
	 * PARAMETERIZED METHOD ARGUMENTS PROVIDERS
	 */

	private static Stream<Arguments> leftRotationArguments() {
		return Stream.of(
				arguments("0:0:W", "L"),
				arguments("0:0:S", "LL"),
				arguments("0:0:E", "LLL"),
				arguments("0:0:N", "LLLL"));
	}

	private static Stream<Arguments> rightRotationArguments() {
		return Stream.of(
				arguments("0:0:E", "R"),
				arguments("0:0:S", "RR"),
				arguments("0:0:W", "RRR"),
				arguments("0:0:N", "RRRR"));
	}

	private static Stream<Arguments> northMovementArguments() {
		return Stream.of(
				arguments("0:1:N", "M"),
				arguments("0:5:N", "MMMMM"),
				arguments("0:0:N", "MMMMMMMMMM"),
				arguments("0:5:N", "MMMMMMMMMMMMMMM"));
	}

	private static Stream<Arguments> eastMovementArguments() {
		return Stream.of(
				arguments("1:0:E", "RM"),
				arguments("5:0:E", "RMMMMM"),
				arguments("0:0:E", "RMMMMMMMMMM"),
				arguments("5:0:E", "RMMMMMMMMMMMMMMM"));
	}

	private static Stream<Arguments> southMovementArguments() {
		return Stream.of(
				arguments("0:9:S", "RRM"),
				arguments("0:5:S", "RRMMMMM"),
				arguments("0:0:S", "RRMMMMMMMMMM"),
				arguments("0:5:S", "RRMMMMMMMMMMMMMMM"));
	}

	private static Stream<Arguments> westMovementArguments() {
		return Stream.of(
				arguments("9:0:W", "LM"),
				arguments("5:0:W", "LMMMMM"),
				arguments("0:0:W", "LMMMMMMMMMM"),
				arguments("5:0:W", "LMMMMMMMMMMMMMMM"));
	}

	private static Stream<Arguments> tenRandomCommandsArguments() {
		return Stream.of(
				arguments("1:1:S", "MMRMLMLLMM"),
				arguments("8:9:E", "LMMMLMRRRM"),
				arguments("1:0:W", "LMMMMMMMMM"),
				arguments("0:4:N", "MLRMLRMLRM"));
	}

	private static Stream<Arguments> hitTheObstacleArguments() {
		return Stream.of(
				arguments("0:2:1:E", "MRMMM"),
				arguments("0:3:0:N", "RMMMLM"),
				arguments("0:4:1:W", "MLMMMMMMM"),
				arguments("0:3:2:S", "RMMMRMMMMMMMMM"));
	}

}
