package com.dauphine.blogger_box_backend.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dauphine.blogger_box_backend.model.Category;




@RestController
@RequestMapping("/v1/categories")
public class CategoryController {

    public final List<Category> temporaryCategories;

    public CategoryController(){
        this.temporaryCategories = new ArrayList<Category>();
        this.temporaryCategories.add(new Category(UUID.randomUUID(), "my first category"));
        this.temporaryCategories.add(new Category(UUID.randomUUID(), "my second category"));
        this.temporaryCategories.add(new Category(UUID.randomUUID(), "my third category"));
    }

    
    @GetMapping
    public List<Category> getAllCategories() {
        return this.temporaryCategories;
    }
    

    /*
    @GetMapping
    public String getAllCategories() {
        return this.temporaryCategories.toString();
    }
    */

    @GetMapping("{id}")
    public Category getCategoryById(@RequestParam String id) {
        return null;
    }

    @PostMapping()
    public Category createCategory(@RequestBody Category category) {
        // Logic to save the category to the database or perform other operations
        this.temporaryCategories.add(category);
        return category;
    }

    @PutMapping("{id}")
    public Category updateCategoryByID(@PathVariable String id, @RequestBody Category category) {
        // Logic to update the category with the given id in the database
        return category;
    }

    @PatchMapping("{id}")
    public Category partialUpdateCategoryByID(@PathVariable String id, @RequestBody Category category) {
        // Logic to partially update the category with the given id in the database
        return category;
        //Return response entity
        //Gérer les exceptions
    }

    @DeleteMapping ("{id}")
    public void deleteCategoryByID(@PathVariable String id) {
        // Logic to delete the category with the given id from the database
    }
}
