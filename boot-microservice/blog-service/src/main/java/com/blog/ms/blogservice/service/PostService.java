package com.blog.ms.blogservice.service;

import com.blog.ms.blogservice.dto.PostDto;
import com.blog.ms.blogservice.exception.ResourceNotFoundException;

import java.util.List;

public interface PostService {
    PostDto addPost(PostDto postDto);
    PostDto editPost(Long id, PostDto postDto) throws ResourceNotFoundException;
    void deletePost(Long id) throws ResourceNotFoundException;
    PostDto findPostById(Long id) throws ResourceNotFoundException;
    List<PostDto> findAllPosts();
    List<PostDto> findAllPostsByAuthor(String author);
}
