package framework.test;

import framework.browser.Browser;
import framework.configuration.ConfigManager;
import framework.utils.LoggerUtil;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {

    @BeforeMethod
    public void testStart() {
        LoggerUtil.info("Start test");
        Browser.openUrl(ConfigManager.getConfig().getBaseUrl());
    }

    @AfterMethod
    public void testEnd() {
        LoggerUtil.info("Finish test");
        Browser.quit();
    }
}
