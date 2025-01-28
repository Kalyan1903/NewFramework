package com.utility;

import com.ui.pojo.User;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class XlsxReaderUtility {
    public static Iterator Xlsxrader(String filename,String SheetName) {
        Row row = null;
        Cell emailcell;
        Cell passwordcell;
        XSSFWorkbook xssfWorkbook;
        XSSFSheet xssfSheet;
        List<User> UserData =  new ArrayList<>();
        User user;
        File filexlsx = new File(System.getProperty("user.dir") + "\\testData\\"+filename);
        try {
            xssfWorkbook = new XSSFWorkbook(filexlsx);

            xssfSheet = xssfWorkbook.getSheet(SheetName);
            Iterator<Row> iterator = xssfSheet.iterator();
            iterator.next();
            while(iterator.hasNext())
            {
                row = iterator.next();
                emailcell = row.getCell(0);
                passwordcell = row.getCell(1);
                user = new User(emailcell.toString(),passwordcell.toString());
                UserData.add(user);
            }

        } catch (IOException e) {

        } catch (InvalidFormatException e) {
            throw new RuntimeException(e);
        }
        return UserData.iterator();
    }

    public static Iterator<User> getFilteredExcelData(String excelFileName) {

        Row row = null;
        Cell emailcell;
        Cell passwordcell;
        XSSFWorkbook xssfWorkbook;
        XSSFSheet xssfSheet;
        List<User> UserData =  new ArrayList<>();
        User user;
       File filexlsx = new File(System.getProperty("user.dir") + "\\testData\\"+excelFileName);
        try (FileInputStream fis = new FileInputStream(new File(excelFileName))) {
            Workbook workbook = WorkbookFactory.create(fis);
            Sheet sheet = workbook.getSheetAt(1);
            Iterator<Row> iterator = sheet.iterator();
            int rowCount = sheet.getPhysicalNumberOfRows();
            int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
            iterator.next();
            while(iterator.hasNext())
            {
                for (int i = 1; i < rowCount; i++) {
                    //row = sheet.getRow(i);
                    row = iterator.next();
                    if (row.getCell(0).toString().equalsIgnoreCase("Yes"))
                    { // Check 'RunTest' column
                       // Object[] rowData = new Object[colCount - 1];
                       // for (int j = 1; j < colCount; j++) { // Exclude the 'RunTest' column
                         //   rowData[j - 1] = row.getCell(j).toString();
                            emailcell = row.getCell(1);
                            passwordcell = row.getCell(2);
                        user = new User(emailcell.toString(), passwordcell.toString());
                        UserData.add(user);
                    }
                   // row = iterator.next();
                }
            }

            } catch (IOException e) {
            e.printStackTrace();
        }
        return UserData.iterator();
    }

}
