package com.epam.automation.webdriver.bringiton.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class PastebinAbstractPageBringItOn {
    protected WebDriver driver;
    protected final int WAIT_TIME_SECONDS = 10;

    protected abstract PastebinAbstractPageBringItOn openPage() throws Exception;

    public PastebinAbstractPageBringItOn(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}



