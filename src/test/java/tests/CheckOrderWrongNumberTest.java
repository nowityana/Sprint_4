package tests;

import org.junit.Assert;
import org.junit.Test;
import pageobject.MainPage;
import pageobject.TrackPage;

public class CheckOrderWrongNumberTest extends BaseUITest {

    @Test
    public void checkOrderWrongNumber() {
        MainPage mainPage = new MainPage(driver);

        mainPage.openMainPage();
        mainPage.clickCookie();
        mainPage.clickStatusOrderButton();
        mainPage.setOrderNumber("13245890");
        mainPage.clickGoButton();

        TrackPage trackPage = new TrackPage(driver);

        boolean isDisplayedNotFoundOrderImg = trackPage.isDisplayedNotFoundOrderImg();
        Assert.assertTrue(isDisplayedNotFoundOrderImg);
    }
}