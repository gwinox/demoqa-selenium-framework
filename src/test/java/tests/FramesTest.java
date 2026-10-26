package tests;

import demoqa.manager.DataManager;
import demoqa.pages.MainPage;
import demoqa.pages.alerts_windows.AlertsFrameWindowsPage;
import demoqa.pages.alerts_windows.FramesPage;
import demoqa.pages.alerts_windows.NestedFramesPage;
import framework.test.BaseTest;
import framework.utils.LoggerUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FramesTest extends BaseTest {

    @Test
    public void framesTest() {
        MainPage mainPage = new MainPage();
        AlertsFrameWindowsPage categoryPage = new AlertsFrameWindowsPage();
        NestedFramesPage nestedFramesPage = new NestedFramesPage();
        FramesPage framesPage = new FramesPage();

        LoggerUtil.info("Открытие главной страницы");
        Assert.assertTrue(mainPage.isDisplayed(), "Main page isn't displayed");

        LoggerUtil.info("Проверка вложенных фреймов");
        mainPage.alertsFrameWindowsButtonClick();

        Assert.assertTrue(categoryPage.isDisplayed(), "Alerts, Frame & Windows category page isn't displayed");
        categoryPage.clickNestedFramesMenu();

        Assert.assertTrue(nestedFramesPage.isDisplayed(), "NestedFrames page isn't displayed");
        Assert.assertEquals(nestedFramesPage.getParentFrameText(), DataManager.getData().getNestedParentFrameText(), "Parent frame text is incorrect");
        Assert.assertEquals(nestedFramesPage.getChildFrameText(), DataManager.getData().getNestedChildFrameText(), "Child frame text is incorrect");

        LoggerUtil.info("Сравнение текста во фреймах");
        categoryPage.clickFramesMenu();

        Assert.assertTrue(framesPage.isDisplayed(), "Frames page isn't displayed");
        Assert.assertEquals(framesPage.getTopFrameText(), framesPage.getBottomFrameText(), "Texts in upper and lower frames do not match");
    }
}