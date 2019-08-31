package com.epam.automation.webdriver.hardcore.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CloudGooglePricingPage extends AbstractPage {
    @FindBy(xpath = "//a[2][@class = 'cloud-button cloud-button--secondary']")
    WebElement linkSeePricing;

    public CloudGooglePricingPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public CloudGooglePricingPage openPage() {

        new WebDriverWait(driver, WAIT_TIME_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(linkSeePricing))
                .click();
        return this;
    }

}
