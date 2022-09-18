package applications.way2automate.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryItem extends AbstractComponent {

    public InventoryItem(WebDriver driver) {
        super(driver);

    }

    @Override
    public By scopedLocator() {
        return By.xpath("//div[text()='Sauce Labs Backpack']/ancestor::div[@class='inventory_item']");
    }

    private By addToCart = By.xpath(".//button[text()='Add to cart']");

    public void addItemToCart() {
        click(addToCart);
    }
}
