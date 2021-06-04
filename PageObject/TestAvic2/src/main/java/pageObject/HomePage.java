package pageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.xpath;

public class HomePage extends BasePage {

    private static final String SEARCH_INPUT = "//input[@id='input_search']";
    private static final String PRODUCT_CATALOG_BUTTON = "//span[@class='sidebar-item']";
    private static final String SMART_HOME_BUTTON = "//li[contains(@class,'sidebar-item')]//a[contains(@href, 'ua/umnyij-dom')]";
    private static final String AMOUNT_OF_PRODUCTS_IN_CART = "//div[contains(@class,'header-bottom__cart')]//div[contains(@class,'cart_count')]";

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void searchByKeyword(final String keyword) {
        driver.findElement(xpath(SEARCH_INPUT)).sendKeys(keyword, Keys.ENTER);
    }

    public void clickOnProductCatalogButton() {
        driver.findElement(xpath(PRODUCT_CATALOG_BUTTON)).click();
    }

    public void clickOnSmartHomeButton() {
        driver.findElement(xpath(SMART_HOME_BUTTON)).click();
    }

    public String getTextOfAmountProductsInCart() {
        return driver.findElement(xpath(AMOUNT_OF_PRODUCTS_IN_CART)).getText();
    }
}
