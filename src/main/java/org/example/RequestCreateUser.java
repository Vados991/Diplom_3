package org.example;
import constant.Constants;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RequestCreateUser {

    public static Response createUser(User user) {
        return given()
                .header("Content-Type", "application/json")
                .body(user)
                .post(Constants.CREATE_NEW_USER);
    }

    public static Response authUser(User user) {
        return given()
                .header("Content-Type", "application/json")
                .body(user)
                .post(Constants.LOGIN_USER);
    }

    public static Response deleteUser(String authToken) {
        String AuthRoute = Constants.USER_AUTH;
        return given()
                .header("Authorization", authToken)
                .delete(AuthRoute);
    }
}