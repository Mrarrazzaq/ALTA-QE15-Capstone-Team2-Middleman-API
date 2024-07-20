package starter.UsersProfile;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import starter.MiddlemanAPI.MiddlemanAPI;
import starter.utils.Constants;
import io.restassured.http.ContentType;

import java.io.File;

public class GetUserProfileSteps {

    MiddlemanAPI middlemanAPI;
    @Given("Set path for get user profile")
    public void setPathForGetUserProfile() {
        SerenityRest.given()
                .header("accept", "application/json")
                .header("Authorization", "Bearer " + Constants.TOKEN_USER);
    }

    @And("Send request to get user profile")
    public void sendRequestToGetUserProfile() {
        SerenityRest.when()
                .get(middlemanAPI.USER_PROFILE);
        if (SerenityRest.then().extract().statusCode() != 200) {
            System.out.println("Error response: " + SerenityRest.then().extract().body().asString());
        }
    }

    @And("Status code should {int}")
    public void statusCodeShould(int code) {
        SerenityRest.then().statusCode(code);
    }

    @Then("Validate JSON schema {string}")
    public void validateJSONSchema(String file) {
        File fileJson = new File(Constants.JSON_SCHEMA + file);
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(fileJson));
    }
}
