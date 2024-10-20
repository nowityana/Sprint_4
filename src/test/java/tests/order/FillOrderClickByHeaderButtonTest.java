package tests.order;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pageobject.MainPage;
import pageobject.OrderPage;
import tests.BaseUITest;

@RunWith(Parameterized.class)
public class FillOrderClickByHeaderButtonTest extends BaseUITest {

    private final String name;
    private final String surname;
    private final String address;
    private final String subway;
    private final String telephoneNumber;
    private final String date;
    private final String time;
    private final String color;
    private final String comment;

    public FillOrderClickByHeaderButtonTest (String name, String surname, String address, String subway, String telephoneNumber, String date, String time, String color, String comment) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.subway = subway;
        this.telephoneNumber = telephoneNumber;
        this.date = date;
        this.time = time;
        this.color = color;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] fields() {
        return new Object[][]{
                { "Андрей", "Смирнов", "Дворцовая площадь, 2", "Черкизовская", "89000000000","25.10.24", "сутки", "чёрный жемчуг", "Комментарий первого теста."},
                { "Лена", "Синичкина", "Московская улица, 5", "Сокольники", "89010000000","30.10.24", "двое суток", "серая безысходность", "Комментарий второго теста."},
        };
    }

    @Test
    public void fillOrder_HeadButton() {
        MainPage mainPage = new MainPage(driver);

        mainPage.openMainPage();
        mainPage.clickCookie();
        mainPage.clickOrderHeadButton();

        OrderPage orderPage = new OrderPage(driver);

        orderPage.inputOrderName(name);
        orderPage.inputOrderSurname(surname);
        orderPage.inputOrderAddress(address);
        orderPage.inputOrderSubway(subway);
        orderPage.inputOrderTelephoneNumber(telephoneNumber);

        orderPage.clickNextButton();

        orderPage.selectDeliveryDate(date);
        orderPage.selectOrderTime(time);
        orderPage.selectColorButton(color);
        orderPage.inputOrderComment(comment);

        orderPage.clickOrderMiddleButton();
        orderPage.clickOrderYesButton();

        boolean isDisplayedNumberOrder = orderPage.isDisplayedNumberOrder();
        Assert.assertTrue(isDisplayedNumberOrder);
    }
}