package com.utility;

import com.contants.Env;
import com.google.gson.Gson;
import com.ui.pojo.Environment;
import com.ui.pojo.config;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class JSONUtility {
    public static Environment readJSON(Env env, String EnvironmentName) {
        Gson gson = new Gson();
        File jsonFile = new File(System.getProperty("user.dir") + "//Config//config.json");
        FileReader fileReader;
        try {
            fileReader = new FileReader(jsonFile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
       config config = gson.fromJson(fileReader, config.class);
        Environment environment = config.getEnviroments().get(EnvironmentName);
        return environment;

    }
}
