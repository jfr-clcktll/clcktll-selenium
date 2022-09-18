package selenium;

import applications.way2automate.BankingApplication;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import webdriverexamples.WebDriverSetup;

public class SessionEightModelBasedTests {

    WebDriver driver = WebDriverSetup.setupBrowser(); // Always add this as Global variable, so it can be accessed by all tests

    public SessionEightModelBasedTests() throws InterruptedException {
    }


    @Test
    public void verifyWay2AutoDeposit() {

        BankingApplication bankingApp = new BankingApplication(driver);

        bankingApp.loginPage.login("Harry Potter");
        boolean isDepositDone = bankingApp.accountPage.makeDeposit(1337, "1005");
        Assert.assertTrue(isDepositDone);

        boolean isWithdrawalDone = bankingApp.accountPage.makeWithdrawal(37, "1005");
        Assert.assertTrue(isWithdrawalDone);

    }

    @AfterMethod
    public void quitBrowser() {
        driver.quit(); // Exit the browser
    }
}
