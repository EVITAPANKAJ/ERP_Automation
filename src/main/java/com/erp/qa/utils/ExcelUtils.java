package com.erp.qa.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelUtils {
     String filePath;
    private Sheet sheet;
	
    public static String[] getLoginCredentials(String filePath, String sheetName) {
        String[] credentials = new String[2];
        FileInputStream fis = null;
        Workbook workbook = null;
        try {
            fis = new FileInputStream(filePath);
            workbook = WorkbookFactory.create(fis);
            Sheet sheet = workbook.getSheet(sheetName);
            if (sheet != null) {
                Row row = sheet.getRow(1); // Assuming first row (0) is header, data starts at row 1
                if (row != null) {
                    Cell userCell = row.getCell(0);
                    Cell passCell = row.getCell(1);
                    credentials[0] = userCell != null ? userCell.toString() : "";
                    credentials[1] = passCell != null ? passCell.toString() : "";
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (workbook != null)
                if (fis != null) fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return credentials;
    }

    public static List<String[]> getAllLoginCredentials(String filePath, String sheetName) {
        List<String[]> credentialsList = new ArrayList<>();
        FileInputStream fis = null;
        Workbook workbook = null;
        try {
            fis = new FileInputStream(filePath);
            workbook = WorkbookFactory.create(fis);
            Sheet sheet = workbook.getSheet(sheetName);
            if (sheet != null) {
                Iterator<Row> rowIterator = sheet.iterator();
                if (rowIterator.hasNext()) rowIterator.next(); // Skip header row
                while (rowIterator.hasNext()) {
                    Row row = rowIterator.next();
                    Iterator<Cell> cellIterator = row.cellIterator();
                    List<String> rowData = new ArrayList<>();
                    while (cellIterator.hasNext()) {
                        Cell cell = cellIterator.next();
                        rowData.add(cell != null ? cell.toString() : "");
                    }
                    credentialsList.add(rowData.toArray(new String[0]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (workbook != null) workbook.close();
                if (fis != null) fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return credentialsList;
    }
    
    public static List<Map<String, String>> getData(String filePath, String sheetName) {
        List<Map<String, String>> dataList = new ArrayList<>();
 
        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {
 
            Sheet sheet = workbook.getSheet(sheetName);
            Row headerRow = sheet.getRow(0);
 
            int lastRowNum = sheet.getLastRowNum();
            int totalCols = headerRow.getLastCellNum();
 
            for (int i = 1; i <= lastRowNum; i++) {
                Row currentRow = sheet.getRow(i);
                if (currentRow == null) continue;
 
                Map<String, String> dataMap = new HashMap<>();
                for (int j = 0; j < totalCols; j++) {
                    String key = headerRow.getCell(j).getStringCellValue();
                    Cell cell = currentRow.getCell(j);
 
                    String value = "";
                    if (cell != null) {
                        cell.setCellType(CellType.STRING);
                        value = cell.getStringCellValue();
                    }
                    dataMap.put(key, value);
                }
                dataList.add(dataMap);
            }
 
        } catch (IOException e) {
            e.printStackTrace();
        }
 
        return dataList;
    }


}