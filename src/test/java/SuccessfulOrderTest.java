import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.CheckoutYourInformationPage;
import pages.YourCartPage;

public class SuccessfulOrderTest extends BaseTest {
    pages.LoginPage logInPageObject = new pages.LoginPage(driver);
    pages.ProductsPage productsPageObject = new pages.ProductsPage(driver);
    pages.YourCartPage yourCartPageObject = new pages.YourCartPage(driver);
    pages.CheckoutYourInformationPage checkoutYourInformationPageObject = new pages.CheckoutYourInformationPage(driver);
    pages.CheckoutOverviewPage checkoutOverviewObject = new pages.CheckoutOverviewPage(driver);
    pages.CheckoutCompletePage checkoutCompleteObject = new pages.CheckoutCompletePage(driver);


    @Before
    public void openApp() {
        driver.get("https://www.saucedemo.com/");
        logInPageObject.successfulLogin();
    }
    @Test
    public void successfulOrderProduct() {
        productsPageObject.addProductToCart();
        productsPageObject.goToShoppingCart();
        yourCartPageObject.driver.findElement(By.id("item_4_title_link"));
        yourCartPageObject.goToCheckoutYourInformationPage();
        checkoutYourInformationPageObject.fillFirstNameInputField(randomFirstName());
        checkoutYourInformationPageObject.fillLastNameInputField(randomLastName());
        checkoutYourInformationPageObject.fillPostalCodeInputField(randomZipCode());
        checkoutYourInformationPageObject.goToCheckoutOverviewPage();
        checkoutOverviewObject.goToCheckoutCompletePage();
        checkoutCompleteObject.checkoutCompleteContainer();
        String expectedMessage = "Thank you for your order!";
        Assert.assertTrue("Thank you for your order!-message did not appear", expectedMessage.equals(yourCartPageObject.orderMessage()));
    }
}
