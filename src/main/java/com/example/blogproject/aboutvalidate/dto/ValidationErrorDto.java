package com.example.blogproject.aboutvalidate.dto;

import lombok.Data;
import lombok.Getter;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class ValidationErrorDto {
    List<ErrorInfo> errorInfoList;
    public ValidationErrorDto(List<FieldError> fieldErrors) {
        List<ErrorInfo> list = fieldErrors.stream().map(err -> new ErrorInfo(err.getDefaultMessage(), err.getField())).collect(Collectors.toList());
        this.errorInfoList = list;
    }
    @Getter
    public class ErrorInfo{
        private String defaultMessage;
        private String fieldName;
        public ErrorInfo(String defaultMessage,String fieldName){
            this.defaultMessage = defaultMessage;
            this.fieldName = fieldName;
        }
    }
}
