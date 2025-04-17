package com.ui.pages;

import com.contants.Browser;
import com.utility.BroswerUtiltiy;
import com.utility.JSONUtility;
import com.utility.LoggerUtility;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.contants.Env.QA;

public class dummyPage extends BroswerUtiltiy {
    Logger logger = LoggerUtility.GetLogger(this.getClass());
    String filepath ="\\Config\\config.json";

    String url = "https://www.dummyticket.com/dummy-ticket-for-visa-application/";

    public dummyPage(WebDriver driver) {
        super(driver);
        logger.info("Launching the Browser");
        goToWebsite(url);
    }

    private static final By DUMMY_TICKET_FOR_VISA_APPLICATION = By.id("product_549");
    private static final By DUMMY_RETURN_TICKET = By.id("product_550");

    private static final By DUMMY_HOTEL_BOOKING = By.id("product_551");
    private static final By DUMMY_TICKET_AND_HOTEL = By.id("product_3186");
    private static final By PAST_DATED_TICKET = By.id("product_7441");

    private static final By FIRST_NAME = By.id("travname");
    private static final By LAST_NAME = By.id("travlastname");

    private static final By DATE_OF_BIRTH = By.xpath("//label[contains(text(),'Date of birth')]/following-sibling::span/child::input[@id='dob']");

    private static final By DAY_MONTH = By.className("ui-datepicker-month");
    private static final By DAY_YEAR = By.className("ui-datepicker-year");

    private static final By DAY_OF_DOB = By.xpath("//td[@data-handler='selectDay']/a");

    private static final By SEX_MALE = By.xpath("//input[@type='radio' and @value='1' and @id='sex_1']");

    private static final By SEX_FEMALE = By.xpath("//input[@type='radio' and @value='2' and @id='sex_2']");

    private static final By ONE_WAY = By.xpath("//label[contains(text(),'One Way')]/preceding-sibling::input");

    private static final By ROUND_TRIP = By.xpath("//label[contains(text(),'Round trip')]/preceding-sibling::input[1]");

    private static final By FROM_CITY = By.id("fromcity");
    private static final By TO_CITY = By.id("tocity");
    private static final By DEPARTURE_DATE = By.id("departon");
    private static final By RETURN_DATE = By.name("returndate");
    private static final By ADDITIONAL_INFORMATION = By.id("notes");
    private static final By PURPOSE_OF_DUMMY = By.id("select2-reasondummy-container");
    private static final By PURPOSE_OF_DUMMY_TEXT = By.xpath("//input[@aria-owns='select2-reasondummy-results']");
    private static final By PURPOSE_OF_DUMMY_OPTIONS = By.xpath("//ul[@id='select2-reasondummy-results']/li");

    private static final By SUBMISSION_DATE = By.id("appoinmentdate");

    private static final By EMAIL_CHECKBOX = By.id("deliverymethod_1");

    private static final By WHATSAPP_CHECKBOX = By.id("deliverymethod_2");

    private static final By BOTH_CHECKBOX = By.id("deliverymethod_3");

    private static final By BILLING_NAME = By.id("billname");

    private static final By PHONE = By.id("billing_phone");

    private static final By EMAIL_ADDRESS = By.id("billing_email");

    private static final By COUNTRY = By.id("select2-billing_country-container");

    private static final By COUNTRY_LIST = By.id(("select2-billing_country-results"));

    private static final By BILLING_ADDRESS_1 = By.id("billing_address_1");

    private static final By BILLING_ADDRESS_2 = By.id("billing_address_2");

    private static final By BILLING_CITY = By.id("billing_city");

    private static final By BILLING_STATE = By.xpath("//ul[@id='select2-billing_state-results']/li");

    private static final By STATE_DROPDOWN = By.xpath("//span[@id='select2-billing_state-container']");

    private static final By STATE_TEXTBOX = By.xpath("//span[@aria-owns='select2-billing_state-results']");

    private static final By PIN_CODE = By.id("billing_postcode");

    private static final By CREDIT_CARD = By.xpath("//input[@id='payment_method_stripe']");

    private static final By CREDIT_CARD_NUMBER = By.id("Field-numberInput");

    private static final By CREDIT_CARD_EXPIRY = By.id("Field-expiryInput");

    private static final By CREDIT_CARD_CVV = By.id("Field-cvcInput");

    private static final By PAYPAL_METHOD = By.id("payment_method_paypal");

    private static final By PROCEED_TO_PAY = By.xpath("//button[contains(text(),'Proceed to PayPal')]");

    private static final By LIST_OF_CURRENCIES = By.xpath("//div[@class='wmc-list-currencies']");

    private static final By CURRENCIES_LIST = By.xpath("//div[@class='wmc-list-currencies']/div[contains(@class,'wmc-currency')]");

    public dummyPage(Browser browser, boolean isHeadless) {
        super(browser,isHeadless);
        logger.info("Launching the Browser");
        goToWebsite(url);
    }

    public void selectBookingType(String identifierType) {
        logger.info("Selecting the type"+ identifierType);
        switch (identifierType) {

            case "DummyTicketforVisaApplication":
                ClickOn(DUMMY_TICKET_FOR_VISA_APPLICATION);
                break;
            case "DummyReturnTicket":
                ClickOn(DUMMY_RETURN_TICKET);
                break;
            case "DummyTicketandHotel":
                ClickOn(DUMMY_HOTEL_BOOKING);
                break;
            case "PastDatedTicket":
                ClickOn(PAST_DATED_TICKET);
                break;
            case "DummyHotelBooking":
                ClickOn(DUMMY_TICKET_AND_HOTEL);
                break;


        }
    }

    public void enterNames(String firstName, String lastName) {

        logger.info("Enter the names");
        enterText(FIRST_NAME, firstName);
        enterText(LAST_NAME, lastName);

    }

    public dummyPage selectDates(String Yearofdep, String Monthofdep, String DepartureDate, String ArrivalYear,
                                 String ArrivalMonth, String ArrivalDate, String tripType) {
       if(tripType.equals("OneWay"))
       {
           ClickOn(DEPARTURE_DATE);
           selectByVisibleText(DAY_YEAR,Yearofdep);
           selectByVisibleText(DAY_MONTH,Monthofdep);
           clickonefromlistofText(COUNTRY_LIST,DepartureDate);
       }
       else {
           ClickOn(DEPARTURE_DATE);
           selectByVisibleText(DAY_YEAR, Yearofdep);
           selectByVisibleText(DAY_MONTH, Monthofdep);
           selectByVisibleText(DAY_OF_DOB, DepartureDate);
           ClickOn(RETURN_DATE);
           selectByVisibleText(DAY_YEAR, ArrivalYear);
           selectByVisibleText(DAY_MONTH, ArrivalMonth);
           selectByVisibleText(DAY_OF_DOB, ArrivalDate);
       }
        dummyPage dummypage = new dummyPage(getDrvier());
        return dummypage;
    }

    public void dateOfBirth(String year, String month, String day)
    {
        ClickOn(DATE_OF_BIRTH);
        selectByVisibleText(DAY_YEAR,year);
        waits();
        selectByVisibleText(DAY_MONTH,month);
        waits();
        clickonefromlistofText(DAY_OF_DOB,day);
        waits();
    }
    public dummyPage tripDetails(String depCity, String arrCity,String additionalinfo)
    {
        ClickOn(ONE_WAY);
        enterText(FROM_CITY,depCity);
        enterText(TO_CITY,arrCity);
        enterText(ADDITIONAL_INFORMATION,additionalinfo);
        dummyPage dummypage = new dummyPage(getDrvier());
        return dummypage;
    }

    public dummyPage purposeSelection(String purpose,String yearofsub, String monthofsub, String dayofsub)
    {
        ClickOn(PURPOSE_OF_DUMMY);
        clickonefromlistofText(PURPOSE_OF_DUMMY_OPTIONS,purpose);
        ClickOn(RETURN_DATE);
        selectByVisibleText(DAY_YEAR, yearofsub);
        selectByVisibleText(DAY_MONTH, monthofsub);
        selectByVisibleText(DAY_OF_DOB, dayofsub);
        dummyPage dummypage = new dummyPage(getDrvier());
        return dummypage;

    }
    public dummyPage NotificationReceiving(String typeofnotification)
    {
        switch (typeofnotification) {
            case "Email":
                ClickOn(EMAIL_CHECKBOX);
            case "WhatsApp":
                ClickOn(WHATSAPP_CHECKBOX);
            case "Both":
                ClickOn(BOTH_CHECKBOX);

        }
        dummyPage dummypage = new dummyPage(getDrvier());
        return dummypage;
    }
    public dummyPage billingDetails(String billingName,String phone, String emailAddress, String country, String Address1,
                                    String Address2,String City, String State, String Pincode)
    {
        enterText(BILLING_NAME,billingName);
        enterText(PHONE,phone);
        enterText(EMAIL_ADDRESS,emailAddress);
        ClickOn(COUNTRY);
        clickonefromlistofText(COUNTRY_LIST,country);
        ClickOn(STATE_DROPDOWN);
        clickonefromlistofText(BILLING_STATE,State);
        enterText(BILLING_CITY,City);
        enterText(BILLING_ADDRESS_1,Address1);
        enterText(BILLING_ADDRESS_2,Address2);
        enterText(PIN_CODE,Pincode);
        dummyPage dummypage = new dummyPage(getDrvier());
        return dummypage;
    }
    public dummyPage enterCreditDetails(String cardNumber, String ExpiryDate,String CVV)
    {
        ClickOn(CREDIT_CARD);
        enterText(CREDIT_CARD_NUMBER,cardNumber);
        enterText(CREDIT_CARD_EXPIRY,ExpiryDate);
        enterText(CREDIT_CARD_CVV,CVV);
        ClickOn(PROCEED_TO_PAY);
        dummyPage dummypage = new dummyPage(getDrvier());
        return dummypage;
    }
    public dummyPage currenyType(String currencyType)
    {
        ClickOn(CURRENCIES_LIST);
        clickonefromlistofText(LIST_OF_CURRENCIES  ,currencyType);
        dummyPage dummypage = new dummyPage(getDrvier());
        return dummypage;
    }

    public dummyPage sexType(String type)
    {
        switch (type)
        {
            case  "MALE" :
                    ClickOn(SEX_MALE);
                    break;
            case "FEMALE" :
                ClickOn(SEX_FEMALE);
                break;
        }
        dummyPage dummypage = new dummyPage(getDrvier());
        return dummypage;
    }

























}
