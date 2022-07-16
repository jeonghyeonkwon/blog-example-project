package com.example.blogproject.aboutvalidate.exception.advice;

import com.example.blogproject.aboutvalidate.controller.ApiValidationController;
import com.example.blogproject.aboutvalidate.dto.ValidationErrorDto;
import com.example.blogproject.aboutvalidate.exception.CustomValidationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ValidationException;
import java.util.List;

@Slf4j
@RestControllerAdvice(basePackageClasses = ApiValidationController.class)
public class ValidationExceptionAdvice {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(CustomValidationException.class)
    public List<ValidationErrorDto.ErrorInfo> validationException(CustomValidationException e){
        List<ValidationErrorDto.ErrorInfo> errorDto = e.getErrorDto();
        return errorDto;
    }
}
