package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutYourInformationPage {
    public WebDriver driver;

    public By firstNameInputField = By.id("first-name");
    public By lastNameInputField = By.id("last-name");
    public By postalCodeInputField = By.id("postal-code");
    public By continueButton = By.id("continue");

    public CheckoutYourInformationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillFirstNameInputField(String randomFirstName) {
        driver.findElement(firstNameInputField).sendKeys(randomFirstName);
    }
    public void fillLastNameInputField(String randomLastName) {
        driver.findElement(lastNameInputField).sendKeys(randomLastName);
    }
    public void fillPostalCodeInputField(String randomPostalCode) {
        driver.findElement(postalCodeInputField).sendKeys(randomPostalCode);
    }
    public void goToCheckoutOverviewPage() {
        driver.findElement(continueButton).click();
    }
}
