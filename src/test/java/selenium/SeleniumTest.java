package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SeleniumTest {

    // PARAMETERS
    String WEBLINK_PARABANK = "http://parabank.parasoft.com";
    String USERNAME = "john";
    String PASSWORD = "demo";
    int DEFAULT_WAIT_TIME = 3000;

    String PAGE_TITLE = "ParaBank | Accounts Overview";


    @Test
    public void verifyParaBankLogin() throws InterruptedException {

        WebDriverManager.chromedriver().setup(); // Setup browser and driver versions
        WebDriver driver = new ChromeDriver(); // Initialize Chrome Driver

        driver.manage().window().maximize(); // Maximize the browser window
        driver.get(WEBLINK_PARABANK); // Opens this address in Chrome
        Thread.sleep(DEFAULT_WAIT_TIME);


        driver.findElement(By.name("username")).sendKeys(USERNAME); // Find username field and enters username
        Thread.sleep(1000);

        driver.findElement(By.name("password")).sendKeys(PASSWORD); // Find password field and enters password
        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@value='Log In']")).click(); // Find Log in button field and click it
        Thread.sleep(DEFAULT_WAIT_TIME);


        String title = driver.getTitle(); // Get page title
        Assert.assertEquals(title, PAGE_TITLE); // Verify page title

        //WebElement tabHeading = driver.findElement(By.xpath("/html/head/title")); // Find an element with said ID
        //Assert.assertTrue(tabHeading.equals("ParaBank | Accounts Overview"));


        WebElement accountsOverviewTitle = driver.findElement(By.xpath("//h1[text()='Accounts Overview']")); // Find an element with said xpath
        Assert.assertTrue(accountsOverviewTitle.isDisplayed()); // Verify that element is displayed on page

        driver.quit(); // Exit the browser
    }
}
