package com.dauphine.blogger_box_backend.service;

import com.dauphine.blogger_box_backend.dto.PostDTO;
import com.dauphine.blogger_box_backend.model.Category;
import com.dauphine.blogger_box_backend.model.Post;

import java.util.List;
import java.util.UUID;

public interface PostService {

    public List<Post> getAllByCategoryId(UUID categoryId);

    public List<Post> getAll();

    public List<Post> getAllByTitleOrContent(String search);

    public Post getById(UUID id);

    public Post create(String title, String content, Category category);

    public Post create(PostDTO postDTO);

    public Post update(UUID id, String title, String content);

    public UUID deleteById(UUID id);
}
