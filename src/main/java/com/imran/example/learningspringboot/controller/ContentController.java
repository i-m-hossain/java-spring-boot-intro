package com.imran.example.learningspringboot.controller;

import com.imran.example.learningspringboot.model.Content;
import com.imran.example.learningspringboot.repository.ContentRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/content")
@CrossOrigin
public class ContentController {
    //in memory db
    //    private final ContentCollectionRepository repository;

    //h2 db
    private final ContentRepository repository;

    public ContentController(ContentRepository repository) {
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
    public void insertContent(@Valid @RequestBody Content contentBody) {
        repository.save(contentBody);
    }

    /* --Update content-- */
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void updateContent(@RequestBody Content contentBody, @PathVariable Integer id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content Not Found");
        }
        repository.save(contentBody);
    }

    /* --delete content-- */
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteContent(@PathVariable Integer id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content Not Found");
        }
        repository.deleteById(id);
    }

}
