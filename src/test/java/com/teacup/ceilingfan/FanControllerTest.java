package com.teacup.ceilingfan;

import com.teacup.ceilingfan.controller.FanController;
import com.teacup.ceilingfan.service.FanService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class FanControllerTest {

    @InjectMocks
    private FanController fanController;

    @Mock
    private FanService fanService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetStatus() {
        when(fanService.getStatus()).thenReturn("Fan speed: 0, Direction: clockwise");
        String status = fanController.getStatus();
        assertEquals("Fan speed: 0, Direction: clockwise", status);
        verify(fanService, times(1)).getStatus();
    }

    @Test
    void testPullSpeedCord() {
        when(fanService.getStatus()).thenReturn("Fan speed: 1, Direction: clockwise");
        String status = fanController.pullSpeedCord();
        assertEquals("Fan speed: 1, Direction: clockwise", status);
        verify(fanService, times(1)).pullSpeedCord();
    }

    @Test
    void testPullDirectionCord() {
        when(fanService.getStatus()).thenReturn("Fan speed: 0, Direction: counter-clockwise");
        String status = fanController.pullDirectionCord();
        assertEquals("Fan speed: 0, Direction: counter-clockwise", status);
        verify(fanService, times(1)).pullDirectionCord();
    }

    @Test
    void testGetSpeed() {
        when(fanService.getSpeed()).thenReturn(1);
        int speed = fanController.getSpeed();
        assertEquals(1, speed);
        verify(fanService, times(1)).getSpeed();
    }
    @Test
    void testIsClockwise() {
        when(fanService.isClockwise()).thenReturn(false);
        boolean isClockwise = fanController.isClockwise();
        assertFalse(isClockwise);
        verify(fanService, times(1)).isClockwise();
    }
}
