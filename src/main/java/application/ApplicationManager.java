package application;

import application.helpers.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

import java.io.File;
import java.sql.DriverManager;

public class ApplicationManager {
    private WebDriver driver;

    private UserHelper userHelper;
    private SearchHelper searchHelper;
    private ProductListHelper productListHelper;
    private CartHelper cartHelper;
    private ProductCatalogHelper productCatalogHelper;
    private PopUpsHelper popUpsHelper;
    private FilterHelper filterHelper;

    public ApplicationManager(String browser) {
        if (browser.equals(BrowserType.CHROME)) {
            System.setProperty("webdriver.chrome.driver",
                    new File(DriverManager.class.getResource("/chromedriver.exe").getFile()).getPath());
            driver = new ChromeDriver();
        } else if (browser.equals(BrowserType.FIREFOX)) {
            System.setProperty("webdriver.gecko.driver",
                    new File(DriverManager.class.getResource("/geckodriver.exe").getFile()).getPath());
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.get("https://allo.ua/");

        userHelper = new UserHelper(this);
        searchHelper = new SearchHelper(this);
        productListHelper = new ProductListHelper(this);
        cartHelper = new CartHelper(this);
        productCatalogHelper = new ProductCatalogHelper(this);
        popUpsHelper = new PopUpsHelper(this);
        filterHelper = new FilterHelper(this);
    }

    public WebDriver getWebDriver() {
        return driver;
    }

    public PopUpsHelper getPopUpsHelper() {
        return popUpsHelper;
    }

    public UserHelper getUserHelper() {
        return userHelper;
    }

    public FilterHelper getFilterHelper() {
        return filterHelper;
    }

    public ProductListHelper getProductListHelper() {
        return productListHelper;
    }

    public SearchHelper getSearchHelper() {
        return searchHelper;
    }

    public CartHelper getCartHelper() {
        return cartHelper;
    }

    public ProductCatalogHelper getProductCatalogHelper() {
        return productCatalogHelper;
    }

    public void stop() {
        if (driver != null) {
            driver.quit();
        }
    }
}
