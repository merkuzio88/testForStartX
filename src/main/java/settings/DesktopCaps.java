package settings;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeOptions;

import static settings.KitGeneralOptions.*;

public class DesktopCaps implements BeforeAllCallback {

    private static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        runInHeadlessMode(options, "--window-size=1920,1080");
        runWithHighlighter();
        runSelenideListener();
        return options
                .addArguments("--disable-notifications");
    }

    @Override
    public void beforeAll(ExtensionContext extensionContext) {
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 15000;
        Configuration.fastSetValue = true;
        Configuration.pageLoadStrategy = "normal";
        MutableCapabilities capabilities = new MutableCapabilities();
        if (WebDriverRunner.isChrome()) {
            ChromeOptions options = getChromeOptions();
            capabilities = capabilities.merge(options);
        }
        Configuration.browserCapabilities = capabilities;
    }
}
