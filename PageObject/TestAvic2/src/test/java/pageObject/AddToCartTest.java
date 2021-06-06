package pageObject;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AddToCartTest extends BaseTest{

    private static final String EXPECTED_AMOUNT_OF_PRODUCT_IN_CART = "1";

    @Test(priority = 4)
    public void checkAddToCart() {
        getHomePage().clickOnProductCatalogButton();//каталог товаров
        getHomePage().clickOnSmartHomeButton();//Умный Дом
        getSmartPage().moveToElement(getSmartPage().getScrollDown());// листаем скролл вниз
        getSmartPage().clickOnSmartKitchenButton();// Выбираем Smart-кухня
        getSmartPage().implicitWait(30);//wait for page loading
        getSmartPage().clickAddToCart();//add to cart Смарт Чашку
        getSmartPage().waitVisibilityOfElement(30,getSmartPage().getAddToCartPopup());//ждем пока не отобразится попап с товаром добавленным в корзину
        getSmartPage().clickOnContinueShoppingButton();//продолжить покупки
        assertEquals(getHomePage().getTextOfAmountProductsInCart(), EXPECTED_AMOUNT_OF_PRODUCT_IN_CART);//получили 1 которая в корзине (один продукт)
    }
}
