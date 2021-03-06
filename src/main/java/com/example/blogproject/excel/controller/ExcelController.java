package com.example.blogproject.excel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExcelController {
    @GetMapping("/poi/excel/download")
    public String excelDownloadForm(){
        return "poiExcelDownLoad";
    }

    @GetMapping("/poi/excel/upload")
    public String excelUploadForm(){
        return "poiExcelUpload";
    }
}
