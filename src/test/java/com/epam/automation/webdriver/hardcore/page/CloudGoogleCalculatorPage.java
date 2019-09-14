package com.epam.automation.webdriver.hardcore.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CloudGoogleCalculatorPage extends AbstractPage {
    private static final String PATTERN_XPATH_CHOICE_DROP_DOWN_MENU = "//div[@class='md-select-menu-container md-active md-clickable']//*[contains(text(),'%s')]";
    @FindBy(xpath = "//a[text()= 'Calculators']")
    WebElement linkCalculators;
    @FindBy(id = "idIframe")
    WebElement iFrame;
    @FindBy(id = "input_52")
    WebElement selectorNumberOfInstance;
    @FindBy(id = "select_value_label_45")
    WebElement selectorOperatingSystem;
    @FindBy(id = "select_value_label_46")
    WebElement selectorMachineClass;
    @FindBy(id = "select_75")
    WebElement selectorMachineType;
    @FindBy(xpath = "//div[contains(text(),'Add GPUs.')]/preceding-sibling::div")
    WebElement checkBoxAddGPUs;
    @FindBy(id = "select_value_label_49")
    WebElement selectorLocalSDD;
    @FindBy(xpath = "//*[@id='select_value_label_339' and not(@disabled)]")
    WebElement selectorNumberOfGPUs;
    @FindBy(id = "select_value_label_340")
    WebElement selectorGPUType;
    @FindBy(xpath = "//*[@id = 'select_value_label_50' and not(@disabled)]")
    WebElement selectorDatacenterLocation;
    @FindBy(xpath = "//*[@id ='select_value_label_51' and not(@disabled)]")
    WebElement selectorCommitedUsage;

    @FindBy(xpath = "//form[@name='ComputeEngineForm']//*[contains(text(),'Add to Estimate')]")
    WebElement buttonAddToEstimate;

    public static final String CALCULATORPAGE_URL = "https://cloud.google.com/products/calculator/";


    @Override
    public CloudGoogleCalculatorPage openPage() {
        new WebDriverWait(driver, WAIT_TIME_SECONDS).until(ExpectedConditions.elementToBeClickable(linkCalculators)).click();
        return this;
    }

    public CloudGoogleCalculatorPage(WebDriver driver) {
        super(driver);
    }

    public CloudGoogleCalculatorPage enterIframe() {
        new WebDriverWait(driver, WAIT_TIME_SECONDS).until(ExpectedConditions.elementToBeClickable(iFrame));
        driver.switchTo().frame(iFrame);
        return this;
    }

    public CloudGoogleCalculatorPage choseNumberOfInstance(String value) {
        new WebDriverWait(driver, WAIT_TIME_SECONDS).until(ExpectedConditions.elementToBeClickable(selectorNumberOfInstance)).sendKeys(value);
        return this;
    }

    public CloudGoogleCalculatorPage choseOperatingSystem(String value) {
        fillInCheckBox(selectorOperatingSystem, value);
        return this;
    }

    public CloudGoogleCalculatorPage choseMachineType(String value) {

        fillInCheckBox(selectorMachineType, value);
        return this;

    }

    public CloudGoogleCalculatorPage choseMachineClass(String value) {
        fillInCheckBox(selectorMachineClass, value);
        return this;
    }

    public CloudGoogleCalculatorPage choseAddGPUs() {
        new WebDriverWait(driver, WAIT_TIME_SECONDS).until(ExpectedConditions.elementToBeClickable(checkBoxAddGPUs)).click();
        return this;
    }

    public CloudGoogleCalculatorPage choseLocalSDD(String value) {

        fillInCheckBox(selectorLocalSDD, value);
        return this;
    }

    public CloudGoogleCalculatorPage addToEstimate() {
        new WebDriverWait(driver, WAIT_TIME_SECONDS).until(ExpectedConditions.elementToBeClickable(buttonAddToEstimate)).click();
        return this;
    }

    public CloudGoogleCalculatorPage choseNumberOfGPUs(String value) {
        fillInCheckBox(selectorNumberOfGPUs, value);
        return this;
    }

    public CloudGoogleCalculatorPage choseGPUType(String value) {
        fillInCheckBox(selectorGPUType, value);
        return this;
    }

    public CloudGoogleCalculatorPage choseDataCenterLocation(String value) {
        fillInCheckBox(selectorDatacenterLocation, value);
        return this;
    }

    public CloudGoogleCalculatorPage choseCommittedUsage(String value) {
        fillInCheckBox(selectorCommitedUsage, value);
        return this;
    }


    public CloudGoogleCalculatorPage fillInCheckBox(WebElement webElement, String value) {
        new WebDriverWait(driver, WAIT_TIME_SECONDS).until(ExpectedConditions.elementToBeClickable(webElement)).click();
        String xpathValue = String.format(PATTERN_XPATH_CHOICE_DROP_DOWN_MENU, value);
        new WebDriverWait(driver, WAIT_TIME_SECONDS).until(ExpectedConditions.elementToBeClickable(By.xpath(xpathValue))).click();
        return this;
    }


}
