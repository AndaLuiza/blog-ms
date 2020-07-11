package com.blog.ms.blogservice.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "post_comments")
public class PostComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    private String reader;

    @Lob
    @Column(name="comment_text", columnDefinition = "TEXT")
    private String commentText;

    @Column(name="comment_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date commentDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PostComment that = (PostComment) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(post, that.post) &&
                Objects.equals(reader, that.reader) &&
                Objects.equals(commentText, that.commentText) &&
                Objects.equals(commentDate, that.commentDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, post, reader, commentText, commentDate);
    }

    @Override
    public String toString() {
        return "PostComment[" +
                "id=" + id +
                ", post=" + post +
                ", reader=" + reader +
                ", commentText=" + commentText +
                ", commentDate=" + commentDate +
                "]";
    }
}
