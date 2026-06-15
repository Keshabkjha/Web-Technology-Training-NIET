package com.keshab.springboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @RequestMapping
    public String hello() {
        return "Hello World from SpringBoot";
    }

    @RequestMapping("/goodbye")

    public String goodbye() {
        return "Goodbye World from SpringBoot";
    }
}
