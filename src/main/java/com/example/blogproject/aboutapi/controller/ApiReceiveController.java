package com.example.blogproject.aboutapi.controller;

import com.example.blogproject.aboutapi.dto.ApiRequestDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/receive")
public class ApiReceiveController {
    @PostMapping("")
    public ResponseEntity apiRequest(@RequestBody ApiRequestDto dto){
        System.out.println(dto);
        String userName = dto.getUserName() + " 응답 완료";
        List<String> userArray = dto.getUserArray().stream().map(data -> data + " 응답 완료").collect(Collectors.toList());

        ApiRequestDto response = new ApiRequestDto(userName,userArray);
        return new ResponseEntity(response,HttpStatus.OK);
    }
}
