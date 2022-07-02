package com.example.blogproject.excel.util;

import com.example.blogproject.excel.dto.download.DataDto;
import com.example.blogproject.excel.dto.download.RequestDto;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Component
public class ExcelDownLoadUtil {
    public void excelDownLoad(RequestDto dto, HttpServletResponse res) throws IOException {
        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet sheet = wb.createSheet("시트 명 적는곳 입니다.");
        XSSFRow row = null;
        XSSFCell cell = null;
        int headerStartRow = 1;
        int targetCell = 0;
        List<String> titleList = dto.getTitleList();
        List<DataDto> dataList = dto.getDataList();
        row = sheet.createRow(headerStartRow++);
        for(int i=0;i<titleList.size();i++){
            cell = row.createCell(i);
            cell.setCellValue(titleList.get(i));
            sheet.setColumnWidth(i,2000);
        }

        res.setContentType("application/vnd.ms-excel");
        String fileName = UriUtils.encode("abc.xlsx", StandardCharsets.UTF_8);
        res.setHeader("Content-Disposition","attachment; filename=\""+fileName+"\"");

        wb.write(res.getOutputStream());

    }
}
