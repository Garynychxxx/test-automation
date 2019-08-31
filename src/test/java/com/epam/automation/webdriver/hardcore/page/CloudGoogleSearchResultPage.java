package com.epam.automation.webdriver.hardcore.page;

import org.openqa.selenium.WebDriver;

public class CloudGoogleSearchResultPage extends AbstractPage {
    private String searchTearm;

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
}
