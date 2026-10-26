package tests;

import demoqa.manager.DataManager;
import framework.test.BaseTest;
import framework.utils.AlertUtils;
import framework.utils.LoggerUtil;
import framework.utils.TextGenerator;
import demoqa.pages.MainPage;
import demoqa.pages.alerts_windows.AlertsFrameWindowsPage;
import demoqa.pages.alerts_windows.AlertsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertsTest extends BaseTest {

    @Test
    public void alertsTest() {
        MainPage mainPage = new MainPage();
        AlertsFrameWindowsPage categoryPage = new AlertsFrameWindowsPage();
        AlertsPage alertsPage = new AlertsPage();

        LoggerUtil.info("Открытие главной страницы");
        Assert.assertTrue(mainPage.isDisplayed(), "Main page isn't displayed");

        LoggerUtil.info("Переход в раздел Alerts");
        mainPage.alertsFrameWindowsButtonClick();
        Assert.assertTrue(categoryPage.isDisplayed(), "Alerts, Frame & Windows category page isn't displayed");
        categoryPage.clickAlertsMenu();
        Assert.assertTrue(alertsPage.isDisplayed(), "Alerts page isn't displayed");

        LoggerUtil.info("Проверка простого алерта");
        alertsPage.toSeeAlertButtonClick();
        Assert.assertTrue(AlertUtils.isAlertPresent(), "Alert isn't displayed");
        Assert.assertEquals(AlertUtils.getText(), DataManager.getData().getSimpleAlertText(), "Incorrect simple alert text");

        LoggerUtil.info("Закрытие алерта");
        AlertUtils.accept();

        LoggerUtil.info("Проверка алерта с подтверждением");
        alertsPage.confirmButtonClick();
        Assert.assertTrue(AlertUtils.isAlertPresent(), "ConfirmAlert isn't displayed");
        Assert.assertEquals(AlertUtils.getText(), DataManager.getData().getConfirmAlertText(), "Incorrect confirm alert text");

        LoggerUtil.info("Подтверждение и проверка результата");
        AlertUtils.accept();
        String actualConfirmText = alertsPage.getConfirmResultText();
        String expectedConfirmText = DataManager.getData().getConfirmButtonChooseText();
        Assert.assertTrue(actualConfirmText.contains(expectedConfirmText),
                String.format("Confirm text does not match! Expected to contain: '%s', but actual was: '%s'", expectedConfirmText, actualConfirmText));

        LoggerUtil.info("Проверка алерта с вводом текста");
        alertsPage.promptButtonClick();
        Assert.assertTrue(AlertUtils.isAlertPresent(), "PromptAlert isn't displayed");
        Assert.assertEquals(AlertUtils.getText(), DataManager.getData().getPromptAlertText(), "Incorrect prompt alert text");

        LoggerUtil.info("Ввод случайного текста и проверка результата");
        int length = DataManager.getData().getRandomStringLength();
        String generatedText = TextGenerator.getGeneratedText(length);
        AlertUtils.sendKeys(generatedText);
        AlertUtils.accept();

        String actualPromptText = alertsPage.getPromptResultText();
        Assert.assertTrue(actualPromptText.contains(generatedText),
                String.format("Prompt result does not match! Expected to contain: '%s', but actual was: '%s'", generatedText, actualPromptText));
    }
}