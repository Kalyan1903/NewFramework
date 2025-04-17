package com.ui.pojo;

import java.util.Map;

public class config {
    Map<String,Environment> enviroments;
    public Map<String,Environment> getEnviroments()
    {

        return enviroments;
    }


    public void enviroments(Map<String, Environment> setenviroments) {

        this.enviroments = enviroments;
    }
}
