package com.blog.ms.blogclient.controller;

import com.blog.ms.blogclient.data.CommentDto;
import com.blog.ms.blogclient.props.BlogClientProperties;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class PostCommentRest {
    private final RestTemplate rest;
    private final BlogClientProperties blogClientProperties;

    public PostCommentRest(RestTemplate rest, BlogClientProperties blogClientProperties) {
        this.rest = rest;
        this.blogClientProperties = blogClientProperties;
    }

    @PostMapping("comment")
    public String postComment(@RequestParam Long postId, @RequestParam String reader, @RequestParam String commentText) {
        CommentDto commentDto = new CommentDto(reader, commentText);
        String externalPostBaseUrl = blogClientProperties.getPostBaseUrl();
        String postCommentPath = blogClientProperties.getPostCommentPath();
        String url = externalPostBaseUrl + postId + postCommentPath;

        rest.postForObject(url, commentDto, Void.class);
        return "Comment added";
    }

}
