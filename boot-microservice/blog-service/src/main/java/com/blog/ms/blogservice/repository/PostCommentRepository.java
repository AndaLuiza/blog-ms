package com.blog.ms.blogservice.repository;

import com.blog.ms.blogservice.model.PostComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostCommentRepository extends JpaRepository<PostComment, Long> {
    //nothing to do
}
