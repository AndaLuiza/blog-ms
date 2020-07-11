package com.blog.ms.blogservice.dto;

import com.blog.ms.blogservice.model.Post;
import lombok.Data;

import java.util.Date;

@Data
public class PostDto {
    private Long id;
    private String title;
    private String author;
    private String content;
    private Date postedDate;

    public PostDto() { }
    public PostDto(Post entity) {
        id = entity.getId();
        title = entity.getTitle();
        author = entity.getAuthor();
        content = entity.getContent();
        postedDate = entity.getPostedDate();
    }
}
