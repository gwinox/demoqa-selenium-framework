package framework.elements;

import framework.utils.LoggerUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Input extends BaseElement {

    public Input(By locator, String name) {
        super(locator, name);
    }

    public void type(String text) {
        LoggerUtil.info("Type text into {}", name);
        findElement().sendKeys(text);
    }

    public void clearAndType(String text) {
        LoggerUtil.info("Clear and type text into {}", name);
        WebElement element = findElement();
        element.clear();
        element.sendKeys(text);
    }
}
