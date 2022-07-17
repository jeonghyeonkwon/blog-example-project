package com.example.blogproject.aboutapi.dto;

import lombok.Data;


import java.util.List;

@Data
public class ApiRequestDto {
    private String userName;
    private List<String> userArray;

    public ApiRequestDto(){}
    public ApiRequestDto(String userName, List<String> userArray) {
        this.userName = userName;
        this.userArray = userArray;
    }
}
