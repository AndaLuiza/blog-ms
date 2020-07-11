package com.blog.ms.blogconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class BlogConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogConfigServerApplication.class, args);
	}

}
