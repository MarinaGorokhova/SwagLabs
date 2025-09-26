import org.testng.annotations.Test;
import parents.BaseTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AddGoodsToCartTest extends BaseTest {
    @Test
    public void checkCorrectLogin() throws InterruptedException {
        loginPage.open();
        loginPage.loginThruZip("standard_user", "secret_sauce");
        assertTrue(productsPage.isTitlePresent());
        assertEquals(productsPage.getTitle(), "Products", "Название не соответствует ожидаемому");

        productsPage.addToCart(0);
        productsPage.addToCart(1);
        productsPage.addToCart(2);
    }
}
