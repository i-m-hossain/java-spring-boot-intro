package com.imran.example.learningspringboot.repository;

import com.imran.example.learningspringboot.model.Content;
import org.springframework.data.repository.ListCrudRepository;

public interface ContentRepository extends ListCrudRepository<Content, Integer> {

}
