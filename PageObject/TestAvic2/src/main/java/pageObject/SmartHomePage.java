package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SmartHomePage extends BasePage {

    @FindBy(xpath = "//*[@id='filters']/aside/div/div[4]/div[2]/div/a")
    private WebElement scrollButton;

    @FindBy(xpath = ".//label[@for=\"fltr-type-smart-kukhnya\"]")
    private WebElement smartKitchenButton;

    @FindBy(xpath = "//a[@class='prod-cart__buy'][contains(@data-ecomm-cart,'Pink')]")
    private WebElement addToCartButton;

    @FindBy(id = "js_cart")
    private WebElement addToCartPopup;

    @FindBy(xpath = "//div[@class='btns-cart-holder']//a[contains(@class,'btn--orange')]")
    private WebElement continueShoppingButton;

    public SmartHomePage(WebDriver driver) {
        super(driver);
    }

    public void clickOnSmartKitchenButton() {
        smartKitchenButton.click();
    }
    public void clickAddToCart() {
        addToCartButton.click();
    }

    public void clickOnContinueShoppingButton() {
        continueShoppingButton.click();
    }

    public WebElement getAddToCartPopup() {
        return addToCartPopup;
    }
    public WebElement getScrollDown() {
        return scrollButton;
    }
}
