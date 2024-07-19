package com.teacup.ceilingfan.model;

import lombok.Getter;

public class CeilingFan {
    @Getter
    private int speed;
    private boolean isClockwise;

    public CeilingFan() {
        this.speed = 0;
        this.isClockwise = true;
    }

    public void pullSpeedCord() {
        speed = (speed + 1) % 4;
    }

    public void pullDirectionCord() {
        isClockwise = !isClockwise;
    }

    public boolean isClockwise() {
        return isClockwise;
    }

    public String getStatus() {
        String direction = isClockwise ? "clockwise" : "counter-clockwise";
        return String.format("Fan speed: %d, Direction: %s", speed, direction);
    }
}
