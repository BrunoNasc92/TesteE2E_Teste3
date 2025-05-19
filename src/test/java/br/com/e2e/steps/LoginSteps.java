package br.com.e2e.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.*;
import org.junit.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import br.com.e2e.pages.LoginPage;
import br.com.e2e.pages.ProductsPage;

public class LoginSteps {
    WebDriver driver;
    LoginPage loginPage;
    ProductsPage productsPage;

    @Before
    public void iniciar() {
    WebDriverManager.chromedriver().setup(); // substitui o System.setProperty
    driver = new ChromeDriver();
    driver.manage().window().maximize();
}

    @Dado("que o usuário está na página de login do SauceDemo")
    public void acessarLogin() {
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
    }

    @Quando("ele insere o usuário {string} e senha {string}")
    public void preencherCredenciais(String usuario, String senha) {
        loginPage.enterUsername(usuario);
        loginPage.enterPassword(senha);
    }

    @Quando("clica no botão de login")
    public void clicarLogin() {
        loginPage.clickLogin();
        productsPage = new ProductsPage(driver);
    }

    @Então("ele é redirecionado para a página de produtos")
    public void verificarPaginaProdutos() {
        Assert.assertTrue(productsPage.isOnProductsPage());
    }

    @After
    public void finalizar() {
        if (driver != null) {
            driver.quit();
        }
    }
}
