package settings;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Selenide.open;
import static settings.PropertiesReader.getProperties;

public class KitGeneralOptions {

    public static void runInHeadlessMode(ChromeOptions options, String resolution) {
        if (isHeadless()) {
            options.addArguments(resolution);
            Configuration.headless = true;
        }
    }

    public static void runSelenideListener() {
        if (isSelenideListener()) {
            SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        }
    }

    public static void runWithHighlighter() {
        if (isHighlighter()) {
            WebDriverRunner.addListener(new Highlighter());
        }
    }

    public static Boolean isHeadless() {
        return !"false".equals(getProperties("isHeadless"));
    }

    public static Boolean isHighlighter() {
        return !"false".equals(getProperties("isHighlighter"));
    }

    public static Boolean isSelenideListener() {
        return !"false".equals(getProperties("isSelenideListener"));
    }

    public static void setLocalStorage() {
        open("http://tl.af-ctf.ru/image/bank/bankCard.svg");
        Selenide.localStorage().setItem("cookies-is-show", "1");
        Selenide.localStorage().setItem("app-mobile-is-show", "1");
    }

    public static void clearData() {
        Selenide.clearBrowserLocalStorage();
        Selenide.clearBrowserCookies();
    }

}
