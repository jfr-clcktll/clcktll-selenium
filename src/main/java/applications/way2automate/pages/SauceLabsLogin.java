package applications.way2automate.pages;

import applications.way2automate.models.Credentials;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class SauceLabsLogin extends AbstractPage{

    public SauceLabsLogin(WebDriver driver) {
        super(driver);
    }

    private By username = By.id("user-name");
    private By password = By.id("password");
    private By loginBtn = By.id("login-button");

    public void login(Credentials credential){

        scw.navigate(credential.url);
        scw.sendKeys(username, credential.username);
        scw.sendKeys(password, credential.password);
        scw.click(loginBtn);

    }
}
