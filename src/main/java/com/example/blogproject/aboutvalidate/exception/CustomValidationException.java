package com.example.blogproject.aboutvalidate.exception;

import com.example.blogproject.aboutvalidate.dto.ValidationErrorDto;

import java.util.List;


public class CustomValidationException extends RuntimeException{
    private List<ValidationErrorDto.ErrorInfo> errorDto ;
    public CustomValidationException(String message, ValidationErrorDto dto) {
        super(message);
        List<ValidationErrorDto.ErrorInfo> errorInfoList = dto.getErrorInfoList();
        this.errorDto =errorInfoList;
    }

    public List<ValidationErrorDto.ErrorInfo> getErrorDto() {
        return errorDto;
    }
}
