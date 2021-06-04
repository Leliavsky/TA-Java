package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.openqa.selenium.By.xpath;

public class SearchResult extends BasePage {

    private static final String SEARCH_PRODUCT_RESULT_LIST = "//div[@class='prod-cart__descr']";

    public SearchResult(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getSearchResultsList() {
        return driver.findElements(xpath(SEARCH_PRODUCT_RESULT_LIST));
    }

    public int getSearchResultInt(){
        return getSearchResultsList().size();
    }
}
