package tests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pageobject.MainPage;

import static pageobject.Constants.*;

@RunWith(Parameterized.class)
public class CheckAnswerTest extends BaseUITest {

    private final String question;
    private final String answer;

    public CheckAnswerTest (String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    @Parameterized.Parameters
    public static Object[][] questions() {
        return new Object[][]{
                { QUESTION_1, ANSWER_1 },
                { QUESTION_2, ANSWER_2 },
                { QUESTION_3, ANSWER_3 },
                { QUESTION_4, ANSWER_4 },
                { QUESTION_5, ANSWER_5 },
                { QUESTION_6, ANSWER_6 },
                { QUESTION_7, ANSWER_7 },
                { QUESTION_8, ANSWER_8 },
        };
    }

    @Test
    public void checkAnswer() {
        MainPage mainPage = new MainPage(driver);

        mainPage.openMainPage();
        mainPage.clickCookie();
        mainPage.clickFAQQuestion(question);

        boolean isDisplayedAnswer = mainPage.isDisplayedAnswer(answer);
        Assert.assertTrue(isDisplayedAnswer);
    }
}