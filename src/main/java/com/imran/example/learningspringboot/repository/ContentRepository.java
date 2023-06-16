package com.imran.example.learningspringboot.repository;

import com.imran.example.learningspringboot.model.Content;
import com.imran.example.learningspringboot.model.Status;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContentRepository extends ListCrudRepository<Content, Integer> {
    List<Content> findAllByTitleContains(String keyword);

    @Query("""
                SELECT  * FROM  content 
                where status = :status
            """)
    List<Content> listByStatus(@Param("status") Status status);
}
