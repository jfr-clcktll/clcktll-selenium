package applications.way2automate.pages;

import applications.way2automate.components.InventoryItem;
import org.openqa.selenium.WebDriver;

public class SauceLabsProductPage extends AbstractPage{
    public SauceLabsProductPage(WebDriver driver) {
        super(driver);
    }

    public void addItemToCart(String itemName) {
        InventoryItem item = new InventoryItem(_driver);
        item.addItemToCart();
    }
}
