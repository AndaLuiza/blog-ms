package com.blog.ms.blogservice.repository;

import com.blog.ms.blogservice.model.PostComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostCommentRepository extends JpaRepository<PostComment, Long> {
    //nothing to do
}
