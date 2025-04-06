package com.dauphine.blogger_box_backend.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dauphine.blogger_box_backend.model.Category;
import com.dauphine.blogger_box_backend.model.Post;

@RestController
public class PostController {
    @GetMapping("/v1/posts/{date}")
    public String getPostsByDate(@PathVariable String date) {
        // Logic to retrieve posts by date
        return "Posts for date: " + date;
    }

    @GetMapping("/v1/categories/{id}/posts")
    public List<Category> getPostsByCategoryId(@RequestParam String id) {
        return null;
    }

    @PostMapping("/v1/posts")
    public String createPost(@RequestBody Post post) {
        // Logic to create a new post
        return "Post created: " + post;
    }

    @DeleteMapping("/v1/posts/{id}")
    public String deletePostById(@PathVariable String id) {
        // Logic to delete a post by ID
        return "Post deleted with ID: " + id;
    }
}
