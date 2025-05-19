package br.com.e2e.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
    private WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    private By firstNameField = By.id("first-name");
    private By lastNameField = By.id("last-name");
    private By postalCodeField = By.id("postal-code");
    private By continueButton = By.id("continue");
    private By finishButton = By.id("finish");

    public void fillForm(String nome, String sobrenome, String cep) {
        driver.findElement(firstNameField).sendKeys(nome);
        driver.findElement(lastNameField).sendKeys(sobrenome);
        driver.findElement(postalCodeField).sendKeys(cep);
    }

    public void continueCheckout() {
        driver.findElement(continueButton).click();
    }

    public void finishCheckout() {
        driver.findElement(finishButton).click();
    }
}
