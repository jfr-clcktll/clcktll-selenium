package selenium;

import applications.way2automate.SauceLabsApplication;
import applications.way2automate.models.Credentials;
import org.testng.annotations.Test;

public class SauceLabsTest {

    @Test
    public void componentTest() throws InterruptedException {

        SauceLabsApplication slApp = new SauceLabsApplication(_driver);
        slApp.loginPage.login(new Credentials("standard_user","secret_sauce", "https//www.saucedemo.com/"));
        slApp.productPage.addItemToCart("");
    }
}
