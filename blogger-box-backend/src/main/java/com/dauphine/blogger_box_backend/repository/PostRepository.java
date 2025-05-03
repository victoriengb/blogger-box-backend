package com.dauphine.blogger_box_backend.repository;

import com.dauphine.blogger_box_backend.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface PostRepository extends JpaRepository<Post, UUID> {
    List<Post> findAllByCategory_Id(UUID categoryId);

    @Query("""
        SELECT post
        FROM Post post
        WHERE UPPER(post.title) LIKE UPPER(CONCAT('%', :search, '%'))
           OR UPPER(post.content) LIKE UPPER(CONCAT('%', :search, '%'))
    """)
    List<Post> findAllByTitleOrContent(String search);
}