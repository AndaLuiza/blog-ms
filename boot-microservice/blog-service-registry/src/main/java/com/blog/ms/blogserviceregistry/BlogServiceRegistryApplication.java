package com.blog.ms.blogserviceregistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableDiscoveryClient(autoRegister = false)
@EnableEurekaServer
@SpringBootApplication
public class BlogServiceRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogServiceRegistryApplication.class, args);
	}

}
