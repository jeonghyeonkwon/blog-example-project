package com.example.blogproject.aboutjava.dto;

import lombok.Getter;

@Getter
public class DefaultObjectDto {
    private String name;
    private String commonValue;
    private Long number;

    public DefaultObjectDto(String name,String commonValue, Long number) {
        this.name = name;
        this.commonValue = commonValue;
        this.number = number;
    }
}
