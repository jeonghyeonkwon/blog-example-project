package com.example.blogproject.excel.controller;

import com.example.blogproject.excel.dto.download.RequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/poi")
public class ApiExcelController {

    @PostMapping("/download")
    public ResponseEntity excelDownload(@RequestBody RequestDto dto){
        System.out.println(dto);
        return new ResponseEntity(HttpStatus.OK);
    }
}
