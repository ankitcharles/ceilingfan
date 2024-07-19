package com.teacup.ceilingfan.controller;

import com.teacup.ceilingfan.service.FanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fan")
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
}
