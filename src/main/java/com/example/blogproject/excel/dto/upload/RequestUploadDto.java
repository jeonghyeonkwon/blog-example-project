package com.example.blogproject.excel.dto.upload;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class RequestUploadDto {
    private MultipartFile file;
}
