package com.blog.ms.blogservice.service;

import com.blog.ms.blogservice.dto.PostCommentDto;
import com.blog.ms.blogservice.exception.ResourceNotFoundException;

public interface PostCommentService {
    PostCommentDto addComment(PostCommentDto postCommentDto) throws ResourceNotFoundException;
}
