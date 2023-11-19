import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class RemoveProductTest extends BaseTest {
    pages.ProductsPage productPageObject = new pages.ProductsPage(driver);
    pages.LoginPage logInPageObject = new pages.LoginPage(driver);
    pages.YourCartPage yourCartPageObject = new pages.YourCartPage(driver);


    @Before
    public void openApp() {
        driver.get("https://www.saucedemo.com/");
        logInPageObject.successfulLogin();
    }
    @Test
    public void removeProductFromCart() {
        productPageObject.addProductToCart();
        productPageObject.goToShoppingCart();
        productPageObject.removeProductFromCart();
        Assert.assertFalse("Cart isn't empty!", driver.findElement(productPageObject.removedCartItem).isDisplayed());
    }
}
