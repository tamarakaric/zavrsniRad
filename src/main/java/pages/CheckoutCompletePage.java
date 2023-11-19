package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage {
    public WebDriver driver;
    public By completeContainer = By.id("checkout_complete_container");

    public CheckoutCompletePage(WebDriver driver) {
        this.driver = driver;
    }

    public void checkoutCompleteContainer() {
        driver.findElement(completeContainer);
    }
}
