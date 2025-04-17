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
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

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
    @DataProvider(name = "excelData")
    public Object[][] getData() throws IOException {
        String filePath = "C:\\Users\\Pabba\\MynewFramework\\testData\\cleaned_testDatafordummy.xlsx";
        List<HashMap<String, String>>testData = XlsxReaderUtility.readExcelData(filePath);
        System.out.println("📄 Raw Excel rows: " + testData.size());
        List<HashMap<String, String>> filteredData = testData.stream()
                .filter(map -> map.values().stream().anyMatch(value -> value != null && !value.trim().isEmpty()))
                .collect(Collectors.toList());
        System.out.println("✅ Filtered rows (non-empty): " + filteredData.size());
        Object[][] data = new Object[filteredData.size()][1];
        for (int i = 0; i < filteredData.size(); i++) {
            data[i][0] = filteredData.get(i);
        }
        return data;

    }

}
