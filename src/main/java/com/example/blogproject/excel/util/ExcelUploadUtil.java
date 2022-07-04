package com.example.blogproject.excel.util;

import com.example.blogproject.excel.dto.upload.ResponseUploadDto;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.eventusermodel.ReadOnlySharedStringsTable;
import org.apache.poi.xssf.eventusermodel.XSSFReader;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class ExcelUploadUtil {
    public List<ResponseUploadDto> excelRead(MultipartFile file) throws Exception{
        List<ResponseUploadDto> list = new ArrayList<>();

//
        InputStream stream = file.getInputStream();
        XSSFWorkbook workbook = new XSSFWorkbook(stream);
        Sheet sheet = workbook.getSheetAt(0);
        for(int i = 2;i<=sheet.getPhysicalNumberOfRows();i++){
            Row row = sheet.getRow(i);
            String num = Double.toString(row.getCell(1).getNumericCellValue());

            String lastName= row.getCell(2).getStringCellValue();
            String firstName = row.getCell(3).getStringCellValue();
            String etc = row.getCell(4).getStringCellValue();


            ResponseUploadDto dto = new ResponseUploadDto(num,lastName,firstName,etc);
            list.add(dto);
        }
        return list;
    }
}
