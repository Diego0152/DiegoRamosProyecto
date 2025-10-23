package com.iesvdc.dam.acceso.excelutil;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
    private Workbook wb;

    void loadWorkbook(String filename) {
        try (FileInputStream fis = new FileInputStream(filename)) {
            wb = new XSSFWorkbook(fis);
            
            
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
