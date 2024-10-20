package pageobject;

public class Constants {
    // URLs
    public static String MAIN_PAGE_URL = "https://qa-scooter.praktikum-services.ru/";
    public static String ORDER_PAGE_URL = MAIN_PAGE_URL + "order";
    public static String YANDEX_MAIN_PAGE_URL = "https://dzen.ru/?yredirect=true";

    // Question's pattern
    public static final String FAQ_QUESTION_PATTERN  = ".//div[contains(@id, 'accordion__heading') and contains(text(), '%s')]";

    // Questions
    public static final String QUESTION_1 = "Сколько это стоит? И как оплатить?";
    public static final String QUESTION_2 = "Хочу сразу несколько самокатов! Так можно?";
    public static final String QUESTION_3 = "Как рассчитывается время аренды?";
    public static final String QUESTION_4 = "Можно ли заказать самокат прямо на сегодня?";
    public static final String QUESTION_5 = "Можно ли продлить заказ или вернуть самокат раньше?";
    public static final String QUESTION_6 = "Вы привозите зарядку вместе с самокатом?";
    public static final String QUESTION_7 = "Можно ли отменить заказ?";
    public static final String QUESTION_8 = "Я жизу за МКАДом, привезёте?";

    // Answer's pattern
    public static final String FAQ_ANSWER_PATTERN  = ".//div[contains(@id, 'accordion__panel')]/p[contains(text(),'%s')]";

    // Answers
    public static final String ANSWER_1 = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    public static final String ANSWER_2 = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    public static final String ANSWER_3 = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    public static final String ANSWER_4 = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    public static final String ANSWER_5 = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    public static final String ANSWER_6 = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    public static final String ANSWER_7 = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    public static final String ANSWER_8 = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";

    // Order's subway station
    public static final String ORDER_STATION_PATTERN  = ".//div[contains(@class, 'Order_Text') and contains(text(), '%s')]";
    // Order's lease pattern
    public static final String ORDER_LEASE_PATTERN  = ".//div[contains(@class, 'Dropdown-option') and text()='%s']";
    // Order's scooter color pattern
    public static final String ORDER_COLOR_SCOOTER_PATTERN  = ".//label[contains(@class, 'Checkbox_Label') and contains(text(), '%s')]";

    // Order's field error pattern
    public static final String ORDER_ERROR_PATTERN  = ".//div[contains(@class, 'Input_ErrorMessage') and contains(text(), '%s')]";
    // Order's field error subway pattern
    public static final String ORDER_ERROR_SUBWAY_PATTERN  = ".//div[contains(@class, 'Order_MetroError') and contains(text(), '%s')]";

    // Order's field error
    public static final String ORDER_NAME_ERROR = "Введите корректное имя";
    public static final String ORDER_SURNAME_ERROR = "Введите корректную фамилию";
    public static final String ORDER_SUBWAY_ERROR = "Выберите станцию";
    public static final String ORDER_TELEPHONE_NUMBER_ERROR = "Введите корректный номер";
}