package starter.Authentication;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import starter.MiddlemanAPI.MiddlemanAPI;
import starter.utils.Constants;
import java.io.File;
//import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.module.jsv.JsonSchemaValidator;

public class LoginAdminSteps {
    public static String TOKEN_ADMIN;
    MiddlemanAPI middlemanAPI;

    @Given("Set path for login admin")
    public void setPathForLoginAdmin() {
        SerenityRest.given()
                .when()
                .get(middlemanAPI.LOGIN);
    }

    @And("Admin enter email {string} and password {string}")
    public void adminEnterEmailAndPassword(String email, String password) {
        SerenityRest.given()
                .formParam("email", email)
                .formParam("password", password);
    }

    @And("Admin click login button")
    public void adminClickLoginButton() {
        Response response = SerenityRest.when().post(MiddlemanAPI.LOGIN);
        JsonPath jsonPathEvaluator = response.jsonPath();
        TOKEN_ADMIN = jsonPathEvaluator.get("data.token");
        if (SerenityRest.then().extract().statusCode() != 200) {
            System.out.println("Error response: " + SerenityRest.then().extract().body().asString());
        }
    }

    @And("status code should be {int}")
    public void statusCodeShouldBe(int Expected) {
        SerenityRest.then().statusCode(Expected);
        String tokenAdmin = SerenityRest.then().extract().jsonPath().getString("data.token");
        System.out.println(tokenAdmin);
    }

    @Then("validate JSON schema {string}")
    public void validateJSONSchema(String file) {
        File fileJson = new File(Constants.JSON_SCHEMA + file);
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(fileJson));

    }
}
