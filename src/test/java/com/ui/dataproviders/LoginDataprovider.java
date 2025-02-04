package com.ui.dataproviders;

import com.google.gson.Gson;
import com.ui.pojo.TestData;
import com.ui.pojo.User;
import com.utility.CSVReaderUtility;
import com.utility.XlsxReaderUtility;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class LoginDataprovider {

   @DataProvider(name = "testdataprovider")
    public Iterator<Object[]> loginDataprovider()
    {
        Gson gson = new Gson();
        FileReader fileReader;
        File testDatafile = new File(System.getProperty("user.dir") + "//testData//logindata.json");
        try {
            fileReader = new FileReader(testDatafile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
       TestData data = gson.fromJson(fileReader, TestData.class);

        List<Object[]> datatoreturn = new ArrayList<Object[]>();
        for(User user : data.getData())
        {
            datatoreturn.add(new Object[]{user});
        }
        return datatoreturn.iterator();


    }
    @DataProvider(name = "testdatacsvprovider")
    public Iterator<User> loginCSVDataProvider()
    {
        return CSVReaderUtility.ReadCsv("LoginData.csv");
    }

    @DataProvider(name = "testdataxlsxprovider")
    public Iterator<User> loginXlsxDataProvider()
    {
        return XlsxReaderUtility.Xlsxrader("TestData.xlsx","User_Data");
    }
    @DataProvider(name = "testdataxlsxproviderselected")
    @Parameters({"excelFileName"})
    public Iterator<User> SelectedloginXlsxDataProvider(String excelFileName)
    {
        return XlsxReaderUtility.getFilteredExcelData(excelFileName);
    }

}
