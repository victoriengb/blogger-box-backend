package com.dauphine.blogger_box_backend.service;

import com.dauphine.blogger_box_backend.model.Category;
import com.dauphine.blogger_box_backend.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CategoryServiceImpl implements CategoryService {

    //public final List<Category> temporaryCategories;

    private final CategoryRepository categoryRepository;

    /*
    public CategoryServiceImpl(){
        this.temporaryCategories = new ArrayList<Category>();
        this.temporaryCategories.add(new Category(UUID.randomUUID(), "my first category"));
        this.temporaryCategories.add(new Category(UUID.randomUUID(), "my second category"));
        this.temporaryCategories.add(new Category(UUID.randomUUID(), "my third category"));
    }

     */

    public CategoryServiceImpl(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }
    @Override
    public List<Category> getAll() {
        //return temporaryCategories;
        return this.categoryRepository.findAll();
    }

    @Override
    public Category getById(UUID id) {
        /*
        return temporaryCategories.stream()
                .filter(category -> category.getId().equals(id))
                .findFirst()
                .orElse(null);

         */
        return this.categoryRepository.findById(id)
                .orElse(null);
    }

    @Override
    public Category create(String name) {
        Category category = new Category(UUID.randomUUID(), name);
        //temporaryCategories.add(category);
        //return category;
        return this.categoryRepository.save(category);
    }

    @Override
    public Category update(UUID id, String name) {
        Category category = this.getById(id);
        if (category == null) {
            return null;
        }
        category.setName(name);
        return this.categoryRepository.save(category);
    }

    @Override
    public UUID deleteById(UUID id) {
        /*
        if (temporaryCategories.removeIf(category -> category.getId().equals(id))){
            return id;
        }
        return null;

         */
        this.categoryRepository.deleteById(id);
        return id;
    }
}
