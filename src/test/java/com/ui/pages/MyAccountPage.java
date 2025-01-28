package com.ui.pages;

import com.utility.BroswerUtiltiy;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class MyAccountPage extends BroswerUtiltiy
{
    private static final By USER_NAME = By.xpath("//a[@title='View my customer account']/child::span");
    private static final By SEARCH_BOX = By.id("search_query_top");
    public MyAccountPage(WebDriver driver) {
        super(driver);
    }
    public String getUserName()
{

    return getText(USER_NAME);
}
public SearchPage SearchforProduct(String productName)
{
    enterText(SEARCH_BOX,productName);
    enterKey(SEARCH_BOX, Keys.ENTER);
    SearchPage searchPage = new SearchPage(getDrvier());
    return searchPage;
}



}
