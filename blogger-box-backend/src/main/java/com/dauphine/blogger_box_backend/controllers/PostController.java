package com.dauphine.blogger_box_backend.controllers;

import java.util.List;
import java.util.UUID;

import com.dauphine.blogger_box_backend.service.CategoryService;
import com.dauphine.blogger_box_backend.service.CategoryServiceImpl;
import com.dauphine.blogger_box_backend.service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import com.dauphine.blogger_box_backend.model.Category;
import com.dauphine.blogger_box_backend.model.Post;

@RestController
@RequestMapping("/v1/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService service) {
        this.postService = service;
    }


    @GetMapping
    @Operation(
            summary = "Get all posts",
            description = "Retrieve all posts or filter by title or content"
    )
    public List<Post> getAllPosts(@RequestParam(required = false) String search) {

        return search == null || search.isBlank()
                ? this.postService.getAll()
                : this.postService.getAllByTitleOrContent(search);
    }

    @GetMapping("/{id}")
    public Post getPostById(@PathVariable UUID id) {
        return postService.getById(id);
    }

    @GetMapping("/category/{categoryId}")
    public List<Post> getPostsByCategoryId(@PathVariable UUID categoryId) {
        return postService.getAllByCategoryId(categoryId);
    }

    @PostMapping
    public Post createPost(@RequestParam String title,
                           @RequestParam String content,
                           @RequestParam UUID categoryId) {
        Category category = new Category();
        category.setId(categoryId);
        return postService.create(title, content, category);
    }

    @PutMapping("/{id}")
    public Post updatePost(@PathVariable UUID id,
                           @RequestParam String title,
                           @RequestParam String content) {
        return postService.update(id, title, content);
    }

    @DeleteMapping("/{id}")
    public UUID deletePost(@PathVariable UUID id) {
        return postService.deleteById(id);
    }
}
