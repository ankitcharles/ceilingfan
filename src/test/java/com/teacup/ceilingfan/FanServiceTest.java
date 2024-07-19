package com.teacup.ceilingfan;

import com.teacup.ceilingfan.service.FanService;
import com.teacup.ceilingfan.service.FanServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FanServiceTest {

    private FanService fanService;

    @BeforeEach
    void setUp() {
        fanService = new FanServiceImpl();
    }

    @Test
    void testInitialState() {
        assertEquals(0, fanService.getSpeed());
        assertTrue(fanService.isClockwise());
    }

    @Test
    void testSpeedCord() {
        fanService.pullSpeedCord();
        assertEquals(1, fanService.getSpeed());
        fanService.pullSpeedCord();
        assertEquals(2, fanService.getSpeed());
        fanService.pullSpeedCord();
        assertEquals(3, fanService.getSpeed());
        fanService.pullSpeedCord();
        assertEquals(0, fanService.getSpeed());
    }

    @Test
    void testDirectionCord() {
        assertTrue(fanService.isClockwise());
        fanService.pullDirectionCord();
        assertFalse(fanService.isClockwise());
        fanService.pullDirectionCord();
        assertTrue(fanService.isClockwise());
    }

    @Test
    void testDirectionRemainsReversed() {
        fanService.pullDirectionCord();
        assertFalse(fanService.isClockwise());
        fanService.pullSpeedCord();
        assertFalse(fanService.isClockwise());
        fanService.pullSpeedCord();
        assertFalse(fanService.isClockwise());
    }

    @Test
    void testGetStatus() {
        assertEquals("Fan speed: 0, Direction: clockwise", fanService.getStatus());
        fanService.pullSpeedCord();
        fanService.pullDirectionCord();
        assertEquals("Fan speed: 1, Direction: counter-clockwise", fanService.getStatus());
    }
}
