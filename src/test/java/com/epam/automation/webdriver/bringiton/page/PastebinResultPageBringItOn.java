package com.epam.automation.webdriver.bringiton.page;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class PastebinResultPageBringItOn extends PastebinAbstractPageBringItOn {

    @FindBy(xpath = "//a[text()='Bash']")
    WebElement typeOfSyntaxHighlighting;

    @FindBy(id = "paste_code")
    WebElement pasteCode;


    public String checkTypeOfSyntaxHighlighting() {
        return typeOfSyntaxHighlighting.getText();
    }

    public String checkTitle() {

        return driver.getTitle();
    }

    public String checkOutputCode() {
        return pasteCode.getText();
    }


    protected PastebinHomePageBringItOn openPage() throws Exception {

        throw new RuntimeException("Please 'think twice' whether you need to use these method, " +
                "if direct access is still needed - please dig into Google Java Style Guide " +
                "or avoid inheritance from AbstractPage " +
                "or remove openPage() method from AbstractPage");
    }

    public PastebinResultPageBringItOn(WebDriver driver) {

        super(driver);

    }
}


