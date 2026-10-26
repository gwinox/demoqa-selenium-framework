package framework.page;

import framework.elements.Text;
import framework.utils.LoggerUtil;
import org.openqa.selenium.By;

public abstract class BasePage {

    protected final Text uniqueElement;
    protected final String name;

    protected BasePage(By uniqueLocator, String name) {
        this.uniqueElement = new Text(uniqueLocator, name);
        this.name = name;
    }

    public boolean isDisplayed() {
        LoggerUtil.info("Check if page {} is displayed", name);
        return uniqueElement.isDisplayed();
    }
}