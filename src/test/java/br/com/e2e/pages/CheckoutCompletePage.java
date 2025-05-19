package br.com.e2e.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage {
    private WebDriver driver;

    public CheckoutCompletePage(WebDriver driver) {
        this.driver = driver;
    }

    private By confirmationMessage = By.className("complete-header");

    public String getSuccessMessage() {
        return driver.findElement(confirmationMessage).getText();
    }
}
