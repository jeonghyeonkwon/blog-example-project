package com.example.blogproject.aboutjava.controller;

import com.example.blogproject.aboutjava.dto.DefaultObjectDto;
import com.example.blogproject.aboutjava.dto.EqualsDto;
import com.example.blogproject.aboutjava.dto.LocalDto;
import com.example.blogproject.aboutjava.dto.LombokObjectDto;
import com.example.blogproject.aboutjava.model.LocalEnum;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/api/java/enum")
public class JavaEnumController {

    /*
    * enum 관련 예제
    * */
    @GetMapping("/local-list")
    public ResponseEntity localList(){
        List<LocalDto> localDtos = LocalEnum.localList();
        return new ResponseEntity(localDtos, HttpStatus.OK);
    }
    @GetMapping("/local")
    public ResponseEntity findLocalByKor(@RequestParam("kor") String kor){
        try{
            LocalDto local = LocalEnum.findLocalByKor(kor);
            return new ResponseEntity(local,HttpStatus.OK);
        }catch (NullPointerException e){
            e.printStackTrace();
            return new ResponseEntity("해당 지역은 없습니다",HttpStatus.BAD_REQUEST);
        }
    }




}
