package framework.elements;

import framework.browser.Browser;
import framework.browser.Wait;
import framework.configuration.ConfigManager;
import framework.utils.LoggerUtil;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

public abstract class BaseElement {

    protected final By locator;
    @Getter
    protected final String name;

    public BaseElement(By locator, String name) {
        this.locator = locator;
        this.name = name;
    }

    protected WebElement findElement() {
        LoggerUtil.info("{} find", name);
        return Wait.waitForPresence(locator);
    }

    public void click() {
        LoggerUtil.info("Click {}", name);
        Wait.waitForClickable(locator).click();
    }

    public void clickWithJS() {
        LoggerUtil.info("click {} with JavaScript", name);
        WebElement element = Wait.waitForClickable(locator);
        Browser.clickWithJS(element, name);
    }

    public String getText() {
        LoggerUtil.info("Get text from {}", name);
        return findElement().getText();
    }

    public boolean isDisplayed() {
        try {
            Wait.waitForVisibility(locator, ConfigManager.getConfig().getShortTimeout());
            LoggerUtil.info("{} is displayed", name);
            return true;
        } catch (TimeoutException | NoSuchElementException e) {
            LoggerUtil.info("{} isn't displayed", name);
            return false;
        }
    }

}
