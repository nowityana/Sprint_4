package tests;

import org.junit.Assert;
import org.junit.Test;
import pageobject.MainPage;

import static pageobject.Constants.YANDEX_MAIN_PAGE_URL;

public class CheckClickLogoYandexTest extends BaseUITest {

    @Test
    public void checkLogoYandex() {
        MainPage mainPage = new MainPage(driver);

        mainPage.openMainPage();
        mainPage.clickCookie();

        mainPage.clickLogoYandex();
        Assert.assertEquals(YANDEX_MAIN_PAGE_URL, driver.getCurrentUrl());
    }
}