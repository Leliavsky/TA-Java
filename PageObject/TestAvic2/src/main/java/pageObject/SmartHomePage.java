package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

public class SmartHomePage extends BasePage {
    private static final String SCROLL_BUTTON = "//*[@id='filters']/aside/div/div[4]/div[2]/div/a";
    private static final String SMART_KITCHEN_BUTTON = ".//label[@for=\"fltr-type-smart-kukhnya\"]";
    private static final String ADD_TO_CART_BUTTON = "//a[@class='prod-cart__buy'][contains(@data-ecomm-cart,'Pink')]";
    private static final String ADD_TO_CART_POPUP = "js_cart";
    private static final String CONTINUE_SHOPPING_BUTTON = "//div[@class='btns-cart-holder']//a[contains(@class,'btn--orange')]";
    public SmartHomePage(WebDriver driver) {
        super(driver);
    }
    public void clickScrollDownButton() {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(xpath(SCROLL_BUTTON))).perform(); // пролистываем скролл вниз
    }
    public void clickOnSmartKitchenButton() {
        driver.findElement(xpath(SMART_KITCHEN_BUTTON)).click();
    }
    public void clickAddToCart() {
        driver.findElement(xpath(ADD_TO_CART_BUTTON)).click();
    }

    public void clickOnContinueShoppingButton() {
        driver.findElement(xpath(CONTINUE_SHOPPING_BUTTON)).click();
    }

    public By getAddToCartPopup() {
        return id(ADD_TO_CART_POPUP);
    }
}
