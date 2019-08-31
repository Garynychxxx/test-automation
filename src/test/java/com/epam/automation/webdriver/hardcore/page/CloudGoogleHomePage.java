package com.epam.automation.webdriver.hardcore.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CloudGoogleHomePage extends AbstractPage {
    public static final String HOMEPAGE_URL = "https://cloud.google.com";
    public static final String SE = "https://cloud.google.com";

    @FindBy(xpath = "//input[@class='devsite-search-field devsite-search-query']")
    WebElement searchButton;

    @Override
    public CloudGoogleHomePage openPage() {
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, WAIT_TIME_SECONDS);
        return this;
    }

    public CloudGoogleHomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@class = 'cloud-button cloud-button--flat']")
    WebElement linkSeeAllProducts;
    @FindBy(xpath = "//a[2][@class = 'cloud-button cloud-button--secondary']")
    WebElement linkSeePricing;
    @FindBy(xpath = "//a[text()= 'Calculators']")
    WebElement linkCalculators;

    public CloudGoogleSearchResultPage gotoSearchResultPage(String serchTerm) {
        linkSeeAllProducts.click();
        new WebDriverWait(driver, WAIT_TIME_SECONDS).until(ExpectedConditions.elementToBeClickable(linkSeeAllProducts)).click();
        return new CloudGoogleSearchResultPage(driver, serchTerm);
    }


}
