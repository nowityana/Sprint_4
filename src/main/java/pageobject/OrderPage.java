package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static pageobject.Constants.*;

public class OrderPage {
    protected WebDriver driver;

    // локатор поля Имя
    private By orderNameInput = By.xpath(".//input[contains(@class,'Input_Input') and contains(@placeholder,'* Имя')]");
    // локатор поля Фамилия
    private By orderSurnameInput = By.xpath(".//input[contains(@class,'Input_Input') and contains(@placeholder,'* Фамилия')]");
    // локатор поля Адрес
    private By orderAddressInput = By.xpath(".//input[contains(@class,'Input_Input') and contains(@placeholder,'* Адрес: куда привезти заказ')]");
    // локатор поля Метро
    private By orderSubwayInput = By.xpath(".//input[contains(@class,'select-search__input') and contains(@placeholder,'* Станция метро')]");
    // локатор поля Номер телефона
    private By orderTelephoneNumber = By.xpath(".//input[contains(@class,'Input_Input') and contains(@placeholder,'* Телефон: на него позвонит курьер')]");
    // локатор кнопки "Далее"
    private By nextButton = By.xpath(".//button[contains(@class, 'Button_Middle') and text()='Далее']");
    // локаторы даты доставки
    private By deliveryDateInput = By.xpath(".//input[contains(@placeholder, 'Когда привезти самокат')]");
    private By deliveryDateDataPicker = By.xpath(".//div[contains(@class, 'datepicker__day--selected')]");
    // локаторы срока аренды
    private By orderLease = By.xpath(".//div[contains(@class,'Dropdown-placeholder') and text()='* Срок аренды']");
    // локатор блока с выбором цветов самоката
    private By orderColorButton = By.xpath(".//div[contains(@class,'Order_Checkboxes')]");
    // локатор комментария
    private By orderCommentInput = By.xpath(".//input[contains(@placeholder, 'Комментарий для курьера')]");
    // локатор кнопки "Заказать" на второй странице заказа
    private By orderMiddleButton = By.xpath(".//button[contains(@class, 'Button_Middle') and text()='Заказать']");
    // локатор кнопки "Да"
    private By orderYesButton = By.xpath(".//button[contains(@class, 'Button_Middle') and text()='Да']");
    // локатор оформленного заказа (надпись "Заказ оформлен")
    private By orderComplete = By.xpath(".//div[contains(@class, 'Order_ModalHeader') and text()='Заказ оформлен']");
    // локатор страницы формирования заказа
    private By orderStart = By.xpath(".//div[contains(@class, 'Order_Header') and text()='Для кого самокат']");

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    // заполнение поля имя
    public void inputOrderName(String name) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(orderNameInput));
        driver.findElement(orderNameInput).sendKeys(name);
    }

    // заполнение поля фамилия
    public void inputOrderSurname(String surname) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(orderSurnameInput));
        driver.findElement(orderSurnameInput).sendKeys(surname);
    }

    // заполнение поля адресс
    public void inputOrderAddress(String address) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(orderAddressInput));
        driver.findElement(orderAddressInput).sendKeys(address);
    }

    // заполнение поля метро
    public void inputOrderSubway(String subway) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(orderSubwayInput));
        driver.findElement(orderSubwayInput).sendKeys(subway);

        String stationLocator = String.format(ORDER_STATION_PATTERN, subway);
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(stationLocator)));

        WebElement timeElement = driver.findElement(By.xpath(stationLocator));
        timeElement.click();
    }

    // заполнение поля телефон
    public void inputOrderTelephoneNumber(String telephoneNumber) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(orderTelephoneNumber));
        driver.findElement(orderTelephoneNumber).sendKeys(telephoneNumber);
    }

    // клик по кнопке Далее
    public void clickNextButton() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(nextButton));
        driver.findElement(nextButton).click();
    }

    // заполнение поля даты доставки
    public void selectDeliveryDate(String date){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(deliveryDateInput));
        driver.findElement(deliveryDateInput).sendKeys(date);
        driver.findElement(deliveryDateDataPicker).click();
    }

    // выбор срока аренды самоката
    public void selectOrderTime(String lease) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(orderLease));
        driver.findElement(orderLease).click();

        String leaseLocator = String.format(ORDER_LEASE_PATTERN, lease);
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(leaseLocator)));

        WebElement leaseElement = driver.findElement(By.xpath(leaseLocator));
        leaseElement.click();
    }

    // выбор цвета самоката
    public void selectColorButton(String color) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(orderColorButton));

        String colorLocator = String.format(ORDER_COLOR_SCOOTER_PATTERN, color);
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(colorLocator)));

        WebElement timeElement = driver.findElement(By.xpath(colorLocator));
        timeElement.click();
    }

    // заполнение поля комментария
    public void inputOrderComment(String comment) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(orderCommentInput));
        driver.findElement(orderCommentInput).sendKeys(comment);
    }

    // клик по кнопке заказать на второй странице заказа
    public void clickOrderMiddleButton() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(orderMiddleButton));
        driver.findElement(orderMiddleButton).click();
    }

    // клик по кнопке дв
    public void clickOrderYesButton() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(orderYesButton));
        driver.findElement(orderYesButton).click();
    }

    // поиск текста "Заказ оформлен"
    public boolean isDisplayedNumberOrder() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(orderComplete));
        return driver.findElement(orderComplete).isDisplayed();
    }

    // поиск текста "Для кого самокат"
    public boolean isDisplayedButtonNext() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(orderStart));
        return driver.findElement(orderStart).isDisplayed();
    }

    // проверка подсказки об ошибке в полях заказа
    public boolean isDisplayedOrderFieldError(String errorPattern, String errorText) {
        String orderFieldErrorLocator = String.format(errorPattern, errorText);
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(orderFieldErrorLocator)));
        return driver.findElement(By.xpath(orderFieldErrorLocator)).isDisplayed();
    }
}