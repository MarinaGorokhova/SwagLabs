package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver browser;

    public LoginPage(WebDriver browser) {
        this.browser = browser;
    }

    private static final By INPUT_UN = By.xpath("//*[@placeholder='Username']");
    private static final By INPUT_PH = By.xpath("//*[@placeholder='Password']");
    private static final By CONTINUE_BTN = By.cssSelector("*[name='login-button']");

    public void open(){
        browser.get("https://www.saucedemo.com");
    }

    public void loginThruZip(String zipCode){
        browser.findElement(INPUT_UN).sendKeys(zipCode);
        browser.findElement(INPUT_PH).sendKeys("secret_sauce");
        browser.findElement(CONTINUE_BTN).click();
    }
}

