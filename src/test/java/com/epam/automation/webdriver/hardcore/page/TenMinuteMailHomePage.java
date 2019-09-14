package com.epam.automation.webdriver.hardcore.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TenMinuteMailHomePage extends AbstractPage {
    @FindBy(id = "mailAddress")
    WebElement mailAddress;
    @FindBy(id = "messagesList")
    WebElement emailFromCloudGoogle;
    @FindBy(xpath = "//*[@id='mobilepadding']/td/h2")
    WebElement resultOfMail;

    public static final String TENMINUTEMAILHOMEPAGE_URL = "https://10minutemail.com";
    protected final int WAIT_TIME_SECONDS_FOR_MESSAGE = 60;

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

    public String getEmail() {
        return mailAddress.getAttribute("value");
    }

    public String getTotalEstimate() {
        new WebDriverWait(driver, WAIT_TIME_SECONDS_FOR_MESSAGE).until(ExpectedConditions.elementToBeClickable(emailFromCloudGoogle));
        driver.findElements(By.id("messagesList")).get(0).click();
        return new WebDriverWait(driver, WAIT_TIME_SECONDS).until(ExpectedConditions.visibilityOf(resultOfMail)).getText();
    }
}
