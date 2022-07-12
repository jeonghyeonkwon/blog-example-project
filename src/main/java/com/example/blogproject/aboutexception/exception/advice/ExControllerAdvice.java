package com.example.blogproject.aboutexception.exception.advice;

import com.example.blogproject.aboutexception.controller.ApiExceptionController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice(basePackageClasses = ApiExceptionController.class)
public class ExControllerAdvice {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalStateException.class)
    public String IllegalStateHandler(IllegalStateException e){
        return e.getMessage();
    }
}
