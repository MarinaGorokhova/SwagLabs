import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class UnTests extends BaseTest{

    @Test
    public void checkValidUsName() {
        loginPage.open();
        loginPage.loginThruZip("standard_user", "secret_sauce");
        boolean isPresent = browser.findElement(By.xpath("//*[text()='Products']")).isDisplayed();
        assertTrue(isPresent);
    }

    @Test
    public void checkInvalidUsName() {
        loginPage.open();
        loginPage.loginThruZip("locked_out_user", "secret_sauce");
        String errorMsg = browser.findElement(By.cssSelector("*[data-test='error']")).getText();
        assertEquals(errorMsg, "Epic sadface: Sorry, this user has been locked out.");
    }
}
