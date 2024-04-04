package com.java.katas.marsrover.direction;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class NorthTest {

    private North northSUT;

    @BeforeEach
    public void initialize() {
        northSUT = North.getNorth();
    }

    @Test
    public void turnLeft_ShouldReturnCorrectDirection() {
        assertEquals(West.getWest(), northSUT.turnLeft());
    }

    @Test
    public void turnRight_ShouldReturnCorrectDirection() {
        assertEquals(East.getEast(), northSUT.turnRight());
    }

    @Test
    public void returnName_ShouldReturnCorrectName() {
        assertEquals("North", northSUT.returnName());
    }

    @Test
    public void returnDirectionCoordinate_ShouldReturnCorrectLetter() {
        assertEquals("N", northSUT.returnDirectionCoordinate());
    }
}
