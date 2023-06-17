package com.imran.example.learningspringboot;

import com.imran.example.learningspringboot.config.ContentProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;

@EnableConfigurationProperties(ContentProperties.class)
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
//		printing out all the beans
//		Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
    }

}
