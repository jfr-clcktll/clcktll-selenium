package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import selenium.SeleniumCommandWrapper;


public class LoginPageTest {

    int DEFAULT_WAIT_TIME = 3000;
    String WEBLINK_SAUCE = "https://www.saucedemo.com/";
    String WEBLINK_W2A = "https://www.way2automation.com/angularjs-protractor/banking/#login";

    public WebDriver driver;

    // SAUCE DEMO PARAMETERS
    public By usernameField = By.xpath("//*[@id=\"user-name\"]");
    public By passwordField = By.xpath("//*[@id=\"password\"]");
    public By submitBtn = By.xpath("//*[@id=\"login-button\"]");

    // WAY 2 AUTOMATE PARAMETERS
    public By customerLoginField = By.xpath("/html/body/div[3]/div/div[2]/div/div[1]/div[1]/button");
    public By yourNameField = By.xpath("//*[@id=\"userSelect\"]");
    public By loginBtn = By.xpath("/html/body/div[3]/div/div[2]/div/form/button");
    public By depositBtn = By.xpath("/html/body/div[3]/div/div[2]/div/div[3]/button[2]");
    public By depositAmount = By.xpath("/html/body/div[3]/div/div[2]/div/div[4]/div/form/div/input");
    public By depositSubmitBtn = By.xpath("/html/body/div[3]/div/div[2]/div/div[4]/div/form/button");
    public By depositStatus = By.xpath("/html/body/div[3]/div/div[2]/div/div[4]/div/span");

    @BeforeMethod
    public void setupBrowser() throws InterruptedException{
        WebDriverManager.chromedriver().setup(); // Setup browser and driver versions
        driver = new ChromeDriver(); // Initialize Chrome Driver
        driver.manage().window().maximize(); // Maximize the browser window
        Thread.sleep(DEFAULT_WAIT_TIME);

    }

    @Test
    public void verifyLoginSauceDemo() throws InterruptedException {

        driver.get(WEBLINK_SAUCE); // Opens this address in Chrome
        Thread.sleep(DEFAULT_WAIT_TIME);

        findOne(usernameField).sendKeys("standard_user");
        Thread.sleep(1000);
        findOne(passwordField).sendKeys("secret_sauce");
        Thread.sleep(1000);
        findOne(submitBtn).click();
        Thread.sleep(DEFAULT_WAIT_TIME);

    }


    @Test
    public void verifyLoginWay2Auto() throws InterruptedException {

        driver.get(WEBLINK_W2A); // Opens this address in Chrome
        Thread.sleep(DEFAULT_WAIT_TIME);

        findOne(customerLoginField).click();
        Thread.sleep(1000);

        Select select = new Select(findOne(yourNameField));
        select.selectByVisibleText("Harry Potter");
        //findOne(yourNameField).sendKeys("Harry Potter"); # Alternate method to select Harry Potter value
        Thread.sleep(1000);

        findOne(loginBtn).click();
        Thread.sleep(DEFAULT_WAIT_TIME);

        findOne(depositBtn).click();
        Thread.sleep(DEFAULT_WAIT_TIME);

        findOne(depositAmount).sendKeys("5000");
        Thread.sleep(DEFAULT_WAIT_TIME);

        findOne(depositSubmitBtn).click();
        Thread.sleep(DEFAULT_WAIT_TIME);

        Assert.assertEquals(findOne(depositStatus).getText(),"Deposit Successful"); // Verify that element is displayed on page

    }

    // Same test as above but with the more efficient way of using Wrappers - 9 lines of code vs 25
    @Test
    public void verifyLoginWay2AutoWithWrapper(){

        SeleniumCommandWrapper scw = new SeleniumCommandWrapper(driver);

        scw.navigate(WEBLINK_W2A);
        scw.click(customerLoginField);
        scw.selectFromDropdown(yourNameField, "Harry Potter");
        scw.click(loginBtn);
        scw.click(depositBtn);
        scw.sendKeys(depositAmount,"2500");
        scw.click(depositSubmitBtn);
        Assert.assertEquals(scw.getText(depositStatus), "Deposit Successful");

    }

    public WebElement findOne(By by) {

        return driver.findElement(by);

    }

    @AfterMethod
    public void quitBrowser() {
        driver.quit(); // Exit the browser
    }


}
