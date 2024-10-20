package tests;

import org.junit.Assert;
import org.junit.Test;
import pageobject.MainPage;

import static pageobject.Constants.MAIN_PAGE_URL;

public class CheckClickLogoScooterTest extends BaseUITest {

    @Test
    public void checkLogoScooter() {
        MainPage mainPage = new MainPage(driver);

        mainPage.openOrderPage();
        mainPage.clickCookie();
        mainPage.clickLogoScooter();
        Assert.assertEquals(MAIN_PAGE_URL, driver.getCurrentUrl());
    }
}