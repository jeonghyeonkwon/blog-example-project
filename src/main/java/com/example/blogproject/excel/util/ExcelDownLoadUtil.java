package com.example.blogproject.excel.util;

import com.example.blogproject.excel.dto.download.DataDto;
import com.example.blogproject.excel.dto.download.RequestDto;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Component
public class ExcelDownLoadUtil {
    public void excelDownLoad(RequestDto dto, HttpServletResponse res) throws IOException {
        XSSFWorkbook wb = new XSSFWorkbook();
        List<String> titleList = dto.getTitleList();
        List<DataDto> dataList = dto.getDataList();

    }
}
