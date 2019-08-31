package com.epam.automation.webdriver.hardcore.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public abstract class AbstractPage {
    protected WebDriver driver;
    protected final int WAIT_TIME_SECONDS = 10;

    public abstract AbstractPage openPage();

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public AbstractPage openPageOnNewTab(String pageUrl) {
        String script = String.format("window.open('%s','about:blank');", pageUrl);
        ((JavascriptExecutor) driver).executeScript(script);
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        return this;

    }

    public void switchTabByWindowHandle(String windowHandle) {
        driver.switchTo().window(windowHandle);
    }

    public String getCurrentWindowHandle() {
        return driver.getWindowHandle();
    }
}
