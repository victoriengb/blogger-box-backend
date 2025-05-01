package com.dauphine.blogger_box_backend.service;

import com.dauphine.blogger_box_backend.model.Category;

import java.util.List;
import java.util.UUID;

public interface CategoryService {

    public List<Category> getAll();

    public Category getById(UUID id);

    public Category create(String name);

    public Category update(UUID id, String name);

    public UUID deleteById(UUID id);
}
