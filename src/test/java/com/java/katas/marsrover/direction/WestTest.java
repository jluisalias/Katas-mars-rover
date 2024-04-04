package com.java.katas.marsrover.direction;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class WestTest {
    private West westSUT;

    @BeforeEach
    public void initialize() {
        westSUT = West.getWest();
    }

    @Test
    public void turnLeft_ShouldReturnCorrectDirection() {
        assertEquals(South.getSouth(), westSUT.turnLeft());
    }

    @Test
    public void turnRight_ShouldReturnCorrectDirection() {
        assertEquals(North.getNorth(), westSUT.turnRight());
    }

    @Test
    public void returnName_ShouldReturnCorrectName() {
        assertEquals("West", westSUT.returnName());
    }

    @Test
    public void returnDirectionCoordinate_ShouldReturnCorrectLetter() {
        assertEquals("W", westSUT.returnDirectionCoordinate());
    }
}
