package com.ui.tests;

import com.ui.pojo.User;
import com.utility.LoggerUtility;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class InvalidCredLoginTest extends BaseTest {
    Logger logger = LoggerUtility.GetLogger(this.getClass());
    private final String UserEmail = "est@gmail.com";
    private final String password = "passwrdsdsadasd";



    @Test(description = "Verify that Error message is displayed for invalid credintials", groups = {"e2e", "sanity"}, dataProviderClass = com.ui.dataproviders.LoginDataprovider.class, dataProvider = "testdataxlsxproviderselected")
    public void logintest(User user) {


        assertEquals(homePage.goToLoginPage().doLoginWithInvalidCredintials(UserEmail,password).getErrorMessage(),"Authentication failed");

    }
}
