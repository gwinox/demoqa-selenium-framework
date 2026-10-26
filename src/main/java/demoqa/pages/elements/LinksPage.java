package demoqa.pages.elements;

import framework.elements.Button;
import framework.page.BasePage;
import org.openqa.selenium.By;

public class LinksPage extends BasePage {
    private static final By uniqueElement = By.id("linkWrapper");
    private final Button homeButton = new Button(By.id("simpleLink"),
            "homeButton");

    public LinksPage() {
        super(uniqueElement, "LinksPage");
    }

    public void homeButtonClick() {
        homeButton.click();
    }

}
