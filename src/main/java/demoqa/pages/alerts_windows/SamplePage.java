package demoqa.pages.alerts_windows;

import framework.page.BasePage;
import org.openqa.selenium.By;

public class SamplePage extends BasePage {

    private static final By uniqueElement = By.id("sampleHeading");

    public SamplePage() {
        super(uniqueElement, "SamplePage");
    }
}