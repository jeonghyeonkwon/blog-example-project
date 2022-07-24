package com.example.blogproject.aboutaop.controller;

import com.example.blogproject.aboutaop.service.AopService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aop")
@RequiredArgsConstructor
@Slf4j
public class AopController {
    private final AopService aopService;
    @GetMapping("/request")
    public ResponseEntity aopRequest(){
        String response = aopService.service();
        log.info("service msg = {}",response);
        return new ResponseEntity("controller Ok",HttpStatus.OK);
    }
}
