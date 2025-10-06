package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import tests.parent.BaseTest;
import user.UserFactory;

import static enums.DepartmentNaming.*;
import static org.testng.Assert.*;

@Epic("")
@Feature("")
@Story("")
public class AddGoodsToCartTest extends BaseTest {
    @Severity(SeverityLevel.NORMAL)
    @Owner("Горохова Марина marin-bojchenko@yandex.ru")
    @TmsLink("SwagLabs")
    @Issue("SwagLabs")
    @Step("Тестирование корзины: добавление, проверка и удаление товаров")
    @Test(description = "проверка товаров")
    public void checkGoodsInCart() {
        loginPage.open()
                .loginThruZip(UserFactory.withAdminPermission());
        assertEquals(productsPage.getTitle(), PRODUCTS.getDisplayName(), "Название не соответствует ожидаемому");

        productsPage.addToCart(0)
                .addToCart(1)
                .addToCart(2);

        loginPage.open("/cart.html");
        assertTrue(cartPage.getProductsName().contains("Sauce Labs Backpack"));
        assertEquals(cartPage.getProductsName().size(), 3);
        assertFalse(cartPage.getProductsName().isEmpty());
        cartPage.removeFromCart("Sauce Labs Backpack");
        assertFalse(cartPage.getProductsName().contains("Sauce Labs Backpack"));
        assertEquals(cartPage.getProductsName().size(), 2);
    }
}
