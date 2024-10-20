package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static pageobject.Constants.*;

public class MainPage {
    protected WebDriver driver;

    // локатор кнопки куки "да все привыкли"
    private By cookieButton = By.xpath(".//button[contains(@class, 'App_CookieButton')]");
    // локатор верхней кнопки "Заказать"
    private By  orderHeadButton = By.xpath(".//div[contains(@class, 'Header_Nav')]/button[contains(text(),'Заказать')]");
    // локатор средней кнопки кнопки "Заказать"
    private By  orderMiddleButton = By.xpath(".//button[contains(@class, 'Button_Middle') and text()='Заказать']");
    // локатор кнопки "Статус заказа"
    private By statusOrderButton = By.xpath(".//button[contains(@class, 'Header_Link')]");
    // локатор поля ввода номера заказа
    private By orderNumberInput = By.xpath(".//input[@type = 'text']");
    // локатор кнопки "Go!"
    private By goButton = By.xpath(".//button[contains(@class, 'Header_Button') and text()='Go!']");
    // локатор лого "Самокат"
    private By logoScooter = By.xpath(".//a[contains(@class, 'Header_LogoScooter')]/img");
    // локатор лого "Яндекс"
    private By logoYandex = By.xpath(".//a[contains(@class, 'Header_LogoYandex')]/img");

    // конструктор
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    // открытие главной страницы
    public MainPage openMainPage() {
        driver.get(MAIN_PAGE_URL);
        return this;
    }

    // открытие страницы заказа
    public MainPage openOrderPage() {
        driver.get(ORDER_PAGE_URL);
        return this;
    }

    // клик по кнопке куки
    public void clickCookie() {
        driver.findElement(cookieButton).click();
    }

    // клик по вопросу
    public void clickFAQQuestion(String questionMessage) {
        String questionLocator = String.format(FAQ_QUESTION_PATTERN, questionMessage);
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(questionLocator)));

        WebElement questionElement = driver.findElement(By.xpath(questionLocator));
        scrollToElement(questionElement);
        questionElement.click();
    }

    // проверка ответа на вопрос
    public boolean isDisplayedAnswer(String answerMessage) {
        String answerLocator = String.format(FAQ_ANSWER_PATTERN, answerMessage);
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(answerLocator)));
        return driver.findElement(By.xpath(answerLocator)).isDisplayed();
    }

    // клик по верхней кнопке заказать
    public void clickOrderHeadButton() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(orderHeadButton));
        driver.findElement(orderHeadButton).click();
    }

    //клик по средней кнопке заказать
    public void clickOrderMiddleButton() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(orderMiddleButton));

        WebElement questionElement = driver.findElement(orderMiddleButton);
        scrollToElement(questionElement);
        questionElement.click();
    }

    // скролл до элемента
    private void scrollToElement(WebElement element) {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    // клик по кнопке статус заказа
    public void clickStatusOrderButton() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(statusOrderButton));
        driver.findElement(statusOrderButton).click();
    }

    // ввод номера в поле статус заказа
    public void setOrderNumber(String orderNumberValue) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(orderNumberInput));

        WebElement orderNumberWebElement = driver.findElement(orderNumberInput);
        orderNumberWebElement.clear();
        driver.findElement(orderNumberInput).sendKeys(orderNumberValue);
    }

    // клик по кнопке go
    public void clickGoButton() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(goButton));
        driver.findElement(goButton).click();
    }

    // клик по лого "Самокат"
    public void clickLogoScooter() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(logoScooter));
        driver.findElement(logoScooter).click();
    }

    // клик по лого "Яндекс"
    public void clickLogoYandex() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(logoYandex));
        driver.findElement(logoYandex).click();

        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
    }
}