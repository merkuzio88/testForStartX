package ui_activity;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static constants.Urls.*;
public class AuthFieldSteps extends BaseSteps {
    private final String loginModalAuth = "#loginModalAuth";
    private final String loginModalTitle = ".otp__h1";
    private final String signUpFormTitle = ".signUpForm";
    private final String passwordErrorMessage = ".signUpForm__errText";

    public AuthFieldSteps openAuthPage() {
        open(BASE_URL);
        $(signUpFormTitle).shouldBe(visible.because("Должна открыться форма авторизации"))
                .shouldHave(text("Карта HackMeBank уже сегодня"));
        return this;
    }
    public AuthFieldSteps fillAllFieldsValid() {
        fillNameFieldValid();
        fillMailFieldValid();
        fillPhoneFieldValid();
        fillPasswordFieldValid();
        fillPasswordValidationFieldValid();
        setCheckBoxes();
        clickSubmitButton();
        return this;
    }

    public AuthFieldSteps checkModalWindowSuccess() {
        confirm();
        $(loginModalAuth).shouldBe(visible.because("Должно появиться окно ввода смс-кода"));
        $(loginModalTitle).shouldBe(visible).shouldHave(text("Код проверки"));
        return this;
    }

    public AuthFieldSteps fillAllFieldsWithInvalidPassword() {
        fillNameFieldValid();
        fillMailFieldValid();
        fillPhoneFieldValid();
        fillPasswordFieldInvalid();
        fillPasswordValidationFieldInvalid();
        setCheckBoxes();
        clickSubmitButton();
        return this;
    }
    public AuthFieldSteps checkPasswordError() {
        $(passwordErrorMessage).shouldBe(visible.because("Должно отобразиться сообщение о некорректной длине пароля"))
                .shouldHave(text("Пароль должен быть не менее 8 символов"));
        return this;
    }
}
