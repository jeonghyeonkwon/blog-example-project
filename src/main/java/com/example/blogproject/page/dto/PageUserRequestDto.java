package com.example.blogproject.page.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class PageUserRequestDto {
    private String userName;

    private String address;
    private String intro;
}
