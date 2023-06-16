package com.imran.example.learningspringboot.repository;

import com.imran.example.learningspringboot.model.Content;
import com.imran.example.learningspringboot.model.Status;
import com.imran.example.learningspringboot.model.Type;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class ContentJdbcTemplateRepository {
    private final JdbcTemplate jdbcTemplate;

    public ContentJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static Content mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Content(rs.getInt("id"),
                rs.getString("title"),
                rs.getString("description"),
                Status.valueOf(rs.getString("status")),
                Type.valueOf(rs.getString("content_type")),
                rs.getObject("date_created", LocalDateTime.class),
                rs.getObject("date_updated", LocalDateTime.class),
                rs.getString("url"));
    }

    //find all
    public List<Content> findAll() {
        String sql = "SELECT * FROM Content";
        List<Content> contents = jdbcTemplate.query(sql, ContentJdbcTemplateRepository::mapRow);
        return contents;
    }

    //find by id
    public Content findById(int id) {
        String sql = "SELECT * FROM Content WHERE id=?";
        Content content = jdbcTemplate.queryForObject(sql, new Object[]{id}, ContentJdbcTemplateRepository::mapRow);
        return content;
    }

    // create content
    public void insertOne(String title, String desc, String status, String contentType, String URL) {
        String sql = "INSERT INTO Content (title, description, status, content_type, date_created, URL) VALUES (?, ?, ?, ?, NOW(), ?)";
        jdbcTemplate.update(sql, title, desc, status, contentType, URL);
    }

    // update content
    public void updateOne(int id, String title, String desc, String status, String contentType, String URL) {
        String sql = "UPDATE Content SET title=?, description=?, status=?, content_type=?, date_updated=NOW(), url=? WHERE id=?";
        jdbcTemplate.update(sql, title, desc, status, contentType, URL, id);
    }

    //delete content
    public void deleteOne(int id) {
        String sql = "DELETE FROM Content WHERE id=?";
        jdbcTemplate.update(sql, id);
    }


}
