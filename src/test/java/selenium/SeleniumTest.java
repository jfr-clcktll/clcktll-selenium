package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

import javax.xml.ws.WebEndpoint;
import java.util.List;
import java.util.Locale;

public class SeleniumTest {

    // PARAMETERS
    String WEBLINK = "http://parabank.parasoft.com";
    String USERNAME = "john";
    String PASSWORD = "demo";
    int DEFAULT_WAIT_TIME = 3000;

    String PAGE_TITLE = "ParaBank | Accounts Overview";

    WebDriver driver; // This needs to be defined outside the methods so variables / classes can transfer from @Before to @Test scopes

    @BeforeMethod
    public void setupBrowser() throws InterruptedException{
        WebDriverManager.chromedriver().setup(); // Setup browser and driver versions
        driver = new ChromeDriver(); // Initialize Chrome Driver
        driver.manage().window().maximize(); // Maximize the browser window
        Thread.sleep(DEFAULT_WAIT_TIME);

    }


    @BeforeMethod
    public void verifyParaBankLogin() throws InterruptedException {

        driver.get(WEBLINK); // Opens this address in Chrome
        Thread.sleep(DEFAULT_WAIT_TIME);

        driver.findElement(By.name("username")).sendKeys(USERNAME); // Find username field and enters username
        Thread.sleep(1000);

        driver.findElement(By.name("password")).sendKeys(PASSWORD); // Find password field and enters password
        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@value='Log In']")).click(); // Find Log in button field and click it
        Thread.sleep(DEFAULT_WAIT_TIME);

    }

    @Test
    public void verifyHeadingsLandingPage() throws InterruptedException{
        String title = driver.getTitle(); // Get page title
        Assert.assertEquals(title, PAGE_TITLE); // Verify page title

        WebElement accountsOverviewTitle = driver.findElement(By.xpath("//h1[text()='Accounts Overview']")); // Find an element with said xpath
        Assert.assertTrue(accountsOverviewTitle.isDisplayed()); // Verify that element is displayed on page

    }

    @Test
    public void verifyLoanApplication() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id='leftPanel']/ul/li[7]/a")).click(); // Find and click Request Loan Link
        Thread.sleep(DEFAULT_WAIT_TIME);
        driver.findElement(By.id("amount")).sendKeys("1000"); // Enter 1000 in the Loan Amount field
        driver.findElement(By.id("downPayment")).sendKeys("100"); // Enter 100 in the Down Payment field
        driver.findElement(By.xpath("//input[@value='Apply Now']")).click(); // Find Apply  in button field and click it
        Thread.sleep(DEFAULT_WAIT_TIME);

        String loanStatus = driver.findElement(By.id("loanStatus")).getText();
        System.out.println("xxxxxxxxxxx-------------------xxxxxxxxxxx");
        System.out.println("Your loan has been " + loanStatus.toUpperCase());
        System.out.println("xxxxxxxxxxx-x------------------xxxxxxxxxxx");

    }

    @AfterMethod
    public void quitBrowser() {
        driver.quit(); // Exit the browser
    }
}
