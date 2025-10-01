package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage{
    private static final By PRODUCTS_NAME_LOCATOR = By.cssSelector(".inventory_item_name");
    private static final By CART_ITEMS_LOCATOR = By.className("cart_item");
    private static final By ITEM_NAME_LOCATOR = By.className("inventory_item_name");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public ArrayList<String> getProductsName() {
        List<WebElement> allProductsNames = driver.findElements(PRODUCTS_NAME_LOCATOR);
        ArrayList<String> names = new ArrayList<>();
        for (WebElement product : allProductsNames) {
            names.add(product.getText());
        }
        return names;
    }

    public void removeFromCart(String productName) {
        List<WebElement> cartItems = driver.findElements(CART_ITEMS_LOCATOR);
        for (WebElement item : cartItems) {
           String name = item.findElement(ITEM_NAME_LOCATOR ).getText();
            if (name.equals(productName)) {
                item.findElement(By.tagName("button")).click();
                break;
            }
        }
    }
}
