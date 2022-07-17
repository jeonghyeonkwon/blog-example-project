package com.example.blogproject.aboutapi.controller;

import com.example.blogproject.aboutapi.dto.ApiRequestDto;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/call")
public class ApiCallController {
    private final RestTemplate restTemplate;
    private final String EXPRESS_URL = "http://localhost:8000/api";

    public ApiCallController(RestTemplateBuilder restTemplateBuilder){
        this.restTemplate = restTemplateBuilder.build();
    }
    @PostMapping ("/rest-template")
    public ResponseEntity call(@RequestBody ApiRequestDto dto){
        try{
            ResponseEntity<ApiRequestDto> stringResponseEntity = restTemplate.postForEntity(EXPRESS_URL+"/receive", dto, ApiRequestDto.class);
            System.out.println(stringResponseEntity.getBody());
            return new ResponseEntity(stringResponseEntity.getBody(),HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity("잘못 요청했습니다.",HttpStatus.BAD_REQUEST);
        }
    }

}
