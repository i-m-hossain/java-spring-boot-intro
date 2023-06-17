package com.imran.example.learningspringboot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(value = "content")
public record ContentProperties(String welcomeMessage, String about) {

}
