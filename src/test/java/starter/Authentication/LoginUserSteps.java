package starter.Authentication;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import starter.MiddlemanAPI.MiddlemanAPI;
import starter.utils.Constants;
import java.io.File;
import io.restassured.module.jsv.JsonSchemaValidator;

public class LoginUserSteps {
    public static String TOKEN_USER;
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
        Response response = SerenityRest.when().post(MiddlemanAPI.LOGIN);
        JsonPath jsonPathEvaluator = response.jsonPath();
        TOKEN_USER = jsonPathEvaluator.get("data.token");
        if (SerenityRest.then().extract().statusCode() != 200) {
            System.out.println("Error response: " + SerenityRest.then().extract().body().asString());
        }
    }

    @And("status code user should be {int}")
    public void statusCodeUserShouldBe(int Expected) {
        SerenityRest.then().statusCode(Expected);
        String tokenUser = SerenityRest.then().extract().jsonPath().getString("data.token");
        System.out.println(tokenUser);
    }
}
