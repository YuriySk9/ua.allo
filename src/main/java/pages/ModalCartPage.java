package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ModalCartPage extends BasePage {
    private By closeButton = By.xpath("//div[@class='v-modal__close-btn']");
    private By product = By.xpath("//span[@class='wrap']");

    public ModalCartPage(PageManager pages) {
        super(pages);
    }

    public void clickCloseButton() {
        WebElement close = element(closeButton);
        close.click();
        wait.until(ExpectedConditions.stalenessOf(close));
    }

    public ModalCartPage ensurePageLoaded() {
        waitVisibilityOfElement(product);
        return this;
    }
}
