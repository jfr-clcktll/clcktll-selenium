package applications.way2automate.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends AbstractPage{


    public LoginPage(WebDriver driver){
        super(driver);
    }

    public By customerLoginBtn = By.xpath("/html/body/div[3]/div/div[2]/div/div[1]/div[1]/button");
    public By customerSelect = By.xpath("//*[@id=\"userSelect\"]");
    public By loginBtn = By.xpath("/html/body/div[3]/div/div[2]/div/form/button");

    public void login(String username){
        String loginURL = "https://www.way2automation.com/angularjs-protractor/banking/#login";
        scw.navigate(loginURL);
        scw.click(customerLoginBtn);
        scw.selectFromDropdown(customerSelect, username);
        scw.click(loginBtn);
    }

}
