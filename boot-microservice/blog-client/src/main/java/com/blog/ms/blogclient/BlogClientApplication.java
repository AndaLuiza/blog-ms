package com.blog.ms.blogclient;

import com.blog.ms.blogclient.props.BlogClientProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient
@PropertySource("classpath:blog-cl.properties")
@SpringBootApplication
public class BlogClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogClientApplication.class, args);
	}

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
