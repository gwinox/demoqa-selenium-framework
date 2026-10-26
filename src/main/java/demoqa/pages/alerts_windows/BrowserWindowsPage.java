package demoqa.pages.alerts_windows;

import framework.elements.Button;
import framework.page.BasePage;
import org.openqa.selenium.By;

public class BrowserWindowsPage extends BasePage {

    private static final By uniqueElement = By.xpath("//*[@id = 'browserWindows']");

    private final Button newTabButton = new Button(By.xpath("//*[@id = 'tabButton']"),
            "newTabButton");

    public BrowserWindowsPage() {
        super(uniqueElement, "BrowserWindowsPage");
    }

    public void newTabButtonClick() {
        newTabButton.click();
    }
}