package com.example.blogproject.excel.dto.upload;

import lombok.Data;

@Data
public class ResponseUploadDto {
    private String num;
    private String lastName;
    private String firstName;
    private String etc;
    public  ResponseUploadDto(String num, String lastName,String firstName,String etc){
        this.num = num;
        this.lastName = lastName;
        this.firstName = firstName;
        this.etc = etc;
    }
}
