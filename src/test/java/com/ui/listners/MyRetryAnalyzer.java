package com.ui.listners;

import com.contants.Env;
import com.utility.JSONUtility;
import com.utility.PropertiesUtil;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class MyRetryAnalyzer implements IRetryAnalyzer
{
    //private final int MAX_ATTEMPTS = Integer.parseInt(PropertiesUtil.readProperties(Env.QA,"MAX_ATTEMPTS"));
    private final int MAX_ATTEMPTS = 3;
    private static int currentattempt = 1;
    @Override
    public boolean retry(ITestResult iTestResult) {
        if(currentattempt<=MAX_ATTEMPTS) {
            currentattempt++;
            return true;
        }
        return false;
    }
}
