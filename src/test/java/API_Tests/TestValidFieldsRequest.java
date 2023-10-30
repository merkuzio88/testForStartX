package API_Tests;

import io.restassured.http.ContentType;
import models.fromserver.CallUserForSignupModel;
import models.toserver.AuthFormBody;
import org.junit.jupiter.api.Test;

import static constants.Urls.*;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Тест проверки запроса с валидными данными
 * <p>
 * * 1. Отправляем POST запрос calluserforsignup с валидными данными
 * * 2. Проверяем что ответ соответствует ожидаемому
 */
public class TestValidFieldsRequest {
    private final String validPassword = "12345678";
    private AuthFormBody authFormBodyValid = AuthFormBody.builder()
            .userName("Ivanov Ivan")
            .login("test@gmail.com")
            .phoneNumber("89991114488")
            .password(validPassword)
            .passwordValidation(validPassword)
            .build();

    @Test
    void testValidFieldsRequest() {
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
        assertTrue(callUserForSignupModel.isType());
        assertEquals("Сейчас на ваш телефон поступит звонок, последние 4 цифры являются кодом",
                callUserForSignupModel.getText());
    }
}
