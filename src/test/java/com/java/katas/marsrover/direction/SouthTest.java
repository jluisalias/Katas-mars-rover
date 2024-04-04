package com.java.katas.marsrover.direction;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SouthTest {
    private South southSUT;

    @BeforeEach
    public void initialize() {
        southSUT = South.getSouth();
    }

    @Test
    public void turnLeft_ShouldReturnCorrectDirection() {
        assertEquals(East.getEast(), southSUT.turnLeft());
    }

    @Test
    public void turnRight_ShouldReturnCorrectDirection() {
        assertEquals(West.getWest(), southSUT.turnRight());
    }

    @Test
    public void returnName_ShouldReturnCorrectName() {
        assertEquals("South", southSUT.returnName());
    }

    @Test
    public void returnDirectionCoordinate_ShouldReturnCorrectLetter() {
        assertEquals("S", southSUT.returnDirectionCoordinate());
    }
}
