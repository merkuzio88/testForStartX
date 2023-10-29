package API_Tests;

import io.restassured.http.ContentType;
import models.fromserver.CallUserForSignupModel;
import models.toserver.AuthFormBody;
import org.junit.jupiter.api.Test;

import static constants.Urls.*;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
        assertEquals(false, callUserForSignupModel.isType());
        assertEquals("\"ФИО\" должен содержать только текст",
                callUserForSignupModel.getMessage());
    }
}
