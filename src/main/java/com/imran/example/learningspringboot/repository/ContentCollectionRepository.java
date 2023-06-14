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
    private final List<Content> contentList = new ArrayList<>();
    public ContentCollectionRepository(){

    }
    public List<Content> findAll(){
        return contentList;
    }
    public Optional<Content> findById(Integer id){
        return contentList.stream().filter(c-> c.id().equals(id)).findFirst();
    }

    public void insertOne(Content contentBody){
//        System.out.println(contentBody);
         contentList.add(contentBody);
    }
    public void updateOne(Content contentBody, Integer id){
         contentList.removeIf(c-> c.id().equals(id));
         contentList.add(contentBody);
    }

    public void deleteOne(Integer id){
        contentList.removeIf(c-> c.id().equals(id));
    }

    @PostConstruct
    private void init(){
        Content content1 = new Content(1,  "this is title", "this is description", Status.IDEA, Type.ARTICLE, LocalDateTime.now(), null,  "");
        Content content2 = new Content(2,  "this is title2", "this is description2", Status.IDEA, Type.ARTICLE, LocalDateTime.now(), null,  "");
        contentList.add(content1);
        contentList.add(content2);
    }
    public boolean existsById(Integer id){
        return contentList.stream().filter(c-> c.id().equals(id)).count()==1;
    }



}
