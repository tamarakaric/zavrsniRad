import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;

import java.time.Duration;
import java.util.ArrayList;

public class LinksInFooterTest extends BaseTest {
    JavascriptExecutor js=(JavascriptExecutor) driver;
    pages.ProductsPage productPageObject = new pages.ProductsPage(driver);
    pages.LoginPage logInPageObject = new pages.LoginPage(driver);

    @Before
    public void openApp() {
        driver.get("https://www.saucedemo.com/");
        logInPageObject.successfulLogin();
    }

    @Test
    public void TwitterLink() {
        js.executeScript("window.scrollBy(0,10000)","");
        driver.findElement(productPageObject.twitterLink).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(newTab.get(1));
        String expectedURL="https://twitter.com/saucelabs";
        String actualURL=driver.getCurrentUrl();
        Assert.assertTrue("Twitter page not loaded",expectedURL.equals(actualURL) );
        driver.close();
        driver.switchTo().window(newTab.get(0));
        String expURL="https://www.saucedemo.com/inventory.html";
        String actURL=driver.getCurrentUrl();
        Assert.assertTrue("Home page was not reloaded", expURL.equals(actURL));
    }

    @Test
    public void FacebookLink() {
        js.executeScript("window.scrollBy(0,10000)","");
        driver.findElement(productPageObject.facebookLink).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(newTab.get(1));
        String expectedURL="https://www.facebook.com/saucelabs";
        String actualURL=driver.getCurrentUrl();
        Assert.assertTrue("Facebook page not loaded",expectedURL.equals(actualURL) );
        driver.close();
        driver.switchTo().window(newTab.get(0));
        String expURL="https://www.saucedemo.com/inventory.html";
        String actURL=driver.getCurrentUrl();
        Assert.assertTrue("Home page was not reloaded", expURL.equals(actURL));
    }
    @Test
    public void linkedInLink() {
        js.executeScript("window.scrollBy(0,10000)","");
        driver.findElement(productPageObject.linkedInLink).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(newTab.get(1));
        String expectedURL="https://www.linkedin.com/company/sauce-labs/";
        String actualURL=driver.getCurrentUrl();
        Assert.assertTrue("LinkedIn page not loaded",expectedURL.equals(actualURL) );
        driver.close();
        driver.switchTo().window(newTab.get(0));
        String expURL="https://www.saucedemo.com/inventory.html";
        String actURL=driver.getCurrentUrl();
        Assert.assertTrue("Home page was not reloaded", expURL.equals(actURL));
    }
}
