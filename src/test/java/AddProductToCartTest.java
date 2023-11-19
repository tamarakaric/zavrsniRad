import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class AddProductToCartTest extends BaseTest {
    pages.LoginPage logInPageObject = new pages.LoginPage(driver);
    pages.ProductsPage productPageObject = new pages.ProductsPage(driver);
    pages.YourCartPage yourCartPageObject = new pages.YourCartPage(driver);


    @Before
    public void openApp() {
        driver.get("https://www.saucedemo.com/");
        logInPageObject.successfulLogin();
    }
    @Test
    public void addingProductToCart() {
        productPageObject.addProductToCart();
        productPageObject.goToShoppingCart();
        yourCartPageObject.driver.findElement(By.id("item_4_title_link"));
        Assert.assertTrue("Cart is empty", yourCartPageObject.driver.findElement(By.id("item_4_title_link")).isDisplayed());
    }
}