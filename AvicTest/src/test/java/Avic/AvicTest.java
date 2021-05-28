package Avic;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.By.xpath;
import static org.openqa.selenium.Keys.ENTER;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import java.util.concurrent.TimeUnit;


public class AvicTest {
    private WebDriver driver;

    @BeforeTest
    public void profileSetUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/dimalelyavskij/IdeaProjects/AvicTest/src/main/resources/chromedriver");
    }

    @BeforeMethod
    public void testsSetUp() {
        driver = new ChromeDriver();//создаем экзаемпляр хром драйвера
        driver.manage().window().maximize();//открыли браузер на весь экран
        driver.get("https://avic.ua/");//открыли сайт
    }

    @Test(priority = 1)
    public void checkThatUrlContainsSearchWord() {
        driver.findElement(xpath("//input[@id='input_search']")).sendKeys("iPhone 12", Keys.ENTER);//вводим в поиск iPhone 12
        assertTrue(driver.getCurrentUrl().contains("query=iPhone+12"));//проверяем что урла содержит кверю
    }

    @Test(priority = 2)
    public void checkElementsAmountOnSearchPage() {
        driver.findElement(xpath("//input[@id='input_search']")).sendKeys("AirPods", ENTER);//вводим в поиск AirPods
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);//неявное ожидание 30 сек
        List<WebElement> elementsList = driver.findElements(xpath("//div[@class='prod-cart__descr']"));//собрали элементы поиска в лист
        int actualElementsSize = elementsList.size();//узнали количество элементов в листе
        assertEquals(actualElementsSize, 12);//сравнили количество элементов актуальное с тем которое ожидаем
    }

    @Test(priority = 3)
    public void checkThatSearchResultsContainsSearchWord() {
        driver.findElement(xpath("//input[@id='input_search']")).sendKeys("Samsung", ENTER);//вводим в поиск Samsung
        List<WebElement> elementList = driver.findElements(xpath("//div[@class='prod-cart__descr']"));//собрали элементы поиска в лист
        for (WebElement webElement : elementList) { //прошлись циклом и проверили что каждый элемент листа содержит текс Samsung
            assertTrue(webElement.getText().contains("Samsung"));
        }
    }

    @Test(priority = 4)
    public void checkAddToCart() {
        driver.findElement(xpath("//span[@class='sidebar-item']")).click();//каталог товаров
        driver.findElement(xpath("//li[contains(@class,'sidebar-item')]//a[contains(@href, 'ua/umnyij-dom')]")).click();//Умный Дом
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(xpath("//*[@id='filters']/aside/div/div[4]/div[2]/div/a"))).perform();
//        driver.findElement(xpath("//*[@class=\"js_filter-mob filter__mob-btn\"]")).click();//Кликаем на параметры
        driver.findElement(xpath(".//label[@for=\"fltr-type-smart-kukhnya\"]")).click();// Выбираем Smart-кухня
        new WebDriverWait(driver, 30).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));//wait for page loading
        driver.findElement(xpath("//a[@class='prod-cart__buy'][contains(@data-ecomm-cart,'Pink')]")).click();//add to cart Смарт Чашку
        WebDriverWait wait = new WebDriverWait(driver, 30);//ждем пока не отобразится попап с товаром добавленным в корзину
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("js_cart")));
        driver.findElement(xpath("//div[@class='btns-cart-holder']//a[contains(@class,'btn--orange')]")).click();//продолжить покупки
        String actualProductsCountInCart =
                driver.findElement(xpath("//div[contains(@class,'header-bottom__cart')]//div[contains(@class,'cart_count')]")).getText();//получили 1 которая в корзине (один продукт)
        assertEquals(actualProductsCountInCart, "1");
    }

    @AfterMethod
    public void tearDown() {
        driver.close();//закрытие драйвера
    }
}
