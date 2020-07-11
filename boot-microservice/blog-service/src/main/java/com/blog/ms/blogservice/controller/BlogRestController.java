package com.blog.ms.blogservice.controller;

import com.blog.ms.blogservice.dto.PostCommentDto;
import com.blog.ms.blogservice.dto.PostDto;
import com.blog.ms.blogservice.exception.ResourceNotFoundException;
import com.blog.ms.blogservice.service.PostCommentService;
import com.blog.ms.blogservice.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("posts")
public class BlogRestController {
    @Autowired
    PostService postServiceImpl;

    @Autowired
    PostCommentService postCommentServiceImpl;

    @GetMapping
    public List<PostDto> getAllPosts() {
        return postServiceImpl.findAllPosts();
    }

    @GetMapping("{author}")
    public List<PostDto> getPostsByAuthor(@PathVariable String author) {
        return postServiceImpl.findAllPostsByAuthor(author);
    }

    @GetMapping("{id}")
    public PostDto getPostById(@PathVariable Long id) {
        try {
            return postServiceImpl.findPostById(id);
        } catch (ResourceNotFoundException ex) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Post Not Found", ex);
        }
    }

    @PostMapping
    public PostDto addPost(@RequestBody PostDto postDto) {
        return postServiceImpl.addPost(postDto);
    }

    @PutMapping
    public PostDto editPost(@RequestBody PostDto postDto) {
        try {
            return postServiceImpl.editPost(postDto);
        } catch (ResourceNotFoundException ex) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Post Not Found", ex);
        }
    }

    @DeleteMapping("{id}")
    public void editPost(@PathVariable Long id) throws ResourceNotFoundException {
        try {
            postServiceImpl.deletePost(id);
        } catch (ResourceNotFoundException ex) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Post Not Found", ex);
        }
    }

    @PostMapping("{postId}/comments")
    public void addComment(@PathVariable (value = "postId") Long postId, @RequestBody PostCommentDto postCommentDto) {
        postCommentDto.setPostId(postId);
        try {
            postCommentServiceImpl.addComment(postCommentDto);
        } catch (ResourceNotFoundException ex) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Post Not Found", ex);
        }
    }
}
