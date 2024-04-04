package com.java.katas.marsrover.direction;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EastTest {
    private East eastSUT;

    @BeforeEach
    public void initialize() {
        eastSUT = East.getEast();
    }

    @Test
    public void turnLeft_ShouldReturnCorrectDirection() {
        assertEquals(North.getNorth(), eastSUT.turnLeft());
    }

    @Test
    public void turnRight_ShouldReturnCorrectDirection() {
        assertEquals(South.getSouth(), eastSUT.turnRight());
    }

    @Test
    public void returnName_ShouldReturnCorrectName() {
        assertEquals("East", eastSUT.returnName());
    }

    @Test
    public void returnDirectionCoordinate_ShouldReturnCorrectLetter() {
        assertEquals("E", eastSUT.returnDirectionCoordinate());
    }
}
