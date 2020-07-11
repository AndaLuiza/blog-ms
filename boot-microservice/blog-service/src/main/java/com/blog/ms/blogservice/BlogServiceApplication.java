package com.blog.ms.blogservice;

import com.blog.ms.blogservice.dto.PostDto;
import com.blog.ms.blogservice.model.Post;
import com.blog.ms.blogservice.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.util.Arrays;
import java.util.Date;

@EnableDiscoveryClient
@SpringBootApplication
public class BlogServiceApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(BlogServiceApplication.class, args);
    }

    @Autowired
    PostService postServiceImpl;

    @Override
    public void run(String... args) throws Exception {
        PostDto post1 = new PostDto(new Post("NewPost 1", "Anda", "New Content1", new Date()));
        PostDto post2 = new PostDto(new Post("NewPost 2", "Anda", "New Content2", new Date()));
        PostDto post3 = new PostDto(new Post("NewPost 3", "Vlad", "New Content3", new Date()));
        Arrays.asList(post1, post2, post3)
                .forEach(postServiceImpl::addPost);

        postServiceImpl.findAllPosts().forEach(System.out::println);
    }
}
