package demoqa.pages.alerts_windows;

import framework.elements.Text;
import framework.page.BasePage;
import framework.utils.FrameUtils;
import org.openqa.selenium.By;

public class FramesPage extends BasePage {

    private static final By uniqueElement = By.id("framesWrapper");

    private static final By topFrameLocator = By.id("frame1");
    private static final By bottomFrameLocator = By.id("frame2");

    private final Text topText = new Text(By.id("sampleHeading"), "topText");
    private final Text bottomText = new Text(By.id("sampleHeading"), "bottomText");

    public FramesPage() {
        super(uniqueElement, "FramesPage");
    }

    public String getTopFrameText() {
        FrameUtils.switchToFrame(topFrameLocator);
        String text = topText.getText();
        FrameUtils.switchToDefaultContent();
        return text;
    }

    public String getBottomFrameText() {
        FrameUtils.switchToFrame(bottomFrameLocator);
        String text = bottomText.getText();
        FrameUtils.switchToDefaultContent();
        return text;
    }
}