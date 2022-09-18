package applications.way2automate.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public abstract class AbstractComponent {

    public WebDriver _driver;

    public AbstractComponent(WebDriver driver) {

        this._driver = driver;
    }

    public void navigate(String url) {
        _driver.navigate().to(url);
    }

    // Find elements
    public List<WebElement> find(By by) {
        WebDriverWait wait = new WebDriverWait(_driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    // Click
    public void click(By by){
        findOne(by).click();
    }

    // Send Keys
    public void sendKeys(By by, String text){
        findOne(by).sendKeys(text);
    }

    // Select from a dropdown
    public void selectFromDropdown(By by, String text) {
        Select select = new Select(findOne(by));
        select.selectByVisibleText(text);

    }

    // Get text
    public String getText(By by) {
        return findOne(by).getText();
    }


    public abstract By scopedLocator();
    public WebElement scopedElement = null;

    public WebElement findOne(By by) {

        WebDriverWait wait = new WebDriverWait(_driver, Duration.ofSeconds(5));
        if (scopedElement == null) {
            scopedElement = wait.until(ExpectedConditions.presenceOfElementLocated(scopedLocator()));
        }

        return scopedElement.findElement(by);
    }

}
