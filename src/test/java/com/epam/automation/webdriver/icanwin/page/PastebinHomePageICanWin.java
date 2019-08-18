package com.epam.automation.webdriver.icanwin.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PastebinHomePageICanWin {


    protected WebDriver driver;

    @FindBy(xpath = "(//span[@class='select2-selection__rendered'])[2]")
    private WebElement dropdPasteExpiration;
    @FindBy(name = "paste_name")
    private WebElement fieldPasteNAme;
    @FindBy(id = "submit")
    private WebElement buttonCreatNewPast;
    @FindBy(id = "paste_code")
    private WebElement fieldPastCode;

    protected final int WAIT_TIME_SECONDS = 10;
    public static final String HOMEPAGE_URL = "https://pastebin.com";

    private void selectValueInDropDownPasteExpiration(String choseValueOfPasteExpiration) {
        dropdPasteExpiration.click();
        String xpathValueOfPasteExpiration = "//li[@class='select2-results__option' and text()='" + choseValueOfPasteExpiration + "']";
        WebElement chosePasteExpiration = driver.findElement(By.xpath(xpathValueOfPasteExpiration));
        chosePasteExpiration.click();
    }

    public void fillInTheForm(String inputCode, String choseValueOfPasteExpiration, String pasteName) {
        fieldPastCode.sendKeys(inputCode);
        selectValueInDropDownPasteExpiration(choseValueOfPasteExpiration);
        fieldPasteNAme.sendKeys(pasteName);
        buttonCreatNewPast.click();
    }

    protected PastebinHomePageICanWin openPage() {
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, WAIT_TIME_SECONDS);
        return this;
    }

    public PastebinHomePageICanWin(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
