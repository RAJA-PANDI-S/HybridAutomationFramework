package org.test.framework.Utilities;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelDataDrivenUtil {
        private static Workbook workbook;
        private static Sheet sheet;

        // Method to load the Excel file
        public static void loadExcel(String filePath) throws IOException {
            FileInputStream fis = new FileInputStream(new File(filePath));
            workbook = new XSSFWorkbook(fis); // For .xlsx files
        }

        // Method to get data from Excel
        public static String getCellData(String sheetName, int rowNum, int colNum) {
            sheet = workbook.getSheet(sheetName);
            Row row = sheet.getRow(rowNum);
            Cell cell = row.getCell(colNum);
            return cell.toString(); // Converts the cell value to string
        }

        // Method to close the workbook after usage
        public static void closeWorkbook() throws IOException {
            workbook.close();
        }
    }
