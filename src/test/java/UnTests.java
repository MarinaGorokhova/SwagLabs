import org.testng.annotations.Test;
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

    @Test
    public void checkInvalidUsName() {
        loginPage.open();
        loginPage.loginThruZip("locked_out_user", "secret_sauce");
        String errorMsg = loginPage.checkErrorMsg();
        assertEquals(errorMsg, "Epic sadface: Sorry, this user has been locked out.");
    }

    @Test
    public void checkWithoutUsername() {
        loginPage.open();
        loginPage.loginThruZip("", "secret_sauce");
        String errorMsg = loginPage.checkErrorMsg();
        assertEquals(errorMsg, "Epic sadface: Username is required");
    }

    @Test
    public void checkWithoutPassword() {
        loginPage.open();
        loginPage.loginThruZip("standard_user", "");
        String errorMsg = loginPage.checkErrorMsg();
        assertEquals(errorMsg, "Epic sadface: Password is required");
    }
}
