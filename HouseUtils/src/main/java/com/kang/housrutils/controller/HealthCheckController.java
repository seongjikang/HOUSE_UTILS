package com.kang.housrutils.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kang
 */
@RestController
public class HealthCheckController {

    @GetMapping("/api/ping")
    public String ping(){
        return "ok";
    }
}
