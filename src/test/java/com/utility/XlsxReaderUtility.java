package com.utility;

import com.ui.pojo.User;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class XlsxReaderUtility {
    public static Iterator Xlsxrader(String filename) {
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
            xssfSheet = xssfWorkbook.getSheet("User_Data");
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

}
