package com.example.blogproject.aboutenum.controller;

import com.example.blogproject.aboutenum.dto.LocalDto;
import com.example.blogproject.aboutenum.model.LocalEnum;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/enum")
public class ApiEnumController {
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
