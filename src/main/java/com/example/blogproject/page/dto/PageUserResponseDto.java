package com.example.blogproject.page.dto;

import lombok.Data;

@Data
public class PageUserResponseDto {
    private String uuid;
    private String userName;
    private String address;
    private String intro;
    public PageUserResponseDto(String uuid, String userName, String address, String intro){
        this.uuid = uuid;
        this.userName = userName;
        this.address = address;
        this.intro = intro;
    }
}
