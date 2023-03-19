package org.example;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import static constant.Constants.*;
import static io.restassured.RestAssured.given;
public class RequestCreateUser extends Client{
    @Step("Create new user in system")
    public ValidatableResponse createUser(User user) {
        return given().log().all()
                .spec(getSpec())
                .body(user)
                .when()
                .post(CREATE_NEW_USER)
                .then();
    }

    @Step("Login user in system with email and password")
    public ValidatableResponse loginUser(AuthorizationData authorizationData) {
        return given().log().all()
                .spec(getSpec())
                .body(authorizationData)
                .when()
                .post(LOGIN_USER)
                .then();
    }

    @Step("Delete user by token")
    public void deleteUser(String accessToken) {
        given().log().all()
                .spec(getSpec())
                .auth().oauth2(accessToken)
                .when()
                .delete(USER_AUTH)
                .then();
    }

}