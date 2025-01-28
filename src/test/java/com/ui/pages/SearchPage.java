package com.ui.pages;

import com.utility.BroswerUtiltiy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage extends BroswerUtiltiy
{

   private static final By RESULT_TEXT = By.className("lighter");


    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public String getSearchText()
    {

        return getText(RESULT_TEXT);
    }
}
