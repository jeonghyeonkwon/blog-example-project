package com.example.blogproject.aboutapi;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebConfig {
    @Bean
    public RestTemplateBuilder restTemplateBuilder(){
        RestTemplateBuilder builder = new RestTemplateBuilder();
        return builder;
    }

    @Bean
    public WebClient.Builder webClientBuilder(){
        WebClient.Builder builder = WebClient.builder();
        return builder;
    }
}
