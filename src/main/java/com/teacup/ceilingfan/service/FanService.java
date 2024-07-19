package com.teacup.ceilingfan.service;

import org.springframework.stereotype.Service;

@Service
public class FanService {

    private int speed;
    private boolean isClockwise;

    public FanService() {
        this.speed = 0;
        this.isClockwise = true;
    }

    public void pullSpeedCord() {
        speed = (speed + 1) % 4;
    }

    public void pullDirectionCord() {
        isClockwise = !isClockwise;
    }

    public int getSpeed() {
        return speed;
    }

    public boolean isClockwise() {
        return isClockwise;
    }

    public String getStatus() {
        String direction = isClockwise ? "clockwise" : "counter-clockwise";
        return String.format("Fan speed: %d, Direction: %s", speed, direction);
    }
}
