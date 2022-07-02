package com.example.blogproject.excel.controller;

import com.example.blogproject.excel.dto.download.RequestDto;
import com.example.blogproject.excel.util.ExcelDownLoadUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/poi")
public class ApiExcelController {

    private final ExcelDownLoadUtil excelDownLoadUtil;
    @PostMapping("/download")
    public void excelDownload(@RequestBody RequestDto dto, HttpServletResponse res){
        System.out.println(dto);
        try{
            excelDownLoadUtil.excelDownLoad(dto,res);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
