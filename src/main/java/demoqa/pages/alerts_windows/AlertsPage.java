package demoqa.pages.alerts_windows;

import framework.elements.Button;
import framework.elements.Text;
import framework.page.BasePage;
import org.openqa.selenium.By;

public class AlertsPage extends BasePage {

    private static final By uniqueElement = By.id("javascriptAlertsWrapper");
    private final Button toSeeAlertButton = new Button(By.id("alertButton"),
            "toSeeAlertButton");
    private final Button confirmButton = new Button(By.id("confirmButton"),
            "confirmButton");
    private final Text confirmResult = new Text(By.id("confirmResult"),
            "confirmResult");
    private final Button promptButton = new Button(By.id("promtButton"),
            "promptButton");
    private final Text promptResult = new Text(By.id("promptResult"),
            "promptResult");

    public AlertsPage() {
        super(uniqueElement, "AlertsPage");
    }

    public void toSeeAlertButtonClick() {
        toSeeAlertButton.click();
    }

    public void confirmButtonClick() {
        confirmButton.click();
    }

    public String getConfirmResultText() {
        return confirmResult.getText();
    }

    public void promptButtonClick() {
        promptButton.click();
    }

    public String getPromptResultText() {
        return promptResult.getText();
    }
}