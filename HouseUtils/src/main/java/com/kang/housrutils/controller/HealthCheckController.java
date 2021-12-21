package com.kang.housrutils.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kang
 *
 * 서비스 헬스체크를 위한 컨트롤러러
 * */
@RestController
public class HealthCheckController {

    @GetMapping("/api/ping")
    public String ping(){
        return "ok";
    }
}
