package com.epam.automation.webdriver.hardcore.test;

import com.epam.automation.webdriver.hardcore.page.CloudGoogleCalculatorPage;
import com.epam.automation.webdriver.hardcore.page.CloudGoogleCalculatorResultPage;
import com.epam.automation.webdriver.hardcore.page.TenMinuteMailHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CloudGoogleTest {
    private WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test(groups = " preparation ", alwaysRun = true)
    public void fillInForm() {
//        new CloudGoogleHomePage(driver).openPage();
//        new CloudGoogleProductsPage(driver).openPage();
//        new CloudGooglePricingPage(driver).openPage();
//        new CloudGoogleCalculatorPage(driver).openPage();
        driver.get("https://cloud.google.com/products/calculator/");   /*для быстрой проверки(удалить)*/
        new CloudGoogleCalculatorPage(driver)
                .enterIframe()
                .choseNumberOfInstance("4")
                .choseOperatingSystem("Free: Debian, CentOS, CoreOS, Ubuntu, or other User Provided OS")
                .choseMachineClass("Regular")
                .choseMachineType("n1-standard-8 (vCPUs: 8, RAM: 30GB)")
                .choseAddGPUs()
                .choseNumberOfGPUs("1")
                .choseGPUType("NVIDIA Tesla V100")
                .choseLocalSDD("2x375 GB")
                .choseDataCenterLocation("Frankfurt (europe-west3)")
                .choseCommittedUsage("1 Year")
                .addToEstimate();

//
    }

//    @Test(groups = "Hurt Me Plenty", dependsOnMethods = "fillInForm")
//    public void FieldsAreCorrect() {
//        Assert.assertTrue((new CloudGoogleResultPage(driver).checkResult("VM class").contains("regular") &&
//                new CloudGoogleResultPage(driver).checkResult("Region:").contains("Frankfurt") &&
//                new CloudGoogleResultPage(driver).checkResult("Instance type").contains(" n1-standard-8") &&
//                new CloudGoogleResultPage(driver).checkResult("Total available local SSD space").contains("2x375 GB") &&
//                new CloudGoogleResultPage(driver).checkResult("Commitment term").contains("1 Year") &&
//                new CloudGoogleResultPage(driver).checkResult("Total Estimated Cost").contains("1,187.77")));
//    }


    @Test(groups = "Hardcore", dependsOnMethods = "fillInForm")
    public void checkEmail() {
        CloudGoogleCalculatorResultPage cloudGoogleResultPage = new CloudGoogleCalculatorResultPage(driver);
        String cloudGoogleResultPageWindowHandle = cloudGoogleResultPage.getCurrentWindowHandle();
        String totalEstimateCost = new CloudGoogleCalculatorResultPage(driver).getTotalEstimateCost();
        TenMinuteMailHomePage tenMinuteMailHomePage = new TenMinuteMailHomePage(driver).openPageOnNewTab(TenMinuteMailHomePage.TENMINUTEMAILHOMEPAGE_URL);
        String tenMinuteMailHomePageWindowHandle = tenMinuteMailHomePage.getCurrentWindowHandle();
        String actualEmail = tenMinuteMailHomePage.getEmail();
        cloudGoogleResultPage.switchTabByWindowHandle(cloudGoogleResultPageWindowHandle);
        cloudGoogleResultPage.sendEmail(actualEmail);
        tenMinuteMailHomePage.switchTabByWindowHandle(tenMinuteMailHomePageWindowHandle);




    }
}

