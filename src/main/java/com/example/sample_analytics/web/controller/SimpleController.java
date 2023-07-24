package com.example.sample_analytics.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SimpleController {
    @GetMapping("/")
    public String start() {
        return "index";
    }
}
