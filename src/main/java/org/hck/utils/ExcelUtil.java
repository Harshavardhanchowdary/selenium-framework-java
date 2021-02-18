package org.hck.utils;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hck.constants.FrameworkConstants;
import org.hck.exceptions.FrameworkException;
import org.hck.exceptions.InvalidExcelPathException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ExcelUtil class is responsible for  reading test data defined in Excel file. which is supplied to test using dataprovide.
 * @author Harshavardhan Kavuri
 * @version 1.0
 * @see FrameworkConstants
 * @since 1.0
 */
public final class ExcelUtil {

    /**
     * Singleton classes-prevent class instances being created in any place other than this very class.
     */
    private ExcelUtil() {
    }


    /**
     * Returns the list of test data from the provided sheet.
     *
     * @param sheetName  name of the sheet from which to read the test data.
     * @return List of test data in the form of map.
     *  Each row is supplied as a map with column names as keys and column values as values.
     * @exception InvalidExcelPathException Excel file you trying to read not found at the path specified.
     * @exception FrameworkException Some error occurred while reading and writing to excel file.
     */
    public static List<Map<String, String>> getTestDetails(String sheetName) {
        XSSFWorkbook workBook;
        List<Map<String, String>> list = null;
        try(FileInputStream file = new FileInputStream(FrameworkConstants.getTestDataFilePath())) {
            workBook = new XSSFWorkbook(file);
            XSSFSheet sheet = workBook.getSheet(sheetName);
            int lastRowNum = sheet.getLastRowNum();
            int lastColNum = sheet.getRow(0).getLastCellNum();
            Map<String, String> map = null;
            list = new ArrayList<>();
            for (int i = 1; i <= lastRowNum; i++) {
                map = new HashMap<>();
                for (int j = 0; j < lastColNum; j++) {
                    String key = sheet.getRow(0).getCell(j).getStringCellValue();
                    String value = null;
                    if (sheet.getRow(i).getCell(j).getCellType() == CellType.STRING) {
                        value = sheet.getRow(i).getCell(j).getStringCellValue();
                    } else if (sheet.getRow(i).getCell(j).getCellType() == CellType.NUMERIC) {
                        value = String.valueOf(sheet.getRow(i).getCell(j).getNumericCellValue());
                    }
                    map.put(key, value);
                }
                list.add(map);
            }
        } catch (FileNotFoundException ex) {
            throw new InvalidExcelPathException("Excel file you trying to read not found at the path specified.");
        }catch (IOException ex){
            throw new FrameworkException("Some error occurred while reading and writing to excel file.");
        }

        return list;
    }
}
