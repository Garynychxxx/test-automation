package com.epam.automation.webdriver.hardcore.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TenMinuteMailHomePage extends AbstractPage {
    @FindBy(id ="mailAddress")
    WebElement mailAddress;

    public static final String TENMINUTEMAILHOMEPAGE_URL = "https://10minutemail.com";
    public TenMinuteMailHomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public TenMinuteMailHomePage openPage() {
        driver.get(TENMINUTEMAILHOMEPAGE_URL);
        new WebDriverWait(driver, WAIT_TIME_SECONDS);
        return this;
    }

    @Override
    public TenMinuteMailHomePage openPageOnNewTab(String pageUrl) {
        return (TenMinuteMailHomePage) super.openPageOnNewTab(pageUrl);
    }
    public String getEmail(){

        return mailAddress.getAttribute("value");

    }
}
