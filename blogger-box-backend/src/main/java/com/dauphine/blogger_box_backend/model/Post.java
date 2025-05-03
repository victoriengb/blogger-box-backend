package com.dauphine.blogger_box_backend.model;


import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;

public class Post {
    UUID id;
    String title;
    String content;
    LocalDateTime created_date;
    UUID category_id;

    public Post() {
        this.id = UUID.randomUUID();
        this.title = "";
        this.content = "";
        this.created_date = LocalDateTime.now();
        this.category_id = null;
    }

    public Post(UUID id, String title, String content, LocalDateTime created_date, UUID category_id) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.created_date = created_date;
        this.category_id = category_id;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getCreated_date() {
        return created_date;
    }

    public UUID getCategoryId() {
        return category_id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCreated_date(LocalDateTime created_date) {
        this.created_date = created_date;
    }

    public void setCategory_id(UUID category_id) {
        this.category_id = category_id;
    }
}