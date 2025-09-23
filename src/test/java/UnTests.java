import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class UnTests extends BaseTest{

    @Test
    public void checkValidUsName() {
        loginPage.open();
        loginPage.loginThruZip("standard_user");
    }

    @Test
    public void checkInvalidUsName() {
        loginPage.open();
        loginPage.loginThruZip("locked_out_user");
        String errorMsg = browser.findElement(By.cssSelector("*[data-test='error']")).getText();
        assertEquals(errorMsg, "Epic sadface: Sorry, this user has been locked out.");
    }
}
