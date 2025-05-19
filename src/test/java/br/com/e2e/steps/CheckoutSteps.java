package br.com.e2e.steps;

import br.com.e2e.pages.*;
import io.cucumber.java.pt.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckoutSteps {
    WebDriver driver;
    LoginPage loginPage;
    ProductsPage productsPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    CheckoutCompletePage completePage;

    @Dado("que o usuário está logado no SauceDemo")
    public void usuarioLogado() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();
    }

    @Quando("ele adiciona um produto ao carrinho")
    public void adicionarProduto() {
        productsPage = new ProductsPage(driver);
        productsPage.addFirstProductToCart();
    }

    @Quando("acessa o carrinho de compras")
    public void acessarCarrinho() {
        productsPage.goToCart();
        cartPage = new CartPage(driver);
    }

    @Quando("clica em {string}")
    public void clicarCheckout(String botao) {
        cartPage.clickCheckout();
    }

    @Quando("preenche o formulário com nome {string}, sobrenome {string} e CEP {string}")
    public void preencherFormulario(String nome, String sobrenome, String cep) {
        checkoutPage = new CheckoutPage(driver);
        checkoutPage.fillForm(nome, sobrenome, cep);
        checkoutPage.continueCheckout();
    }

    @Quando("finaliza a compra")
    public void finalizarCompra() {
        checkoutPage.finishCheckout();
        completePage = new CheckoutCompletePage(driver);
    }

    @Então("ele deve ver a mensagem {string}")
    public void verificarMensagem(String mensagemEsperada) {
        Assert.assertEquals(mensagemEsperada, completePage.getSuccessMessage());
        driver.quit();
    }
}
