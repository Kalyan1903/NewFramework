package com.ui.pages;

import com.utility.BroswerUtiltiy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage extends BroswerUtiltiy
{
    private static final By USER_NAME = By.xpath("//a[@title='View my customer account']/child::span");
    public MyAccountPage(WebDriver driver) {
        super(driver);
    }
    public String getUserName()
{
     return getText(USER_NAME);
}

}