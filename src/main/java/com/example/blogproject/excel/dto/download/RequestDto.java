package com.example.blogproject.excel.dto.download;

import lombok.Data;

import java.util.List;

@Data
public class RequestDto {
    private List<String> titleList;
    private List<DataDto> dataList;
}
