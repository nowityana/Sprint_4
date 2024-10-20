package tests.order;

import org.junit.Assert;
import org.junit.Test;
import pageobject.MainPage;
import pageobject.OrderPage;
import tests.BaseUITest;

public class OrderClickByMiddleButtonTest extends BaseUITest {

    @Test
    public void fillOrder_MiddleButton() {
        MainPage mainPage = new MainPage(driver);

        mainPage.openMainPage();
        mainPage.clickCookie();
        mainPage.clickOrderMiddleButton();

        OrderPage orderPage = new OrderPage(driver);

        boolean isDisplayedButtonNext = orderPage.isDisplayedButtonNext();
        Assert.assertTrue(isDisplayedButtonNext);
    }
}