package com.utility;

import com.contants.Env;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {
    //Read Properties file:)
    public static String readProperties(Env environment, String PropetyName) {
        File propFile  = new File(System.getProperty("user.dir")+"//Config//"+environment+".properties");
        FileReader fileReader = null;
        Properties properties = new Properties();
        try {
            fileReader = new FileReader(propFile);
            properties.load(fileReader);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
         catch (IOException e) {
            throw new RuntimeException(e);
        }
        String value = properties.getProperty(PropetyName);
        return value;
    }
}
