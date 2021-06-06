package pageObject;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SearchTest extends BaseTest {
    private String SEARCH_KEYWORD = "Samsung";
    private String SEARCH_KEYWORD1 = "AirPods";

    private static final String EXPECTED_TEXT_SILVER_MACBOOK = "Ноутбук Apple MacBook Air 13 Silver Late 2020 (MGN93)";
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

    @Test(priority = 4)
    public void checkCoolerOfMacBookIsWork(){
        getHomePage().clickOnProductCatalogButton();//каталог товаров
        getHomePage().moveToElement(getHomePage().setMoveToAppleStore());//наводим курсор на Apple Store
        getAppleStore().clickOnMacBookButton();//кликаем на Макбук
        getMacBookPage().clickMacBookFirst();//выбираем Макбук первый
        getMacBookPage().clickMacBookSilver();//выбираем сильвер
        assertEquals(getMacBookPage().getTextOfMacBook(), EXPECTED_TEXT_SILVER_MACBOOK);
    }
}
