package com.epam.automation.webdriver.hardcore.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CloudGoogleCalculatorResultPage extends AbstractPage {


    private static final String PATTERN_XPATH_RESULT = "//*[contains(text(),'%s')]";
    @FindBy(id = "email_quote")
    WebElement emailEstimateButton;
    @FindBy(xpath = "//label[contains(text(),'Email')]/following-sibling::input")
    WebElement pastEmailField;
    @FindBy(xpath = "//button[contains(text(),'Send Email') and not(@disabled)]")
    WebElement sendEmailButton;
    @FindBy(id = "idIframe")
    WebElement iFrame;

    public String checkResult(String value) {
        String xpathResultValue = String.format(PATTERN_XPATH_RESULT, value);
        return new WebDriverWait(driver, WAIT_TIME_SECONDS).until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathResultValue))).getText();

    }

    public String getTotalEstimateCost() {
        return checkResult("Total Estimated Cost").replaceAll("Total Estimated Cost:", "").replaceAll(" per 1 month", "");
    }

    @Override
    public AbstractPage openPage() {
        throw new RuntimeException("Please 'think twice' whether you need to use these method, " +
                "if direct access is still needed - please dig into Google Java Style Guide " +
                "or avoid inheritance from AbstractPage " +
                "or remove openPage() method from AbstractPage");
    }

    public CloudGoogleCalculatorResultPage(WebDriver driver) {
        super(driver);
    }

    public CloudGoogleCalculatorResultPage sendEmail(String email) {

        new WebDriverWait(driver, WAIT_TIME_SECONDS).until(ExpectedConditions.elementToBeClickable(iFrame));
        driver.switchTo().frame(iFrame);
        new WebDriverWait(driver, WAIT_TIME_SECONDS).until(ExpectedConditions.elementToBeClickable(emailEstimateButton))
                .click();
        new WebDriverWait(driver, WAIT_TIME_SECONDS).until(ExpectedConditions.elementToBeClickable(pastEmailField))
                .sendKeys(email);
        new WebDriverWait(driver, WAIT_TIME_SECONDS).until(ExpectedConditions.elementToBeClickable(sendEmailButton))
                .click();
        new WebDriverWait(driver, WAIT_TIME_SECONDS).until(ExpectedConditions.elementToBeClickable(emailEstimateButton));

        return this;
    }
}
