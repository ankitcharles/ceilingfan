package com.teacup.ceilingfan.service;

import com.teacup.ceilingfan.model.CeilingFan;
import org.springframework.stereotype.Service;

@Service
public class FanServiceImpl implements FanService {

    private final CeilingFan ceilingFan;

    public FanServiceImpl() {
        this.ceilingFan = new CeilingFan();
    }
    @Override
    public void pullSpeedCord() {
        ceilingFan.pullSpeedCord();
    }

    @Override
    public void pullDirectionCord() {
        ceilingFan.pullDirectionCord();
    }

    @Override
    public int getSpeed() {
        return ceilingFan.getSpeed();
    }

    @Override
    public String getStatus() {
        return ceilingFan.getStatus();
    }
    @Override
    public boolean isClockwise() {
        return ceilingFan.isClockwise();
    }
}
