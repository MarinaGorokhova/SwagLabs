package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import user.User;

public class LoginPage extends BasePage {
    private static final By INPUT_UN = By.xpath("//*[@placeholder='Username']");
    private static final By INPUT_PH = By.xpath("//*[@placeholder='Password']");
    private static final By CONTINUE_BTN = By.cssSelector("*[name='login-button']");
    private static final By ERROR = By.xpath("//*[@data-test='error']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открытие браузера")
    public LoginPage open() {
        driver.get(BASE_URL + "/inventory.html");
        return this;
    }

    public void open(String url) {
        driver.get(BASE_URL + url);
    }

    @Step("Логинимся под кредами пользователя:логин= {user.email}, пароль= ******")
    public LoginPage loginThruZip(User user) {
        fillLoginField(user.getEmail());
        fillPasswordField(user.getPassword());
        clickSubmit();
        return this;
    }

    public LoginPage fillLoginField(String login) {
        driver.findElement(INPUT_UN).sendKeys(login);
        return this;
    }

    public LoginPage fillPasswordField(String password) {
        driver.findElement(INPUT_PH).sendKeys(password);
        return this;
    }

    public LoginPage clickSubmit() {
        driver.findElement(CONTINUE_BTN).click();
        return this;
    }

    public String checkErrorMsg() {
        return driver.findElement(ERROR).getText();
    }
}
