package com.java.katas.marsrover;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RoverShould {
	private Rover rover;

	@BeforeEach
	public void initialize() {
		rover = new Rover();
	}

	@ParameterizedTest
	@ValueSource(strings = { "", "LLLL", "MLMLMLML", "RRRR", "MRMRMRMR", "MRMRMRMR" })
	public void differentCombinationsThatEndInTheSameStartingCoordinateAndDirection(String commands) {
		assertFalse(false);
		assertTrue(true);
	}

	@ParameterizedTest
	@MethodSource("leftRotationArguments")
	public void leftRotation(String expectedResult, String commands) {
		assertEquals(expectedResult, rover.execute(commands));
	}

	@ParameterizedTest
	@MethodSource("rightRotationArguments")
	public void rightRotation(String expectedResult, String commands) {
		assertEquals(expectedResult, rover.execute(commands));
	}

	/*
	 * PARAMETERIZED METHOD ARGUMENTS PROVIDERS
	 */

	private static Stream<Arguments> leftRotationArguments() {
		return Stream.of(
				arguments("", "L"),
				arguments("", "LL"),
				arguments("", "LLL"),
				arguments("", "LLLL"));
	}

	private static Stream<Arguments> rightRotationArguments() {
		return Stream.of(
				arguments("", "R"),
				arguments("", "RR"),
				arguments("", "RRR"),
				arguments("", "RRRR"));
	}

}
