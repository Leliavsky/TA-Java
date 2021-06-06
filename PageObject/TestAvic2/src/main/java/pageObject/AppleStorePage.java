package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AppleStorePage extends BasePage{

    @FindBy(xpath = ".//div[@class=\"brand-box__info\"]//a[text()=\"MacBook\"]")
    private WebElement macBookButton;

    public AppleStorePage(WebDriver driver) {
        super(driver);
    }
    public void clickOnMacBookButton() {
        macBookButton.click();
    }
}
