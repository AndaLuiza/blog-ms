package com.blog.ms.blogservice.controller;

import com.blog.ms.blogservice.dto.PostCommentDto;
import com.blog.ms.blogservice.dto.PostDto;
import com.blog.ms.blogservice.exception.ResourceNotFoundException;
import com.blog.ms.blogservice.service.PostCommentService;
import com.blog.ms.blogservice.service.PostService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("posts")
@Api(value="blogPosts", produces = "application/json", description = "Crud operations on a Blog")
public class BlogRestController {
    @Autowired
    PostService postServiceImpl;

    @Autowired
    PostCommentService postCommentServiceImpl;

    @GetMapping
    @ApiOperation(value = "View list of all posts", response = PostDto.class, responseContainer = "List")
    public List<PostDto> getAllPosts() {
        return postServiceImpl.findAllPosts();
    }

    @GetMapping("author/{author}")
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

    @PutMapping("{id}")
    public PostDto editPost(@PathVariable Long id, @RequestBody PostDto postDto) {
        try {
            return postServiceImpl.editPost(id, postDto);
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
        try {
            postCommentServiceImpl.addComment(postId, postCommentDto);
        } catch (ResourceNotFoundException ex) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Post Not Found", ex);
        }
    }
}
