package com.example.blogproject.aboutexception.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/exception")
public class ApiExceptionController {
    @GetMapping("")
    public ResponseEntity exception(){

        try {
            throw new IllegalStateException("예외 터트리기");
        }catch (IllegalArgumentException e){
            e.printStackTrace();
        }
        return new ResponseEntity(HttpStatus.OK);
    }
}
