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
@Table(name = "blog_posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    private String title;

    private String author;

    @Lob
    @Column(name="content", columnDefinition = "TEXT")
    private String content;

    @Column(name="posted_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date postedDate;

    public Post(String title, String author, String content, Date postedDate) {
        this.title = title;
        this.author = author;
        this.content = content;
        this.postedDate = postedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Post post = (Post) o;
        return Objects.equals(id, post.id) &&
                Objects.equals(title, post.title) &&
                Objects.equals(author, post.author) &&
                Objects.equals(content, post.content) &&
                Objects.equals(postedDate, post.postedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, author, content, postedDate);
    }

    @Override
    public String toString() {
        return "Post[" +
                "id=" + id +
                ", title=" + title +
                ", author=" + author +
                ", content=" + content +
                ", postedDate=" + postedDate +
                "]";
    }
}
