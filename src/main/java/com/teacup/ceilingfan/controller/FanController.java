package com.teacup.ceilingfan.controller;

import com.teacup.ceilingfan.service.FanService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fan")
@Tag(name = "Ceiling Fan Controller", description = "API to control a ceiling fan")
public class FanController {

    @Autowired
    private FanService fanService;

    @GetMapping("/status")
    public String getStatus() {
        return fanService.getStatus();
    }

    @PostMapping("/speed")
    public String pullSpeedCord() {
        fanService.pullSpeedCord();
        return fanService.getStatus();
    }

    @PostMapping("/direction")
    public String pullDirectionCord() {
        fanService.pullDirectionCord();
        return fanService.getStatus();
    }

    @GetMapping("/speed")
    public int getSpeed() {
        return fanService.getSpeed();
    }

    @GetMapping("/direction")
    public boolean isClockwise() {
        return fanService.isClockwise();
    }
}
