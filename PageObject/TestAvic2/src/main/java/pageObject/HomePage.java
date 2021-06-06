package pageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//input[@id='input_search']")
    private WebElement searchInput;

    @FindBy(xpath = "//span[@class='sidebar-item']")
    private WebElement productCatalogButton;

    @FindBy(xpath = "//li[contains(@class,'sidebar-item')]//a[contains(@href, 'ua/umnyij-dom')]")
    private WebElement smartHomeButton;

    @FindBy(xpath = "//div[contains(@class,'header-bottom__cart')]//div[contains(@class,'cart_count')]")
    private WebElement amountOfProduct;

    @FindBy(xpath = "//img[@class=\"sidebar-item-image lazyloaded\"]")
    private WebElement moveToAppleStore;

    @FindBy(xpath = ".//a[@href=\"https://avic.ua/macbook\"][@class=\"sidebar-item\"]")
    private WebElement macBookButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void searchByKeyword(final String keyword) {
        searchInput.sendKeys(keyword, Keys.ENTER);
    }

    public void clickOnProductCatalogButton() {
        productCatalogButton.click();
    }

    public void clickOnSmartHomeButton() {
        smartHomeButton.click();
    }

    public String getTextOfAmountProductsInCart() {
        return amountOfProduct.getText();
    }

    public WebElement setMoveToAppleStore(){
        return moveToAppleStore;
    }
    public void clickOnMacBookButton() {
        macBookButton.click();
    }
}
