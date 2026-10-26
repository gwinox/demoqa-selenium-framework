package framework.browser;

import framework.configuration.ConfigManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Wait {

    private Wait() {
    }

    private static WebDriverWait getWait() {
        return new WebDriverWait(Browser.getDriver(), Duration.ofSeconds(ConfigManager.getConfig().getTimeout()));
    }

    private static WebDriverWait getWait(long timeoutSeconds) {
        return new WebDriverWait(Browser.getDriver(), Duration.ofSeconds(timeoutSeconds));
    }

    public static WebElement waitForVisibility(By locator) {
        return getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForVisibility(By locator, long timeoutSeconds) {
        return getWait(timeoutSeconds).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForPresence(By locator) {
        return getWait().until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static WebElement waitForPresence(By locator, long timeoutSeconds) {
        return getWait(timeoutSeconds).until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static WebElement waitForClickable(By locator) {
        return getWait().until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static WebElement waitForClickable(By locator, long timeoutSeconds) {
        return getWait(timeoutSeconds).until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static Alert waitForAlertIsPresent() {
        return getWait().until(ExpectedConditions.alertIsPresent());
    }

    public static Alert waitForAlertIsPresent(long timeoutSeconds) {
        return getWait(timeoutSeconds).until(ExpectedConditions.alertIsPresent());
    }

    public static void waitForInvisibility(By locator) {
        getWait().until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public static void waitForInvisibility(By locator, long timeoutSeconds) {
        getWait(timeoutSeconds).until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public static void waitForTextIsNotEmpty(By locator) {
        getWait().until(driver -> !driver.findElement(locator).getText().trim().isEmpty());
    }

    public static void waitForTextIsNotEmpty(By locator, long timeoutSeconds) {
        getWait(timeoutSeconds).until(driver -> !driver.findElement(locator).getText().trim().isEmpty());
    }
}
