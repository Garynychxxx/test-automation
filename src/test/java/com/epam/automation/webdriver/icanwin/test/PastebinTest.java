package com.epam.automation.webdriver.icanwin.test;

import com.epam.automation.webdriver.icanwin.page.PastebinHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PastebinTest {

    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(PastebinHomePage.HOMEPAGE_URL);
    }

    @Test(description = "Test WebDriver, I Can Win")
    public void filInTheForm() {
        String inputCode = "Hello from WebDriver";
        String pasteName = "helloweb";
        String valueOfPasteExpiration = "10 Minutes";

        PastebinHomePage pastebinHomePage = new PastebinHomePage(driver);
        pastebinHomePage.fillInTheForm(inputCode, valueOfPasteExpiration, pasteName);

    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}
