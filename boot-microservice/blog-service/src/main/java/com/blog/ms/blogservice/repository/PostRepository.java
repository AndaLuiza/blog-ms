package com.blog.ms.blogservice.repository;

import com.blog.ms.blogservice.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByAuthorIgnoreCase(String author);
}
