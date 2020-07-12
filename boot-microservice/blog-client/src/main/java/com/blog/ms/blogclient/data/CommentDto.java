package com.blog.ms.blogclient.data;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CommentDto {
    private String reader;
    private String commentText;
}
