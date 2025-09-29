package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private static final By INPUT_UN = By.xpath("//*[@placeholder='Username']");
    private static final By INPUT_PH = By.xpath("//*[@placeholder='Password']");
    private static final By CONTINUE_BTN = By.cssSelector("*[name='login-button']");
    private static final By ERROR = By.xpath("//*[@data-test='error']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL + "/inventory.html");
    }

    public void open(String url) {
        driver.get(BASE_URL + url);
    }

    public void loginThruZip(String login, String password) {
        fillLoginField(login);
        fillPasswordField(password);
        clickSubmit();
    }

    public void fillLoginField(String login) {
        driver.findElement(INPUT_UN).sendKeys(login);
    }

    public void fillPasswordField(String password) {
        driver.findElement(INPUT_PH).sendKeys(password);
    }

    public void clickSubmit() {
        driver.findElement(CONTINUE_BTN).click();
    }

    public String checkErrorMsg() {
        return driver.findElement(ERROR).getText();
    }
}
