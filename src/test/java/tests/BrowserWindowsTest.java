package tests;

import demoqa.pages.MainPage;
import demoqa.pages.alerts_windows.AlertsFrameWindowsPage;
import demoqa.pages.alerts_windows.BrowserWindowsPage;
import demoqa.pages.alerts_windows.SamplePage;
import demoqa.pages.elements.ElementsPage;
import demoqa.pages.elements.LinksPage;
import framework.browser.Browser;
import framework.test.BaseTest;
import framework.utils.LoggerUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BrowserWindowsTest extends BaseTest {

    @Test
    public void handlesTest() {
        MainPage mainPage = new MainPage();
        AlertsFrameWindowsPage alertsFrameWindowsPage = new AlertsFrameWindowsPage();
        BrowserWindowsPage browserWindowsPage = new BrowserWindowsPage();
        SamplePage samplePage = new SamplePage();
        ElementsPage elementsPage = new ElementsPage();
        LinksPage linksPage = new LinksPage();

        LoggerUtil.info("Открытие главной страницы");
        Assert.assertTrue(mainPage.isDisplayed(), "Main page isn't displayed");

        LoggerUtil.info("Переход в раздел Browser Windows");
        mainPage.alertsFrameWindowsButtonClick();
        Assert.assertTrue(alertsFrameWindowsPage.isDisplayed(), "Alerts, Frame & Windows category page isn't displayed");
        alertsFrameWindowsPage.clickBrowserWindowsMenu();
        Assert.assertTrue(browserWindowsPage.isDisplayed(), "BrowserWindow page isn't displayed");

        LoggerUtil.info("Открытие новой вкладки");
        browserWindowsPage.newTabButtonClick();
        Browser.switchWindow(1);
        Assert.assertTrue(samplePage.isDisplayed(), "Sample page isn't displayed");

        LoggerUtil.info("Закрытие вкладки и возврат на исходную");
        Browser.closeCurrentWindow();
        Browser.switchWindow(0);
        Assert.assertTrue(browserWindowsPage.isDisplayed(), "BrowserWindow page isn't displayed");

        LoggerUtil.info("Переход в раздел Links");
        elementsPage.elementsButtonClick();
        elementsPage.clickLinksMenu();
        Assert.assertTrue(linksPage.isDisplayed(), "Links page isn't displayed");

        LoggerUtil.info("Переход по ссылке в новой вкладке");
        linksPage.homeButtonClick();
        Browser.switchWindow(1);
        Assert.assertTrue(mainPage.isDisplayed(), "Main page isn't displayed");

        LoggerUtil.info("Возврат на предыдущую вкладку");
        Browser.switchWindow(0);
        Assert.assertTrue(linksPage.isDisplayed(), "Links page isn't displayed");
    }
}