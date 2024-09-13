package backendapi.alluresteps;

import backendapi.serialization.User;
import backendapi.SpecificationSetUp;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import static constantsurl.Constants.*;
import static io.restassured.RestAssured.given;

public class UserSteps extends SpecificationSetUp {
    @Step("Create user")
    public ValidatableResponse createUser(User user) {
        return given()
                .spec(getSpec())
                .and()
                .body(user)
                .when()
                .post(AUTH_REGISTER_URL)
                .then();
    }

    @Step("Delete after test")
    public ValidatableResponse deleteAfterTest(String accessToken) {
            return given()
                    .spec(getSpec())
                    .header("authorization", accessToken)
                    .delete(AUTH_USER_URL)
                    .then();
    }

    @Step("User login")
    public ValidatableResponse loginUser(User user) {
        return
                given()
                        .spec(getSpec())
                        .body(user)
                        .when()
                        .post(AUTH_LOGIN_URL)
                        .then();
    }

    @Step("Getting access token")
    public String getAccessToken(ValidatableResponse validatableResponse) {
        return validatableResponse.extract().path("accessToken");
    }
}
