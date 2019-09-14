package com.epam.automation.webdriver.hardcore.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CloudGoogleSearchResultPage extends AbstractPage {
    private String searchTearm;
    private static final String PATTERN_XPATH_SEARCH_RESULT = "//a[@class='gs-title']//*[contains(text(),'%s')]";

    public CloudGoogleSearchResultPage(WebDriver driver, String searchTerm) {
        super(driver);
        this.searchTearm = searchTerm;
    }

    @Override
    public AbstractPage openPage() {
        throw new RuntimeException("Please 'think twice' whether you need to use these method, " +
                "if direct access is still needed - please dig into Google Java Style Guide " +
                "or avoid inheritance from AbstractPage " +
                "or remove openPage() method from AbstractPage");
    }
    public CloudGoogleCalculatorPage goToleCalculatorPage(){
        String xpathSearchResult = String.format(PATTERN_XPATH_SEARCH_RESULT, searchTearm);
        new WebDriverWait(driver, WAIT_TIME_SECONDS).until(ExpectedConditions.elementToBeClickable(By.xpath(xpathSearchResult))).click();
        return new CloudGoogleCalculatorPage(driver);
    }
}
