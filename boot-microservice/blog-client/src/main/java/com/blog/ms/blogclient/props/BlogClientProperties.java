package com.blog.ms.blogclient.props;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Data
@Component
@ConfigurationProperties(prefix = "blog.service")
public class BlogClientProperties {

    private String postBaseUrl;
    private String postCommentPath;

    @PostConstruct
    public void printBlogClientProps() {
        log.info("Blog client props: " + this);
    }
}
