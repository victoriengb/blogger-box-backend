package com.dauphine.blogger_box_backend.service;

import com.dauphine.blogger_box_backend.model.Category;
import com.dauphine.blogger_box_backend.model.Post;
import com.dauphine.blogger_box_backend.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class PostServiceImpl implements PostService {

    //public final List<Post> temporaryPosts;

    private final PostRepository postRepository;
    /*
    public PostServiceImpl() {
        this.temporaryPosts = new ArrayList<>();

        this.temporaryPosts.add(new Post(
                UUID.randomUUID(),
                "First Post",
                "Content of First Post",
                LocalDateTime.now(),
                new Category()
        ));

        this.temporaryPosts.add(new Post(
                UUID.randomUUID(),
                "Second Post",
                "Content of Second Post",
                LocalDateTime.now(),
                new Category()
        ));

        this.temporaryPosts.add(new Post(
                UUID.randomUUID(),
                "Third Post",
                "Content of Third Post",
                LocalDateTime.now(),
                new Category()
        ));

    }

     */

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }
    @Override
    public List<Post> getAllByCategoryId(UUID categoryId) {
        /*
        return this.temporaryPosts.stream()
                .filter(post -> post.getCategoryId() != null && post.getCategoryId().equals(categoryId))
                .toList();

         */
        //return this.postRepository.getPostsByCategoryId(categoryId);
        return this.postRepository.findAllByCategory_Id(categoryId);
    }

    @Override
    public List<Post> getAll() {
        //return this.temporaryPosts;
        return this.postRepository.findAll();
    }

    @Override
    public List<Post> getAllByTitleOrContent(String search) {
        return this.postRepository.findAllByTitleOrContent(search);
    }

    @Override
    public Post getById(UUID id) {
        /*
        return temporaryPosts.stream()
                .filter(post -> post.getId().equals(id))
                .findFirst()
                .orElse(null);

         */
        return this.postRepository.findById(id)
                .orElse(null);
    }

    @Override
    public Post create(String title, String content, Category category) {

        Post post = new Post(UUID.randomUUID(), title, content, LocalDateTime.now(), category);
        /*
        this.temporaryPosts.add(post);
        return post;

         */
        return this.postRepository.save(post);
    }

    @Override
    public Post update(UUID id, String title, String content) {
        Post post = this.getById(id);
        if (post == null) {
            return null;
        }
        post.setTitle(title);
        post.setContent(content);
        return this.postRepository.save(post);
    }

    @Override
    public UUID deleteById(UUID id) {
        /*
        if (temporaryPosts.removeIf(post -> post.getId().equals(id))){
            return id;
        }

         */
        this.postRepository.deleteById(id);
        return id;
    }
}
