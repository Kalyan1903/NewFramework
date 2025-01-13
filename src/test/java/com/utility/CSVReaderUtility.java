package com.utility;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.ui.pojo.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class CSVReaderUtility {

    public static Iterator<User> ReadCsv(String fileName)
    {
        FileReader fileReader;
        CSVReader csvReader;
        String[] line;
        User userData;
        List<User> userList;
        File CSVFile = new File(System.getProperty("user.dir")+"\\testData\\"+ fileName);
        try {
            fileReader = new FileReader(CSVFile);
            csvReader = new CSVReader(fileReader);
           csvReader.readNext();
           userList = new ArrayList<>();
           while((line = csvReader.readNext())!=null){
              userData = new User(line[0],line[1]);
              userList.add(userData);
            }
           } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (CsvValidationException e) {
                throw new RuntimeException(e);
            }
        return userList.iterator();
        }

    }

