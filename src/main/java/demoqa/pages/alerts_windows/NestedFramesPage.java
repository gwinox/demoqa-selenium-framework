package demoqa.pages.alerts_windows;

import framework.browser.Wait;
import framework.elements.Text;
import framework.page.BasePage;
import framework.utils.FrameUtils;
import org.openqa.selenium.By;

public class NestedFramesPage extends BasePage {

    private static final By uniqueElement = By.id("framesWrapper");
    private static final By parentFrameLocator = By.id("frame1");
    private static final By childFrameLocator = By.xpath("//iframe[@srcdoc]");
    private final Text parentTextElement = new Text(By.tagName("body"), "parentText");
    private final Text childTextElement = new Text(By.tagName("p"), "childText");

    public NestedFramesPage() {
        super(uniqueElement, "NestedFramesPage");
    }

    public String getParentFrameText() {
        FrameUtils.switchToFrame(parentFrameLocator);

        Wait.waitForTextIsNotEmpty(By.tagName("body"));
        String text = parentTextElement.getText();

        FrameUtils.switchToDefaultContent();
        return text;
    }

    public String getChildFrameText() {
        FrameUtils.switchToFrame(parentFrameLocator);
        FrameUtils.switchToFrame(childFrameLocator);

        Wait.waitForTextIsNotEmpty(By.tagName("p"));
        String text = childTextElement.getText();
        FrameUtils.switchToDefaultContent();
        return text;
    }
}