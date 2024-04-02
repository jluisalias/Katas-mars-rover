package com.java.katas.marsrover;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RoverShould {

	/**
	 * "L, 0:0:W",
	 * "LL, 0:0:S",
	 * "LLL, 0:0:E",
	 * "LLLL, 0:0:N"
	 */

	@ParameterizedTest
	@ValueSource(strings = { "1", "3", "5", "-3", "15", "Integer.MAX_VALUE" })
	void forNowTheRoverDoesntDoAnything(String input) {
		assertTrue(true);
	}

}
