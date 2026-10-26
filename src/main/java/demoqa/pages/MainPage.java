package demoqa.pages;

import framework.elements.Button;
import framework.page.BasePage;
import org.openqa.selenium.By;

public class MainPage extends BasePage {

    private static final By uniqueElement = By.xpath("//*[@class = 'home-content']");
    private final Button alertsFrameWindowsButton = new Button(By.xpath("//*[contains(@href, 'alerts')]"),
            "alertsFrameWindowsButton");
    private final Button elementsButton = new Button(By.xpath("//*[contains(@href, 'elements')]"),
            "elementsButton");

    public MainPage() {
        super(uniqueElement, "MainPage");
    }

    public void alertsFrameWindowsButtonClick() {
        alertsFrameWindowsButton.click();
    }

    public void elementButtonClick() {
        elementsButton.click();
    }
}