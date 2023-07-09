package guru.qa.state;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.*;

public abstract class BaseState {

    @BeforeEach
    public void init() {
        open("https://www.rollingmoto.ru/");
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = false;
        Configuration.pageLoadStrategy = "eager";
        closeBanner();
    }

    @AfterEach
    public void quite() {
        closeWebDriver();
    }

    /**
     * Закрытие баннеров
     */
    protected void closeBanner() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
    }
}
