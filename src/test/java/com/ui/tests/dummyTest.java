package com.ui.tests;

import com.ui.pages.dummyPage;
import com.ui.pojo.User;
import com.utility.LoggerUtility;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Map;

import static org.testng.Assert.assertEquals;
@Listeners(com.ui.listners.TestListeners.class)
public class dummyTest extends BaseTest {
    int count = 0;
    Logger logger = LoggerUtility.GetLogger(this.getClass());


    @Test(description = "DummyApplication Testing",groups = {"e2e","sanity"},dataProviderClass = com.ui.dataproviders.LoginDataprovider.class,dataProvider = "excelData")
    public void logintestdummy(Map<String, String> data)
    {
        count++;
        dummypage.selectBookingType(data.get("Type"));
        dummypage.dateOfBirth(data.get("DOB_Year"), data.get("DOB_Month"), data.get("DOB_Day"));
        dummypage.enterNames(data.get("firstName"), data.get("LastName"));
    }
    @Test(description = "DummyApplication Testing",groups = {"e2e","sanity"},dataProviderClass = com.ui.dataproviders.LoginDataprovider.class,dataProvider = "excelData")
    public void logintestdummys(Map<String, String> data)
    {
        count++;
        dummypage.selectBookingType(data.get("Type"));
        dummypage.dateOfBirth(data.get("DOB_Year"), data.get("DOB_Month"), data.get("DOB_Day"));
        dummypage.enterNames(data.get("firstName"), data.get("LastName"));
    }
}
