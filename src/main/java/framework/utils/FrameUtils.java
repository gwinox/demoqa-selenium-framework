package framework.utils;

import framework.browser.Browser;
import org.openqa.selenium.By;

public class FrameUtils {

    public static void switchToFrame(By locator) {
        LoggerUtil.info("Switch to frame: {}", locator);
        Browser.getDriver().switchTo().frame(Browser.getDriver().findElement(locator));
    }

    public static void switchToFrame(By locator, String frameName) {
        LoggerUtil.info("Switch to {} frame", frameName);
        Browser.getDriver().switchTo().frame(Browser.getDriver().findElement(locator));
    }

    public static void switchToDefaultContent() {
        LoggerUtil.info("Switch to default content");
        Browser.getDriver().switchTo().defaultContent();
    }
}