package com.blog.ms.blogservice.service;

import com.blog.ms.blogservice.dto.PostCommentDto;
import com.blog.ms.blogservice.exception.ResourceNotFoundException;
import com.blog.ms.blogservice.model.Post;
import com.blog.ms.blogservice.model.PostComment;
import com.blog.ms.blogservice.repository.PostCommentRepository;
import com.blog.ms.blogservice.repository.PostRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.Optional;

@Service
public class PostCommentServiceImpl implements PostCommentService {
    private static final Logger logger = LoggerFactory.getLogger(PostCommentServiceImpl.class);

    private final PostCommentRepository postCommentRepo;
    private final PostRepository postRepo;

    public PostCommentServiceImpl(PostCommentRepository postCommentRepo, PostRepository postRepo) {
        this.postCommentRepo = postCommentRepo;
        this.postRepo = postRepo;
    }

    @Override
    @Transactional
    public PostCommentDto addComment(PostCommentDto postCommentDto) throws ResourceNotFoundException {
        Optional<Post> post = postRepo.findById(postCommentDto.getPostId());

        if(post.isPresent()) {

            PostComment postComment = new PostComment();
            postComment.setPost(post.get());
            postComment.setReader(postCommentDto.getReader());
            postComment.setCommentText(postCommentDto.getCommentText());
            postComment.setCommentDate(new Date());

            return new PostCommentDto(postCommentRepo.save(postComment));
        }
        else
        {
            logger.error("Tried to add a new comment on post with id {}, but no post found.", postCommentDto.getPostId());
            throw new ResourceNotFoundException("No post found with id " + postCommentDto.getPostId());
        }
    }
}
