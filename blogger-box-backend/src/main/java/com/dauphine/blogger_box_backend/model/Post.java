package com.dauphine.blogger_box_backend.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "post")
public class Post {
    @Id
    @Column(name = "id")
    UUID id;
    @Column(name = "title")
    String title;
    @Column(name = "content")
    String content;
    @Column(name = "created_date")
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    LocalDateTime createdDate;
    @ManyToOne
    @JoinColumn(name = "category_id")
    Category category;

    public Post() {
        this.id = UUID.randomUUID();
        this.title = "";
        this.content = "";
        this.createdDate = LocalDateTime.now();
        this.category = new Category();
    }

    public Post(UUID id, String title, String content, LocalDateTime createdDate, Category category) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdDate = createdDate;
        this.category = category;
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

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public UUID getCategoryId() {
        return category.getId();
    }

    public Category getCategory() {
        return category;
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

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}