package com.blog.ms.blogservice.dto;

import com.blog.ms.blogservice.model.PostComment;
import lombok.Data;

import java.util.Date;

@Data
public class PostCommentDto {
    private Long id;
    private Long postId;
    private String reader;
    private String commentText;
    private Date commentDate;

    public PostCommentDto() { }
    public PostCommentDto(PostComment entity) {
        id = entity.getId();
        postId = entity.getPost().getId();
        reader = entity.getReader();
        commentText = entity.getCommentText();
        commentDate = entity.getCommentDate();
    }
}
