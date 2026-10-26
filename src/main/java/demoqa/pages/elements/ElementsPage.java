package demoqa.pages.elements;

import framework.elements.Button;
import framework.page.BasePage;
import org.openqa.selenium.By;

public class ElementsPage extends BasePage {

    private static final By uniqueElement = By.xpath("//div[contains(@class, 'element-group') and contains(., 'Elements')]//div[contains(@class, 'show')]");

    private final Button elementsButton = new Button(By.xpath("//*[contains(text(), 'Elements')]"),
            "elementsButton");

    private final Button linksMenuButton = new Button(By.xpath("//*[contains(@class, 'show')]//*[@id = 'item-5']//*[contains(@href, 'links')]"),
            "linksMenuButton");

    private final Button webTablesMenuButton = new Button(By.xpath("//*[contains(@class, 'show')]//*[@id = 'item-3']//*[contains(@href, 'webtables')]"),
            "webTablesMenuButton");

    public ElementsPage() {
        super(uniqueElement, "ElementsPage");
    }

    public void elementsButtonClick() {
        elementsButton.clickWithJS();
    }

    public void clickLinksMenu() {
        linksMenuButton.click();
    }

    public void clickWebTablesMenu() {
        webTablesMenuButton.click();
    }
}