package com.example.blogproject.aboutapi;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {
    @Bean
    public RestTemplateBuilder restTemplateBuilder(){
        RestTemplateBuilder builder = new RestTemplateBuilder();
        return builder;
    }
}
