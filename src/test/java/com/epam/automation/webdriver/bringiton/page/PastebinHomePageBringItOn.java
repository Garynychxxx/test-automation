package com.epam.automation.webdriver.bringiton.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PastebinHomePageBringItOn extends PastebinAbstractPageBringItOn {


    @FindBy(xpath = "(//span[@class='select2-selection__rendered'])[2]")
    private WebElement dropdPasteExpiration;
    @FindBy(xpath = "(//span[@class='select2-selection__rendered'])[1]")
    private WebElement dropdSyntaxHighlighting;
    @FindBy(name = "paste_name")
    private WebElement fieldPasteNAme;
    @FindBy(id = "submit")
    private WebElement buttonCreatNewPast;
    @FindBy(id = "paste_code")
    private WebElement fieldPastCode;

    public static final String HOMEPAGE_URL = "https://pastebin.com";

    private void selectValueInDropDownPasteExpiration(String valueOfPasteExpiration) {
        dropdPasteExpiration.click();
        String xpathValueOfPasteExpiration = "//li[@class='select2-results__option' and text()='" + valueOfPasteExpiration + "']";
        WebElement chosePasteExpiration = driver.findElement(By.xpath(xpathValueOfPasteExpiration));
        chosePasteExpiration.click();
    }

    private void selectValueInDropDownSyntaxHighlighting(String valueOfSyntaxHighlighting) {
        dropdSyntaxHighlighting.click();
        String xpathValueOfPasteExpiration = "//li[@class='select2-results__option' and text()='" + valueOfSyntaxHighlighting + "']";
        WebElement chosePasteExpiration = driver.findElement(By.xpath(xpathValueOfPasteExpiration));
        chosePasteExpiration.click();
    }

    public void fillInTheForm(String inputCode, String valueOfSyntaxHighlighting, String valueOfPasteExpiration, String pasteName) {
        fieldPastCode.sendKeys(inputCode);
        selectValueInDropDownPasteExpiration(valueOfPasteExpiration);
        selectValueInDropDownSyntaxHighlighting(valueOfSyntaxHighlighting);
        fieldPasteNAme.sendKeys(pasteName);

        buttonCreatNewPast.click();
    }

    protected PastebinHomePageBringItOn openPage() {
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, WAIT_TIME_SECONDS);
        return this;
    }

    public PastebinHomePageBringItOn(WebDriver driver) {
        super(driver);

    }
}
