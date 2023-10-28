package settings;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static settings.KitGeneralOptions.clearData;
import static settings.KitGeneralOptions.setLocalStorage;

@SuppressWarnings({"SameParameterValue", "unused"})
public abstract class BrowserConfig {

    @AfterAll
    public static void tearDown() {
        WebDriverRunner.closeWebDriver();
    }

    @AfterEach
    @Step("Очистка cookies")
    public void clearBrowser() {
        clearData();
    }

    @BeforeEach
    @Step("Установка cookies")
    public void beforeEach() {
        setLocalStorage();
    }

}
