package com.epam.automation.webdriver.hardcore.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CloudGoogleProductsPage extends AbstractPage {
    @FindBy(xpath = "//a[@class = 'cloud-button cloud-button--flat']")
    WebElement linkSeeAllProducts;

    public CloudGoogleProductsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public CloudGoogleProductsPage openPage() {
        new WebDriverWait(driver, WAIT_TIME_SECONDS).until(ExpectedConditions.elementToBeClickable(linkSeeAllProducts))
                .click();
        return this;
    }
}
