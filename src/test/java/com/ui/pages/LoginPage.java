package com.ui.pages;

import com.utility.BroswerUtiltiy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BroswerUtiltiy
{
    public LoginPage(WebDriver driver)
    {
        super(driver);
    }
    private static final By EMAIL_TEXT_LOACTOR = By.id("email");
    private static final By PASSWORD_LOCATOR = By.id("passwd");
    private static final By SUBMIT_LOGIN = By.id("SubmitLogin");

    public MyAccountPage doLoginWith(String emailAddress, String Password)
    {
        enterText(EMAIL_TEXT_LOACTOR,emailAddress);
        enterText(PASSWORD_LOCATOR,Password);
        ClickOn(SUBMIT_LOGIN);
        MyAccountPage myAccountPage = new MyAccountPage(getDrvier());
        return myAccountPage;
    }


}
