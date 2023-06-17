package com.imran.example.learningspringboot.controller;

import com.imran.example.learningspringboot.config.ContentProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    private final ContentProperties properties;

    public HomeController(ContentProperties properties) {
        this.properties = properties;
    }

    @GetMapping("/")
    public ContentProperties home() {
        return properties;
    }
//    public Map<String, String> greeting() {
//        return Map.of("welcome", properties.welcomeMessage(), "about", properties.about());
//
//    }
}
