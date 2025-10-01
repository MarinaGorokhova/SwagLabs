import org.testng.annotations.Test;
import parents.BaseTest;

import static org.testng.Assert.*;

public class AddGoodsToCartTest extends BaseTest {
    @Test(description = "проверка товаров")
    public void checkGoodsInCart() throws InterruptedException {
        loginPage.open();
        loginPage.loginThruZip("standard_user", "secret_sauce");
        assertEquals(productsPage.getTitle(), "Products", "Название не соответствует ожидаемому");

        productsPage.addToCart(0);
        productsPage.addToCart(1);
        productsPage.addToCart(2);

        loginPage.open("/cart.html");
        assertTrue(cartPage.getProductsName().contains("Sauce Labs Backpack"));
        assertEquals(cartPage.getProductsName().size(),3);
        assertFalse(cartPage.getProductsName().isEmpty());
        cartPage.removeFromCart("Sauce Labs Backpack");
        assertFalse(cartPage.getProductsName().contains("Sauce Labs Backpack"));
        assertEquals(cartPage.getProductsName().size(), 2);
    }
}
