package com.cybr406.blog;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BlogApplication {

  @Value("${blog.user.uri}")
  String userUri;

  @Value("${blog.post.uri}")
  String postUri;
  
  public static void main(String[] args) {
    SpringApplication.run(BlogApplication.class, args);
  }

  @Bean
  public RouteLocator routes(RouteLocatorBuilder builder) {
    return builder.routes()

        .route("profiles", p -> p
            .path("/profiles/**")
            .uri(userUri))

        .route("posts", p -> p
            .path("/posts/**")
            .uri(postUri))

        .build();
  }

}

