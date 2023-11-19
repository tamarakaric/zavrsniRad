import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import static org.junit.Assert.assertEquals;


public class LoginTest extends BaseTest{

    pages.LoginPage loginPageObject = new pages.LoginPage(driver);

    @Before
    public void openApp() {
        driver.get("https://www.saucedemo.com/");
    }
    @Test
    public void loginWithValidUsernameAndValidPassword() {
        loginPageObject.successfulLogin();
        String expectedURL = "https://www.saucedemo.com/inventory.html";
        String actualURL = driver.getCurrentUrl();
        assertEquals("User isn't successfully logged in!", expectedURL, actualURL);
    }
    @Test
    public void loginWithInvalidUsernameAndValidPassword() {
        loginPageObject.fillRandomUsername(randomUsername());
        loginPageObject.fillValidPassword();
        loginPageObject.clickOnTheSubmitButton();
        String invalidUsernameOrPasswordError = "Epic sadface: Username and password do not match any user in this service";
        Assert.assertTrue("Home page loaded", invalidUsernameOrPasswordError.equals(loginPageObject.homePageNotLoaded()));
    }
    @Test
    public void loginWithValidUsernameAndInvalidPassword() {
        loginPageObject.fillValidUsername();
        loginPageObject.fillRandomPassword(randomPassword());
        loginPageObject.clickOnTheSubmitButton();
        String invalidUsernameOrPasswordError = "Epic sadface: Username and password do not match any user in this service";
        Assert.assertTrue("Home page loaded", invalidUsernameOrPasswordError.equals(loginPageObject.homePageNotLoaded()));
    }
    @Test
    public void loginWithInvalidUsernameAndInvalidPassword() {
        loginPageObject.fillRandomUsername(randomUsername());
        loginPageObject.fillRandomPassword(randomPassword());
        loginPageObject.clickOnTheSubmitButton();
        String invalidUsernameOrPasswordError = "Epic sadface: Username and password do not match any user in this service";
        Assert.assertTrue("Home page loaded", invalidUsernameOrPasswordError.equals(loginPageObject.homePageNotLoaded()));
    }
    @Test
    public void loginWithValidUsernameAndEmptyPassword() {
        loginPageObject.fillValidUsername();
        loginPageObject.clickOnTheSubmitButton();
        String invalidUsernameOrPasswordError = "Epic sadface: Password is required";
        Assert.assertTrue("Home page loaded", invalidUsernameOrPasswordError.equals(loginPageObject.homePageNotLoaded()));
    }
}