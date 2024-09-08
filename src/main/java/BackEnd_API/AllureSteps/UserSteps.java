package BackEnd_API.AllureSteps;


import BackEnd_API.Serialization.Login;
import BackEnd_API.Serialization.User;
import BackEnd_API.SpecificationSetUp;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import static ConstantsURL.Constants.*;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;

public class UserSteps extends SpecificationSetUp {
    @Step("Create user")
    public ValidatableResponse createUser(User user) {
        return given()
                .spec(getSpec())
                .body(user)
                .when()
                .post(AUTH_REGISTER_URL)
                .then();
    }

    @Step("Delete user")
    public void deleteUser(String accessToken) {
        given()
                .header("authorization", accessToken)
                .spec(getSpec())
                .when()
                .delete(AUTH_USER_URL);
    }

    @Step("User login")
    public ValidatableResponse loginUser(Login login) {
        return
                given()
                        .spec(getSpec())
                        .body(requestSpecification)
                        .when()
                        .post(AUTH_LOGIN_URL)
                        .then();
    }

    @Step("Getting access token")
    public String getAccessToken(ValidatableResponse validatableResponse) {
        return validatableResponse.extract().path("accessToken");
    }

    @Step("Special delete after test")
    public void deleteAfterTest(String accessToken) {
        if (accessToken != null) {
            deleteUser(accessToken);
        } else {
            given().spec(getSpec())
                    .when()
                    .delete(AUTH_USER_URL);
        }
    }
}
