package com.imran.example.learningspringboot.repository;

import com.imran.example.learningspringboot.model.Content;
import com.imran.example.learningspringboot.model.Status;
import com.imran.example.learningspringboot.model.Type;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository
public class ContentCollectionRepository {
    private final List<Content> content = new ArrayList<>();
    public ContentCollectionRepository(){

    }
    public List<Content> findAll(){
        return content;
    }
    public Optional<Content> findById(Integer id){
        return content.stream().filter(c-> c.id().equals(id)).findFirst();
    }

//    public Optional<Content>insertContent(Content contentBody){
//        return content.add(contentBody);
//    }
    @PostConstruct
    private void init(){
        Content content1 = new Content(1,  "this is title", "this is description", Status.IDEA, Type.ARTICLE, LocalDateTime.now(), null,  "");
        Content content2 = new Content(2,  "this is title2", "this is description2", Status.IDEA, Type.ARTICLE, LocalDateTime.now(), null,  "");
        content.add(content1);
        content.add(content2);
    }

}
