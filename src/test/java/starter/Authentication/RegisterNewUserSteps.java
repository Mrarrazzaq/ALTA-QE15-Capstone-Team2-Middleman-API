package starter.Authentication;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import starter.MiddlemanAPI.MiddlemanAPI;
import starter.utils.Constants;

import java.io.File;

public class RegisterNewUserSteps {

    MiddlemanAPI middlemanAPI;
    @Given("Set path for register new user")
    public void setPathForRegisterNewUser() {
        SerenityRest.given()
                .when()
                .get(middlemanAPI.REGISTER);
    }

    @And("User fill the form with valid data {string}")
    public void userFillTheFormWithValidData(String file) {
        File fileJson = new File(Constants.REQ_BODY + file);
        SerenityRest.given()
                .contentType("application/json")
                .body(fileJson);
    }

    @And("User click register button")
    public void userClickRegisterButton() {
        SerenityRest.when()
                .post(middlemanAPI.REGISTER);
    }

    @Then("validate body response {string}")
    public void validateBodyResponse(String file) {
        File fileJson = new File(Constants.JSON_SCHEMA + file);
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(fileJson));
    }
}
