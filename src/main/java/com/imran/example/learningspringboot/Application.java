package com.imran.example.learningspringboot;

import com.imran.example.learningspringboot.config.ContentProperties;
import com.imran.example.learningspringboot.model.Content;
import com.imran.example.learningspringboot.model.Status;
import com.imran.example.learningspringboot.model.Type;
import com.imran.example.learningspringboot.repository.ContentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@EnableConfigurationProperties(ContentProperties.class)
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
//		printing out all the beans
//		Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
    }

    @Bean
    CommandLineRunner commandLineRunner(ContentRepository repository) {
        return args -> {
            Content content = new Content(null, "Hello people", "All about gpt", Status.IDEA, Type.VIDEO, LocalDateTime.now(), null, "");
            repository.save(content);
        };
    }

}
