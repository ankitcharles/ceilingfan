package com.teacup.ceilingfan.service;
public interface FanService {
    void pullSpeedCord();
    void pullDirectionCord();
    String getStatus();
    boolean isClockwise();
    int getSpeed();
}
