package com.dauphine.blogger_box_backend.dto;

import com.dauphine.blogger_box_backend.model.Category;

import java.util.UUID;

public class PostDTO {
    String title;
    String content;
    //Category category;
    UUID categoryId;
    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    /*
    public Category getCategory() {
        return category;
    }

     */

    public UUID getCategoryId() {
        return categoryId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    /*
    public void setCategoryId(Category category) {
        this.category = category;
    }

     */

    public void setCategoryId(UUID categoryId) {
        this.categoryId = categoryId;
    }
}
