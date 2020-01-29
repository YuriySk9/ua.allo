package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HeaderPage extends BasePage {
    private By searchField = By.id("search");
    private By myAccountLink = By.xpath("//span[@class='label']");
    private By logoutButton = By.xpath("//li[@class='account-link last']");
    private By findButton = By.xpath("//button[@class='button']");
    private By accountDropDown = By.xpath("//div[@id='customer-header-menu']//span[@class='arrow-icon']");
    private By productCountInCart = By.xpath("//span[@class='count']");

    public HeaderPage(PageManager pages) {
        super(pages);
    }

    public LoginPage clickSignInLink() {
        element(myAccountLink).click();
        return pages.loginPage;
    }

    public boolean isUserLoggedIn() {
        return isElementPresent(accountDropDown);
    }

    public String getUserName() {
        return element(myAccountLink).getText();
    }


    public void clickLogoutButton() {
        WebElement loggedInAccount = element(accountDropDown);
        Actions actions = new Actions(driver);
        actions.moveToElement(element(myAccountLink)).moveToElement(element(logoutButton)).click().perform();
        wait.until(ExpectedConditions.stalenessOf(loggedInAccount));
    }

    public HeaderPage setSearchField(String product) {
        type(searchField, product);
        return this;
    }

    public ProductListPage clickFindButton() {
        WebElement find = element(findButton);
        find.click();
        wait.until(ExpectedConditions.stalenessOf(find));
        return pages.productListPage;
    }

    public int productCountInCart() {
        String count = element(productCountInCart).getText();
        return Integer.parseInt(count);
    }

    public HeaderPage ensurePageLoaded() {
        waitVisibilityOfElement(productCountInCart);
        return this;
    }
}
