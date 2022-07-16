package com.example.blogproject.aboutvalidate.controller;

import com.example.blogproject.aboutvalidate.dto.ValidationErrorDto;
import com.example.blogproject.aboutvalidate.dto.ValidationUserDto;
import com.example.blogproject.aboutvalidate.exception.CustomValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/validation")
public class ApiValidationController {
    @PostMapping("")
    public ResponseEntity validation(@RequestBody @Valid ValidationUserDto dto, BindingResult result){
        if(result.hasErrors()){
            List<FieldError> fieldErrors = result.getFieldErrors();
            ValidationErrorDto errorList = new ValidationErrorDto(fieldErrors);
            throw new CustomValidationException("검증 오류",errorList);
        }
        System.out.println(dto);
        return new ResponseEntity(HttpStatus.OK);
    }
}
