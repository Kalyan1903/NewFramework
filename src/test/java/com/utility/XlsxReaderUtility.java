package com.utility;

import com.ui.pojo.User;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class XlsxReaderUtility {
    public static Iterator Xlsxrader(String filename, String SheetName) {
        Row row = null;
        Cell emailcell;
        Cell passwordcell;
        XSSFWorkbook xssfWorkbook;
        XSSFSheet xssfSheet;
        List<User> UserData = new ArrayList<>();
        User user;
        File filexlsx = new File(System.getProperty("user.dir") + "\\testData\\" + filename);
        try {
            xssfWorkbook = new XSSFWorkbook(filexlsx);

            xssfSheet = xssfWorkbook.getSheet(SheetName);
            Iterator<Row> iterator = xssfSheet.iterator();
            iterator.next();
            while (iterator.hasNext()) {
                row = iterator.next();
                emailcell = row.getCell(0);
                passwordcell = row.getCell(1);
                user = new User(emailcell.toString(), passwordcell.toString());
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
        List<User> UserData = new ArrayList<>();
        User user;
        File filexlsx = new File(System.getProperty("user.dir") + "\\testData\\" + excelFileName);
        try (FileInputStream fis = new FileInputStream(new File(excelFileName))) {
            Workbook workbook = WorkbookFactory.create(fis);
            Sheet sheet = workbook.getSheetAt(1);
            Iterator<Row> iterator = sheet.iterator();
            int rowCount = sheet.getPhysicalNumberOfRows();
            int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
            iterator.next();
            while (iterator.hasNext()) {
                for (int i = 1; i < rowCount; i++) {
                    //row = sheet.getRow(i);
                    row = iterator.next();
                    if (row.getCell(0).toString().equalsIgnoreCase("Yes")) { // Check 'RunTest' column
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

       public static List<HashMap<String, String>> readExcelData(String filePath) throws IOException {
        List<HashMap<String, String>> dataList = new ArrayList<>();
        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet = workbook.getSheetAt(0);

        Row header = sheet.getRow(0);
        int rowCount = sheet.getPhysicalNumberOfRows();
        DateTimeFormatter monthFormatter = DateTimeFormatter.ofPattern("MMM", Locale.ENGLISH);

        for (int i = 1; i < rowCount; i++) {
            Row row = sheet.getRow(i);
            HashMap<String, String> dataMap = new HashMap<>();

            for (int j = 0; j < header.getLastCellNum(); j++) {
                String key = header.getCell(j).getStringCellValue();
                Cell cell = row.getCell(j);

                if (cell == null) {
                    dataMap.put(key, "");
                } else {
                    if (cell.getCellType() == CellType.NUMERIC && DateUtil.isCellDateFormatted(cell)) {
                        Date date = cell.getDateCellValue();
                        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy"); // Output: 03-Apr-2025
                        dataMap.put(key, formatter.format(date));
                    } else {
                        cell.setCellType(CellType.STRING);
                        dataMap.put(key, cell.getStringCellValue().trim());
                    }
                }

                // Parse DOB
                if (dataMap.containsKey("Date of birth")) {
                    LocalDate dob = LocalDate.parse(dataMap.get("Date of birth"), DateTimeFormatter.ofPattern("dd-MMM-yyyy"));
                    dataMap.put("DOB_Year", String.valueOf(dob.getYear()));
                    dataMap.put("DOB_Month", dob.format(monthFormatter));
                    dataMap.put("DOB_Day", String.valueOf(dob.getDayOfMonth()));
                }

                // Parse Departure Date
                if (dataMap.containsKey("Departure date")) {
                    LocalDate depDate = LocalDate.parse(dataMap.get("Departure date"), DateTimeFormatter.ofPattern("dd-MMM-yyyy"));
                    dataMap.put("Dep_Year", String.valueOf(depDate.getYear()));
                    dataMap.put("Dep_Month", depDate.format(monthFormatter));
                    dataMap.put("Dep_Day", String.valueOf(depDate.getDayOfMonth()));
                }


            }
            dataList.add(dataMap);
            workbook.close();
            fis.close();

        }
        return dataList;
    }
}



