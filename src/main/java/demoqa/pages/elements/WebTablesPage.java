package demoqa.pages.elements;

import demoqa.model.User;
import framework.elements.Button;
import framework.elements.Text;
import framework.page.BasePage;
import org.openqa.selenium.By;

public class WebTablesPage extends BasePage {

    private static final By uniqueElement = By.xpath("//*[contains(@class, 'show')]");
    private static final String USER_ROW_XPATH = "//table//tr[.//*[contains(text(), '%s')]]";
    private static final String DELETE_BUTTON_XPATH = USER_ROW_XPATH + "//span[contains(@id, 'delete-record')]";

    private final Button addNewRecordButton = new Button(By.xpath("//button[@id='addNewRecordButton']"),
            "addNewRecordButton");

    public WebTablesPage() {
        super(uniqueElement, "WebTablesPage");
    }

    public void addNewRecordButtonClick() {
        addNewRecordButton.click();
    }

    public boolean isUserPresentInTable(User user) {
        String xpath = String.format(USER_ROW_XPATH, user.getFirstName());
        Text userRow = new Text(By.xpath(xpath), "userRow");
        return userRow.isDisplayed();
    }

    public void deleteUserFromTable(User user) {
        String xpath = String.format(DELETE_BUTTON_XPATH, user.getFirstName());
        Button deleteUser = new Button(By.xpath(xpath), "deleteUser");
        deleteUser.click();
    }
}