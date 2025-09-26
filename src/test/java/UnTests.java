import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import parents.BaseTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class UnTests extends BaseTest {

    @Test
    public void checkValidUsName() {
        loginPage.open();
        loginPage.loginThruZip("standard_user", "secret_sauce");
        boolean isPresent = productsPage.isTitlePresent();
        assertTrue(isPresent);
    }

    @DataProvider()
    public Object[][] loginData() {
        return new Object[][]{
                {"locked_out_user", "secret_sauce", "Epic sadface: Sorry, this user has been locked out."},
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {"standard_user", "", "Epic sadface: Password is required"}
        };
    }

    @Test
    public void checkIncorrectLogin(String user, String password, String errorMsg) {
        loginPage.open();
        loginPage.loginThruZip(user, password);
        assertEquals(loginPage.checkErrorMsg(), errorMsg);
    }
}
