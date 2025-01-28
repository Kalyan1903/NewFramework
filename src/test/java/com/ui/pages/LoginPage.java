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

    private static final By ERROR_MESSAGE = By.xpath("//div[contains(@class,'alert alert-danger')]/ol/li");

    public MyAccountPage doLoginWith(String emailAddress, String Password)
    {
        enterText(EMAIL_TEXT_LOACTOR,emailAddress);
        enterText(PASSWORD_LOCATOR,Password);
        ClickOn(SUBMIT_LOGIN);
        MyAccountPage myAccountPage = new MyAccountPage(getDrvier());
        return myAccountPage;
    }

    public LoginPage doLoginWithInvalidCredintials(String emailAddress, String Password)
    {
        enterText(EMAIL_TEXT_LOACTOR,emailAddress);
        enterText(PASSWORD_LOCATOR,Password);
        ClickOn(SUBMIT_LOGIN);
        LoginPage loginPage = new LoginPage(getDrvier());
        return loginPage;

    }

    public String getErrorMessage()
    {
       return getText(ERROR_MESSAGE);
    }




}
