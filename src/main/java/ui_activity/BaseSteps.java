package ui_activity;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.*;

public class BaseSteps {
    private final String userNameField = "#userName";
    private final String mailField = "#email";
    private final String phoneField = "#phoneNumber";
    private final String passwordField = "#password";
    private final String passwordValidationField = "#passwordValidation";
    private final String validPassword = "12345678";
    private final String checkBox = ".signUpForm__checkoboxItem";
    private final String submitButton = "#submitLogin";

    public BaseSteps fillNameFieldValid() {
        $(userNameField).setValue("Иванов Иван Иванович");
        return this;
    }
    public BaseSteps fillMailFieldValid() {
        $(mailField).setValue("test@gmail.com");
        return this;
    }
    public BaseSteps fillPhoneFieldValid() {
        $(phoneField).setValue("89991114477");
        return this;
    }
    public BaseSteps fillPasswordFieldValid() {
        $(passwordField).setValue(validPassword);
        return this;
    }
    public BaseSteps fillPasswordValidationFieldValid() {
        $(passwordValidationField).setValue(validPassword);
        return this;
    }
    public BaseSteps setCheckBoxes() {
        ElementsCollection checkboxes = $$(checkBox);
        for (SelenideElement checkbox : checkboxes) {
            checkbox.click();
        }
        return this;
    }
    public BaseSteps clickSubmitButton() {
        $(submitButton).click();
        return this;
    }
}
