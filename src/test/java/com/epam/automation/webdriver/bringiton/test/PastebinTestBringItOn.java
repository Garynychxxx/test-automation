package com.epam.automation.webdriver.bringiton.test;

import com.epam.automation.webdriver.bringiton.page.PastebinHomePageBringItOn;
import com.epam.automation.webdriver.bringiton.page.PastebinResultPageBringItOn;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PastebinTestBringItOn {

    private WebDriver driver;
    private String pasteName = "how to gain dominance among developers";
    private String inputCode = "git config --global user.name  \"New Sheriff in Town\"" +
            "\n" + "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")" +
            "\n" + "git push origin master --force";
    private String valueOfPasteExpiration = "10 Minutes";
    private String valueOfSyntaxHighLighting = "Bash";

    @BeforeClass(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(PastebinHomePageBringItOn.HOMEPAGE_URL);

        PastebinHomePageBringItOn pastebinHomePageBringItOn = new PastebinHomePageBringItOn(driver);
        pastebinHomePageBringItOn.fillInTheForm(inputCode, valueOfSyntaxHighLighting, valueOfPasteExpiration, pasteName);
    }


    @Test(alwaysRun = true)
    public void pageTitleMatches() {

        String exceptedTitle = new PastebinResultPageBringItOn(driver).checkTitle().replaceAll(" - Pastebin.com", "")
                .replaceAll("\\[.*?\\] ", "");
        Assert.assertEquals(exceptedTitle, pasteName, "Browser page title does not match");
    }

    @Test(alwaysRun = true)
    public void syntaxHighlightingIsMatch() {
        String syntaxHighlighting = new PastebinResultPageBringItOn(driver).checkTypeOfSyntaxHighlighting();
        Assert.assertEquals(syntaxHighlighting, valueOfSyntaxHighLighting, "Syntax Highlighting is not Bash");
    }

    @Test(alwaysRun = true)
    public void codeIsMach() {
        String outputCode = new PastebinResultPageBringItOn(driver).checkOutputCode();
        Assert.assertEquals(outputCode, inputCode, "Input and Output codes aren't match");
    }


    @AfterClass(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}
