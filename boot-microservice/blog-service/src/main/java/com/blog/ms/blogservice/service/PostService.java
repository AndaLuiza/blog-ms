package com.blog.ms.blogservice.service;

import com.blog.ms.blogservice.dto.PostDto;
import com.blog.ms.blogservice.exception.ResourceNotFoundException;

import java.util.List;

public interface PostService {
    PostDto addPost(PostDto postDto);
    PostDto editPost(PostDto postDto) throws ResourceNotFoundException;
    void deletePost(Long postId) throws ResourceNotFoundException;
    PostDto findPostById(Long postId) throws ResourceNotFoundException;
    List<PostDto> findAllPosts();
    List<PostDto> findAllPostsByAuthor(String author);
}
