package starter.Authentication;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import net.serenitybdd.rest.SerenityRest;
import starter.MiddlemanAPI.MiddlemanAPI;
import starter.utils.Constants;

public class LoginUserSteps {

    MiddlemanAPI middlemanAPI;

    @Given("Set path for login user")
    public void setPathForLoginUser() {
        SerenityRest.given()
                .when()
                .get(middlemanAPI.LOGIN);
    }

    @And("User enter email {string} and password {string}")
    public void userEnterEmailAndPassword(String email, String password) {
        SerenityRest.given()
                .formParam("email", email)
                .formParam("password", password);
    }

    @And("User click login button")
    public void userClickLoginButton() {
        SerenityRest.when()
                .post(middlemanAPI.LOGIN);
    }

    @And("status code user should be {int}")
    public void statusCodeUserShouldBe(int Expected) {
        SerenityRest.then().statusCode(Expected);
        String tokenUser = SerenityRest.then().extract().jsonPath().getString("data.token");
        System.out.println(tokenUser);
    }
}
