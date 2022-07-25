package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;



public class SeleniumTest {

    String websiteLink = "http://parabank.parasoft.com";

    @Test
    public void startAndStopABrowser() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get(websiteLink);

        Thread.sleep(3000);

        driver.quit();
    }
}
