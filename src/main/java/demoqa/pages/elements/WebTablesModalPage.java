package demoqa.pages.elements;

import demoqa.model.User;
import framework.browser.Wait;
import framework.elements.Button;
import framework.elements.Input;
import framework.page.BasePage;
import org.openqa.selenium.By;

public class WebTablesModalPage extends BasePage {
    private final static By uniqueElement = By.xpath("//*[@class = 'modal-content']");
    private final Input firstNameInput = new Input(By.xpath("//input[@id = 'firstName']"),
            "firstNameInput");
    private final Input lastNameInput = new Input(By.xpath("//input[@id = 'lastName']"),
            "lastNameInput");
    private final Input emailInput = new Input(By.xpath("//input[@id = 'userEmail']"),
            "emailInput");
    private final Input ageInput = new Input(By.xpath("//input[@id = 'age']"),
            "ageInput");
    private final Input salaryInput = new Input(By.xpath("//input[@id = 'salary']"),
            "salaryInput");
    private final Input departmentInput = new Input(By.xpath("//input[@id = 'department']"),
            "departmentInput");
    private final Button submitButton = new Button(By.xpath("//button[@type = 'submit']"),
            "submitButton");

    public WebTablesModalPage() {
        super(uniqueElement, "WebTablesModalPage");
    }

    public void fillRegistrationForm(User user) {
        firstNameInput.type(user.getFirstName());
        lastNameInput.type(user.getLastName());
        emailInput.type(user.getEmail());
        ageInput.type(String.valueOf(user.getAge()));
        salaryInput.type(String.valueOf(user.getSalary()));
        departmentInput.type(user.getDepartment());
    }

    public void submitButtonClick() {
        submitButton.click();
    }

    public void waitForModalToDisappear() {
        Wait.waitForInvisibility(uniqueElement);
    }
}
