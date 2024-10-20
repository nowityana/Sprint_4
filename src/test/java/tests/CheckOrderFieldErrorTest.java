package tests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pageobject.MainPage;
import pageobject.OrderPage;

import static pageobject.Constants.*;

@RunWith(Parameterized.class)
public class CheckOrderFieldErrorTest extends BaseUITest {

    private final String errorPattern;
    private final String errorText;


    public CheckOrderFieldErrorTest (String errorPattern, String errorText) {
        this.errorPattern = errorPattern;
        this.errorText = errorText;
    }

    @Parameterized.Parameters
    public static Object[][] fields() {
        return new Object[][]{
                { ORDER_ERROR_PATTERN, ORDER_NAME_ERROR },
                { ORDER_ERROR_PATTERN, ORDER_SURNAME_ERROR },
                { ORDER_ERROR_SUBWAY_PATTERN, ORDER_SUBWAY_ERROR },
                { ORDER_ERROR_PATTERN, ORDER_TELEPHONE_NUMBER_ERROR },
        };
    }

    @Test
    public void fillOrder() {
        MainPage mainPage = new MainPage(driver);

        mainPage.openOrderPage();
        mainPage.clickCookie();

        OrderPage orderPage = new OrderPage(driver);

        orderPage.clickNextButton();

        boolean isDisplayedOrderNameError = orderPage.isDisplayedOrderFieldError(errorPattern, errorText);
        Assert.assertTrue(isDisplayedOrderNameError);
    }
}