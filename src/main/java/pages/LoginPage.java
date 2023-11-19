package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class LoginPage {

    public WebDriver driver;

    public String validUsername = "standard_user";
    public String validPassword = "secret_sauce";

    public By usernameInputField = By.id("user-name");
    public By passwordInputField = By.id("password");
    public By loginButton = By.id("login-button");
    public By errorMessageInvalidData = By.xpath("//h3[@data-test='error']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void successfulLogin() {
        driver.findElement(usernameInputField).sendKeys(validUsername);
        driver.findElement(passwordInputField).sendKeys(validPassword);
        driver.findElement(loginButton).click();
        driver.findElement(By.id("shopping_cart_container"));
    }

    public void fillRandomUsername(String randomUsername) {
        driver.findElement(usernameInputField).sendKeys(randomUsername);
    }
    public void fillRandomPassword(String randomPassword) {
        driver.findElement(passwordInputField).sendKeys(randomPassword);
    }
    public void fillValidUsername() {
        driver.findElement(usernameInputField).sendKeys(validUsername);
    }
    public void fillValidPassword() {
        driver.findElement(passwordInputField).sendKeys(validPassword);
    }
    public void clickOnTheSubmitButton() {
        driver.findElement(loginButton).click();
    }
    public String homePageNotLoaded()
    {
        return driver.findElement(errorMessageInvalidData).getText();
    }
}
