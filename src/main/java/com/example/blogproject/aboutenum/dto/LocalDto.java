package com.example.blogproject.aboutenum.dto;

import lombok.Data;

@Data
public class LocalDto {
    private String enumName;
    private String kor;
    public LocalDto(String enumName,String kor){
        this.enumName = enumName;
        this.kor = kor;
    }
}
