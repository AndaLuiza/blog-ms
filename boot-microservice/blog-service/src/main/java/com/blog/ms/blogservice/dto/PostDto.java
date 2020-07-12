package com.blog.ms.blogservice.dto;

import com.blog.ms.blogservice.model.Post;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class PostDto {
    @ApiModelProperty(notes = "The database auto-generated post Id", readOnly = true)
    private Long id;
    @ApiModelProperty(notes = "The title of the post", required = true)
    private String title;
    @ApiModelProperty(notes = "The author of the post", required = true)
    private String author;
    @ApiModelProperty(notes = "The content of the post", required = true)
    private String content;
    @ApiModelProperty(notes = "The date when was written")
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
