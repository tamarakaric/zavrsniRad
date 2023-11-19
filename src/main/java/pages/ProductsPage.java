package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {
    //lokatori
    public WebDriver driver;
    public By addToCartButton = By.id("add-to-cart-sauce-labs-backpack");
    public By shoppingCartContainer = By.id("shopping_cart_container");
    public By twitterLink = By.xpath("//a[@href='https://twitter.com/saucelabs']");
    public By facebookLink = By.xpath("//a[@href='https://www.facebook.com/saucelabs']");
    public By linkedInLink = By.xpath("//a[@href='https://www.linkedin.com/company/sauce-labs/']");
    public By removedCartItem = By.xpath("    //*[@id=\"cart_contents_container\"]/div/div[1]/div[3]");

    //*[@id="cart_contents_container"]/div/div[1]/div[3]
    public By removeButton = By.id("remove-sauce-labs-backpack");

    //metode
    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }
    public void addProductToCart() {
        driver.findElement(addToCartButton).click();
    }
    public void goToShoppingCart() {
        driver.findElement(shoppingCartContainer).click();
    }
    public void removeProductFromCart() {
        driver.findElement(removeButton).click();
    }
}