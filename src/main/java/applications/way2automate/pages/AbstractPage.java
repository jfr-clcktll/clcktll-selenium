package applications.way2automate.pages;

import org.openqa.selenium.WebDriver;
import webdriverexamples.SeleniumCommandWrapper;

public abstract class AbstractPage {

    public WebDriver _driver;
    public SeleniumCommandWrapper scw;

    public AbstractPage(WebDriver driver) {
        this._driver = driver;
        this.scw = new SeleniumCommandWrapper(driver);
    }
}
