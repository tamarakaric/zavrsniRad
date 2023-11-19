package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YourCartPage {
    public WebDriver driver;
    public By itemInCart = By.id("item_4_title_link");
    public By checkoutButton = By.id("checkout");

    public By successfulOrderMessage = By.xpath("//*[text()='Thank you for your order!']");
    public By cartBadge = By.xpath("//*[@class='shopping_cart_badge'][text()='1']");


    public String orderMessage(){
        return driver.findElement(successfulOrderMessage).getText();
    }
    public YourCartPage(WebDriver driver) {
        this.driver = driver;
    }
    public void goToCheckoutYourInformationPage() {
        driver.findElement(checkoutButton).click();
    }
}
