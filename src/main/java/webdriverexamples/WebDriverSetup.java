package webdriverexamples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;


public class WebDriverSetup {
    static int DEFAULT_WAIT_TIME = 3000;
    WebDriver driver; // This needs to be defined outside the methods so variables / classes can transfer from @Before to @Test scopes

    @BeforeMethod
    public static WebDriver setupBrowser() throws InterruptedException {
        WebDriverManager.chromedriver().setup(); // Setup browser and driver versions
        WebDriver driver = new ChromeDriver(); // Initialize Chrome Driver
        driver.manage().window().maximize(); // Maximize the browser window
        Thread.sleep(DEFAULT_WAIT_TIME);
        return driver;

    }
}
