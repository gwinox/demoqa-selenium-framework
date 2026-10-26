package demoqa.pages.alerts_windows;

import framework.elements.Button;
import framework.page.BasePage;
import org.openqa.selenium.By;

public class AlertsFrameWindowsPage extends BasePage {

    private static final By uniqueElement = By.xpath("//*[contains(@class, 'element-group') and contains(., 'Alerts, Frame & Windows')]//*[contains(@class, 'show')]");

    private final Button alertsMenuButton = new Button(By.xpath("//*[contains(@class, 'show')]//*[@id = 'item-1']//*[contains(@href, 'alerts')]"),
            "alertsMenuButton");
    private final Button browserWindowsButton = new Button(By.xpath("//*[contains(@class, 'show')]//*[@id = 'item-0']//*[contains(@href, 'browser')]"),
            "browserWindowsButton");
    private final Button framesMenuButton = new Button(By.xpath("//*[contains(@class, 'show')]//*[@id = 'item-2']//*[contains(@href, 'frames')]"),
            "framesMenuButton");
    private final Button nestedFramesMenuButton = new Button(By.xpath("//*[contains(@class, 'show')]//*[@id = 'item-3']//*[contains(@href, 'frames')]"),
            "nestedFramesMenuButton");

    public AlertsFrameWindowsPage() {
        super(uniqueElement, "AlertsFrameWindowsPage");
    }

    public void clickAlertsMenu() {
        alertsMenuButton.click();
    }

    public void clickBrowserWindowsMenu() {
        browserWindowsButton.click();
    }

    public void clickFramesMenu() {
        framesMenuButton.click();
    }

    public void clickNestedFramesMenu() {
        nestedFramesMenuButton.clickWithJS();
    }
}