package com.imran.example.learningspringboot.controller;

import com.imran.example.learningspringboot.model.Content;
import com.imran.example.learningspringboot.repository.ContentCollectionRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/content")
public class ContentController {
    private final ContentCollectionRepository repository;

    public ContentController(ContentCollectionRepository repository) {
        this.repository = repository;
    }
    @GetMapping("")
    public List<Content> fetchAllContents(){
        return repository.findAll();
    }


    @GetMapping("/{id}")
    public Content getContentById(@PathVariable Integer id){
        return repository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Content Not Found"));
    }
    //    @PostMapping ("")
//    public Optional<Content> insertContent(@ResponseBody Content contentBody){
//        return repository.insertContent(contentBody);
//    }

}
