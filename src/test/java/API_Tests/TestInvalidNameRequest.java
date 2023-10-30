package API_Tests;

import io.restassured.http.ContentType;
import models.fromserver.CallUserForSignupModel;
import models.toserver.AuthFormBody;
import org.junit.jupiter.api.Test;

import static constants.Urls.*;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * Тест проверки запроса с некорректным именем
 * <p>
 * * 1. Отправляем POST запрос calluserforsignup с некорректными данными в поле userName
 * * 2. Проверяем что ответ соответствует ожидаемому
 */
public class TestInvalidNameRequest {
    private final String validPassword = "12345678";
    private AuthFormBody authFormBodyValid = AuthFormBody.builder()
            .userName("@#$^%")
            .login("test@gmail.com")
            .phoneNumber("89991114477")
            .password(validPassword)
            .passwordValidation(validPassword)
            .build();

    @Test
    void testInvalidPasswordRequest() {
        CallUserForSignupModel callUserForSignupModel = given()
                .contentType(ContentType.JSON)
                .body(authFormBodyValid)
                .when()
                .log().all()
                .post(BASE_API_URL)
                .then()
                .log().all()
                .statusCode(200)
                .extract().as(CallUserForSignupModel.class);
        assertFalse(callUserForSignupModel.isType());
        assertEquals("\"ФИО\" должен содержать только текст",
                callUserForSignupModel.getMessage());
    }
}
