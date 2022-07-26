package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class SeleniumTest {

    String WEBLINK_PARABANK = "http://parabank.parasoft.com";
    String USERNAME = "john";
    String PASSWORD = "demo";
    int DEFAULT_WAIT_TIME = 3000;


    @Test
    public void verifyParaBankLogin() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get(WEBLINK_PARABANK);
        Thread.sleep(DEFAULT_WAIT_TIME);

        driver.findElement(By.name("username")).sendKeys(USERNAME);
        Thread.sleep(1000);

        driver.findElement(By.name("password")).sendKeys(PASSWORD);
        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@value='Log In']")).click();
        Thread.sleep(DEFAULT_WAIT_TIME);

        driver.quit();
    }
}
