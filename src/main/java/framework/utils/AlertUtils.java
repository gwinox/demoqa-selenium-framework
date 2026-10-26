package framework.utils;

import framework.browser.Wait;
import org.openqa.selenium.Alert;
import org.openqa.selenium.TimeoutException;

public class AlertUtils {

    private AlertUtils() {
    }

    public static boolean isAlertPresent() {
        try {
            Wait.waitForAlertIsPresent();
            LoggerUtil.info("Alert is displayed");
            return true;
        } catch (TimeoutException e) {
            LoggerUtil.info("Alert isn't displayed");
            return false;
        }
    }

    public static void accept() {
        LoggerUtil.info("Accept alert");
        getAlert().accept();
    }

    public static void dismiss() {
        LoggerUtil.info("Dismiss alert");
        getAlert().dismiss();
    }

    public static String getText() {
        LoggerUtil.info("Get text from alert");
        return getAlert().getText();
    }

    public static void sendKeys(String text) {
        LoggerUtil.info("Send {} to alert", text);
        getAlert().sendKeys(text);
    }

    private static Alert getAlert() {
        return Wait.waitForAlertIsPresent();
    }
}