package com.imran.example.learningspringboot.controller;

import com.imran.example.learningspringboot.model.Content;
import com.imran.example.learningspringboot.repository.ContentCollectionRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/content")
@CrossOrigin
public class ContentController {
    private final ContentCollectionRepository repository;

    public ContentController(ContentCollectionRepository repository) {
        this.repository = repository;
    }

    /* --GET ALL THE CONTENTS-- */
    @GetMapping("")
    public List<Content> fetchAllContents() {
        return repository.findAll();
    }

    /* --GET SINGLE CONTENT-- */
    @GetMapping("/{id}")
    public Content getContentById(@PathVariable Integer id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Content Not Found"));
    }

    /* --Insert content-- */
    @ResponseStatus(HttpStatus.CREATED) //send 201 status
    @PostMapping("")
    public Content insertContent(@Valid @RequestBody Content contentBody) {
        repository.insertOne(contentBody);
        return contentBody;
    }

    /* --Update content-- */
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void updateContent(@RequestBody Content contentBody, @PathVariable Integer id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content Not Found");
        }
        repository.updateOne(contentBody, id);
    }

    /* --delete content-- */
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteContent(@PathVariable Integer id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content Not Found");
        }
        repository.deleteOne(id);
    }

}
