package com.blog.ms.blogclient.controller;

import com.blog.ms.blogclient.data.CommentDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class PostCommentRest {
    private final RestTemplate rest;

    public PostCommentRest(RestTemplate rest) {
        this.rest = rest;
    }

    @PostMapping("comment")
    public String postComment(@RequestParam Long postId, @RequestParam String reader, @RequestParam String commentText) {
        CommentDto commentDto = new CommentDto();
        commentDto.setReader(reader);
        commentDto.setCommentText(commentText);
        rest.postForObject("http://boot-service/posts/" + postId + "/comments", commentDto, Void.class);
        return "Created reservation id: ";
    }

}
