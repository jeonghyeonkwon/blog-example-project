package com.example.blogproject.aboutjava.dto;


import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
@Getter
public class LombokObjectDto {
    private String name;
    private String commonValue;
    private Long number;

    public LombokObjectDto(String name,String commonValue, Long number) {
        this.name = name;
        this.commonValue = commonValue;
        this.number = number;
    }
}
