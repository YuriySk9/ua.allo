package pages;

import org.openqa.selenium.WebDriver;

public class PageManager {
    public CartPage cartPage;
    public HeaderPage headerPage;
    public ProductListPage productListPage;
    public LoginPage loginPage;
    public ModalCartPage modalCartPage;
    public ProductCatalogPage productCatalogPage;
    public FilterPage filterPage;

    private WebDriver driver;

    public PageManager(WebDriver driver) {
        this.driver = driver;
        loginPage = new LoginPage(this);
        headerPage = new HeaderPage(this);
        productListPage = new ProductListPage(this);
        modalCartPage = new ModalCartPage(this);
        cartPage = new CartPage(this);
        productCatalogPage = new ProductCatalogPage(this);
        filterPage = new FilterPage(this);
    }

    public WebDriver getWebDriver() {
        return driver;
    }
}
