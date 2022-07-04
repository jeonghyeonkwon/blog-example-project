package com.example.blogproject.excel.controller;

import com.example.blogproject.excel.dto.download.RequestDto;
import com.example.blogproject.excel.dto.upload.RequestUploadDto;
import com.example.blogproject.excel.dto.upload.ResponseUploadDto;
import com.example.blogproject.excel.util.ExcelDownLoadUtil;
import com.example.blogproject.excel.util.ExcelUploadUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/poi")
public class ApiExcelController {
    private final ExcelUploadUtil excelUploadUtil;
    private final ExcelDownLoadUtil excelDownLoadUtil;
//    @PostMapping("/download")
//    public ResponseEntity<Resource> excelDownload(@RequestBody RequestDto dto, HttpServletResponse res){
//        System.out.println(dto);
//        try{
//            return excelDownLoadUtil.excelDownLoad(dto,res);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//    }
    @PostMapping("/upload")
    public ResponseEntity excelUpload( RequestUploadDto dto){

        try{
            List<ResponseUploadDto> responseDto = excelUploadUtil.excelRead(dto.getFile());
            return new ResponseEntity(responseDto,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity("잘못된 요청",HttpStatus.BAD_REQUEST);
        }


    }
}
