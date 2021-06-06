package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MacBookPage extends BasePage {

    @FindBy(xpath = ".//div[contains(@ data-ecomm,\"236440\")]")
    private WebElement macBookFirst;

    @FindBy(xpath = ".//a[@ style=\"background-color: #c7c7c7\"]")
    private WebElement macBookSilver;

    @FindBy(xpath = ".//h1")
    private WebElement macBookName;

    public MacBookPage(WebDriver driver) {
        super(driver);
    }
    public void clickMacBookFirst() {
        macBookFirst.click();
    }
    public void clickMacBookSilver() {
        macBookSilver.click();
    }
    public String getTextOfMacBook() {
        return macBookName.getText();
    }
}
