package com.imran.example.learningspringboot.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.imran.example.learningspringboot.model.Content;
import com.imran.example.learningspringboot.repository.ContentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Profile("!dev") //runs if the profile is not dev
@Component
public class DataLoader implements CommandLineRunner {
    private final ContentRepository repository;
    private final ObjectMapper objectMapper;

    public DataLoader(ContentRepository repository, ObjectMapper objectMapper) {
        this.repository = repository;
        this.objectMapper = objectMapper;
    }

    @Override
    public void run(String... args) throws Exception {
        //  reading data from a JSON file
        try (InputStream inputStream = TypeReference.class.getResourceAsStream("/data/data.json")) {
            repository.saveAll(objectMapper.readValue(inputStream, new TypeReference<List<Content>>() {
            }));
        } catch (IOException e) {
            // Handle the exception appropriately (e.g., logging, error handling)
            e.printStackTrace();
        }
    }

}
