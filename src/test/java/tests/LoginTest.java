package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tests.parent.BaseTest;
import user.User;
import utils.PropertyReader;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static user.UserFactory.*;

public class LoginTest extends BaseTest {

    @Test
    public void checkValidUsName() {
        loginPage.open();
        loginPage.loginThruZip(withAdminPermission());
        boolean isPresent = productsPage.isTitlePresent();
        assertTrue(isPresent);
    }

    @DataProvider()
    public Object[][] loginData() {
        String user = PropertyReader.getProperty("sandbox.user");
        String password = PropertyReader.getProperty("sandbox.password");
        return new Object[][]{
                {"locked_out_user", password, "Epic sadface: Sorry, this user has been locked out."},
                {"", password, "Epic sadface: Username is required"},
                {user, "", "Epic sadface: Password is required"}
        };
    }

    @Test(dataProvider = "loginData")
    public void checkIncorrectLogin(String user, String password, String errorMsg) {
        User testUser = new User(user, password);
        loginPage.open();
        loginPage.loginThruZip(testUser);
        assertEquals(loginPage.checkErrorMsg(), errorMsg);
    }
}
