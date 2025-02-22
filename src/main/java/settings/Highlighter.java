package settings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class Highlighter extends AbstractWebDriverEventListener {

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        highlight(element, "red");
    }

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        highlight(element, "red");
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        highlight(element, "red");
    }

    @Override
    public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        highlight(element, "red");
    }

    public void beforeGetText(WebElement element, WebDriver driver) {
        highlight(element, "red");
    }

    public void afterGetText(WebElement element, WebDriver driver, String text) {
        highlight(element, "red");
    }

    public static <T extends WebElement> T highlight(T element, final String color) {
        if (element != null && element.getAttribute("__selenideHighlighting") == null) {
            transform(element);
        }
        return element;
    }

    private static void transform(WebElement element) {
        executeJavaScript(
                "arguments[0].style.border='1px solid red'",
                element);
    }
}