package starter.Authentication;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.serenitybdd.rest.SerenityRest;
import org.junit.Assert;
import starter.MiddlemanAPI.MiddlemanAPI;
import starter.utils.Constants;
import java.io.File;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;


public class LoginAdminSteps {
    Constants constants;
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
        SerenityRest.when()
                .post(middlemanAPI.LOGIN);
    }

    @And("status code should be {int}")
    public void statusCodeShouldBe(int Expected) {
        SerenityRest.then().statusCode(Expected);
//        int Actual = SerenityRest.then().extract().statusCode();
//        Assert.assertEquals(Expected, Actual);

    }

    @Then("validate JSON schema {string}")
    public void validateJSONSchema(String file) {
        File fileJson = new File(Constants.JSON_SCHEMA + file);
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(fileJson));

    }
}
