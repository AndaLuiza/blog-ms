package com.blog.ms.blogservice.service;

import com.blog.ms.blogservice.dto.PostDto;
import com.blog.ms.blogservice.exception.ResourceNotFoundException;
import com.blog.ms.blogservice.model.Post;
import com.blog.ms.blogservice.repository.PostRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {
    private static final Logger logger = LoggerFactory.getLogger(PostServiceImpl.class);

    private final PostRepository postRepo;

    public PostServiceImpl(PostRepository postRepo) {
        this.postRepo = postRepo;
    }

    @Override
    @Transactional
    public PostDto addPost(PostDto postDto) {
        Post post = new Post(postDto.getTitle(), postDto.getAuthor(), postDto.getContent(), new Date());
        return new PostDto(postRepo.save(post));
    }

    @Override
    @Transactional
    public PostDto editPost(PostDto postDto) throws ResourceNotFoundException {
        Optional<Post> post = postRepo.findById(postDto.getId());
        if(post.isPresent()) {
            Post foundPost = post.get();
            foundPost.setAuthor(postDto.getAuthor());
            foundPost.setTitle(postDto.getTitle());
            foundPost.setContent(postDto.getContent());
            foundPost.setPostedDate(new Date());
            return new PostDto(postRepo.save(foundPost));
        }
        else
        {
            logger.error("Tried to update post, but no post found with id {} ", postDto.getId());
            throw new ResourceNotFoundException("No post found with id " + postDto.getId());
        }
    }

    @Override
    @Transactional
    public void deletePost(Long postId) throws ResourceNotFoundException {
        Optional<Post> post = postRepo.findById(postId);
        if(post.isPresent()) {
            postRepo.delete(post.get());
        }
        else {
            logger.error("Tried to delete post, but no post found with id {} ", postId);
            throw new ResourceNotFoundException("No post found with id " + postId);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public PostDto findPostById(Long postId) throws ResourceNotFoundException {
        Optional<Post> post = postRepo.findById(postId);
        if (post.isPresent()) {
            return new PostDto(post.get());
        }
        else
        {
            logger.error("Tried to retrieve post, but no post found with id {} ", postId);
            throw new ResourceNotFoundException("No post found with id " + postId);
        }
    }

    @Override
    public List<PostDto> findAllPosts() {
        List<PostDto> postDtoList = new ArrayList<>();
        postRepo.findAll().forEach(post -> postDtoList.add(new PostDto(post)));

        return postDtoList;
    }

    @Override
    public List<PostDto> findAllPostsByAuthor(String author) {
        List<Post> posts = postRepo.findByAuthor(author);
        List<PostDto> postDtoList = new ArrayList<>();
        posts.forEach(post -> postDtoList.add(new PostDto(post)));

        return postDtoList;
    }
}
