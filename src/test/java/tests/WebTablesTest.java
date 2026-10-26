package tests;

import demoqa.manager.DataManager;
import demoqa.model.User;
import demoqa.pages.MainPage;
import demoqa.pages.elements.ElementsPage;
import demoqa.pages.elements.WebTablesModalPage;
import demoqa.pages.elements.WebTablesPage;
import framework.test.BaseTest;
import framework.utils.LoggerUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class WebTablesTest extends BaseTest {

    @DataProvider(name = "usersProvider")
    public Object[][] getUsersData() {
        List<User> userList = DataManager.getData().getUsers();
        Object[][] data = new Object[userList.size()][1];

        for (int i = 0; i < userList.size(); i++) {
            data[i][0] = userList.get(i);
        }
        return data;
    }

    @Test(dataProvider = "usersProvider")
    public void tablesTest(User user) {
        LoggerUtil.info("Запуск теста для пользователя {} {}", user.getFirstName(), user.getLastName());

        MainPage mainPage = new MainPage();
        ElementsPage elementsPage = new ElementsPage();
        WebTablesPage webTablesPage = new WebTablesPage();
        WebTablesModalPage webTablesModalPage = new WebTablesModalPage();

        LoggerUtil.info("Открытие главной страницы");
        Assert.assertTrue(mainPage.isDisplayed(), "Main page isn't displayed");

        LoggerUtil.info("Переход в раздел Web Tables");
        mainPage.elementButtonClick();
        Assert.assertTrue(elementsPage.isDisplayed(), "Elements page isn't displayed");
        elementsPage.clickWebTablesMenu();
        Assert.assertTrue(webTablesPage.isDisplayed(), "WebTables page isn't displayed");

        LoggerUtil.info("Открытие формы добавления записи");
        webTablesPage.addNewRecordButtonClick();
        Assert.assertTrue(webTablesModalPage.isDisplayed(), "WebTablesModalPage page isn't displayed");

        LoggerUtil.info("Добавление пользователя в таблицу");
        webTablesModalPage.fillRegistrationForm(user);
        webTablesModalPage.submitButtonClick();
        webTablesModalPage.waitForModalToDisappear();
        Assert.assertTrue(webTablesPage.isUserPresentInTable(user), "User isn't present");

        LoggerUtil.info("Удаление пользователя из таблицы");
        webTablesPage.deleteUserFromTable(user);
        Assert.assertFalse(webTablesPage.isUserPresentInTable(user), "User is present");
    }
}