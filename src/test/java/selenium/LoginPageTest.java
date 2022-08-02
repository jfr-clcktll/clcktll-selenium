package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginPageTest {

    int DEFAULT_WAIT_TIME = 3000;
    String WEBLINK_SAUCE = "https://www.saucedemo.com/";
    String WEBLINK_W2A = "https://www.way2automation.com/angularjs-protractor/banking/#login";

    public WebDriver driver;

    public By usernameField = By.xpath("//*[@id=\"user-name\"]");
    public By passwordField = By.xpath("//*[@id=\"password\"]");
    public By submitBtn = By.xpath("//*[@id=\"login-button\"]");

    public By customerLoginField = By.xpath("/html/body/div[3]/div/div[2]/div/div[1]/div[1]/button");
    public By yourNameField = By.xpath("//*[@id=\"userSelect\"]");
    public By loginBtn = By.xpath("/html/body/div[3]/div/div[2]/div/form/button");

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
        findOne(yourNameField).sendKeys("Harry Potter");
        Thread.sleep(1000);
        findOne(loginBtn).click();
        Thread.sleep(DEFAULT_WAIT_TIME);

    }

    public WebElement findOne(By by) {

        return driver.findElement(by);

    }

    @AfterMethod
    public void quitBrowser() {
        driver.quit(); // Exit the browser
    }


}
