package framework.browser;

import framework.utils.LoggerUtil;
import org.openqa.selenium.*;

import java.util.ArrayList;
import java.util.List;

public class Browser {
    private static WebDriver instance;

    private Browser() {
    }

    public static WebDriver getDriver() {
        if (instance == null) {
            instance = BrowserFactory.createDriver();
        }
        return instance;
    }

    public static void quit() {
        LoggerUtil.info("Quit browser session");
        if (instance != null) {
            getDriver().quit();
            instance = null;
        }
    }

    public static void openUrl(String url) {
        LoggerUtil.info("Open url: {}", url);
        getDriver().get(url);
    }

    public static void clickWithJS(WebElement element, String elementName) {
        LoggerUtil.info("Click {} with JavaScript", elementName);
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", element);
    }

    public static void switchWindow(int tabIndex) {
        LoggerUtil.info("Switch to tab index: {}", tabIndex);
        List<String> handles = new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(handles.get(tabIndex));
    }

    public static void closeCurrentWindow() {
        LoggerUtil.info("Close current tab");
        getDriver().close();
    }
}