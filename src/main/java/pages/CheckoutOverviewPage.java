package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage {
    public WebDriver driver;

    public By finishButton = By.id("finish");

    public CheckoutOverviewPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToCheckoutCompletePage() {
        driver.findElement(finishButton).click();
    }
}
