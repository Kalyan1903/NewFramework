package com.ui.tests;

import com.ui.pages.MyAccountPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchProductTest extends BaseTest
{
    MyAccountPage myAccountPage;
    @BeforeMethod(description = "valid user login credentials")
    public void beforemethod()
    {
       myAccountPage =  homePage.goToLoginPage().doLoginWith("Kalyanpabbathi158@gmail.com","Password");
    }
@Test(description = "Verifying the search Result")
    public void SearchResultTest()
    {

        String data = myAccountPage.SearchforProduct("Printed Summer Dress").getSearchText();
        System.out.println(data);
    }





}
