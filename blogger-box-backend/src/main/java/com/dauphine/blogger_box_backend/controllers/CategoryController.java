package com.dauphine.blogger_box_backend.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dauphine.blogger_box_backend.model.Category;
import com.dauphine.blogger_box_backend.service.CategoryService;


@RestController
@RequestMapping("/v1/categories")
public class CategoryController {

    private final CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    
    @GetMapping
    public List<Category> getAllCategories() {
        return this.service.getAll();
    }


    @GetMapping("{id}")
    public Category getCategoryById(@PathVariable UUID id) {
        return this.service.getById(id);
    }

    @PostMapping
    public Category createCategory(@RequestBody String name) {
        return this.service.create(name);
    }

    @PutMapping("{id}")
    public Category updateCategory(@PathVariable UUID id, @RequestBody String name) {
        return service.update(id, name);
    }

    @DeleteMapping ("{id}")
    public UUID deleteCategoryByID(@PathVariable UUID id) {
        return this.service.deleteById(id);
    }
}
