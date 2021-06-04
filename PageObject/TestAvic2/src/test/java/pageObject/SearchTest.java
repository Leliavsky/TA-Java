package pageObject;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SearchTest extends BaseTest {
    private String SEARCH_KEYWORD = "Samsung";
    private String SEARCH_KEYWORD1 = "AirPods";

    private String EXPECTED_SEARCH_QUERY = "query=Samsung";

    @Test(priority = 1)
    public void checkThatUrlContainsSearchWord() {
        getHomePage().searchByKeyword(SEARCH_KEYWORD);
        assertTrue(getDriver().getCurrentUrl().contains(EXPECTED_SEARCH_QUERY));
    }
    @Test(priority = 2)
    public void checkElementsAmountOnSearchPage() {
        getHomePage().searchByKeyword(SEARCH_KEYWORD1);//вводим в поиск AirPods
        getSmartPage().implicitWait(30);//неявное ожидание 30 сек
        assertEquals(getSearchResult().getSearchResultInt(), 12);//сравнили количество элементов актуальное с тем которое ожидаем
    }

    @Test(priority = 3)
    public void checkThatSearchResultsContainsSearchWord() {
        getHomePage().searchByKeyword(SEARCH_KEYWORD);//вводим в поиск Samsung
        for (WebElement webElement : getSearchResult().getSearchResultsList()) { //прошлись циклом и проверили что каждый элемент листа содержит текс Samsung
            assertTrue(webElement.getText().contains(SEARCH_KEYWORD));
        }
    }
}
