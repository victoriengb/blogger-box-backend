package com.dauphine.blogger_box_backend.service;

import com.dauphine.blogger_box_backend.model.Category;
import com.dauphine.blogger_box_backend.model.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import java.sql.Timestamp;

@Service
public class PostServiceImpl implements PostService {

    public final List<Post> temporaryPosts;

    public PostServiceImpl() {
        this.temporaryPosts = new ArrayList<>();

        this.temporaryPosts.add(new Post(
                UUID.randomUUID(),
                "First Post",
                "Content of First Post",
                new Timestamp(System.currentTimeMillis()),
                UUID.randomUUID()
        ));

        this.temporaryPosts.add(new Post(
                UUID.randomUUID(),
                "Second Post",
                "Content of Second Post",
                new Timestamp(System.currentTimeMillis()),
                UUID.randomUUID()
        ));

        this.temporaryPosts.add(new Post(
                UUID.randomUUID(),
                "Third Post",
                "Content of Third Post",
                new Timestamp(System.currentTimeMillis()),
                UUID.randomUUID()
        ));

    }
    @Override
    public List<Post> getAllByCategoryId(UUID categoryId) {
        return this.temporaryPosts.stream()
                .filter(post -> post.getCategoryId() != null && post.getCategoryId().equals(categoryId))
                .toList();
    }

    @Override
    public List<Post> getAll() {
        return this.temporaryPosts;
    }

    @Override
    public Post getById(UUID id) {
        return temporaryPosts.stream()
                .filter(post -> post.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Post create(String title, String content, UUID categoryId) {
        Post post = new Post(UUID.randomUUID(), title, content, new Timestamp(System.currentTimeMillis()), categoryId);
        this.temporaryPosts.add(post);
        return post;
    }

    @Override
    public Post update(UUID id, String title, String content) {
        Post post = this.getById(id);
        if (post != null) {
            post.setTitle(title);
            post.setContent(content);
        }
        return post;
    }

    @Override
    public UUID deleteById(UUID id) {
        if (temporaryPosts.removeIf(post -> post.getId().equals(id))){
            return id;
        }
        return null;
    }
}
