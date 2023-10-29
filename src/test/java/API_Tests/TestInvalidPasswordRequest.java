package API_Tests;

import io.restassured.http.ContentType;
import models.fromserver.CallUserForSignupModel;
import models.toserver.AuthFormBody;
import org.junit.jupiter.api.Test;

import static constants.Urls.*;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestInvalidPasswordRequest {
    private final String invalidPassword = "12345";
    private AuthFormBody authFormBodyValid = AuthFormBody.builder()
            .userName("Ivanov Ivan")
            .login("test@gmail.com")
            .phoneNumber("89991114477")
            .password(invalidPassword)
            .passwordValidation(invalidPassword)
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
        assertEquals(false, callUserForSignupModel.isType());
        assertEquals("Пароль должен состоять минимум из 8 символов",
                callUserForSignupModel.getMessage());
    }
}
