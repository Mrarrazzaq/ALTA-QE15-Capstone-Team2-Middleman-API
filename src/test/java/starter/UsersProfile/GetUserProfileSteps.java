package starter.UsersProfile;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import starter.Authentication.LoginUserSteps;
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
                .header("Authorization", "Bearer " + LoginUserSteps.TOKEN_USER);
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
        SerenityRest.and().statusCode(code);
    }

    @Then("Validate JSON schema {string}")
    public void validateJSONSchema(String file) {
        File fileJson = new File(Constants.JSON_SCHEMA + file);
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(fileJson));
    }

    @Given("Set path for get user profile {string}")
    public void setPathForGetUserProfile(String id) {
        SerenityRest.given()
                .pathParam("id", id)
                .header("accept", "application/json")
                .header("Authorization", "Bearer " + LoginUserSteps.TOKEN_USER);
    }

    @And("Send request to get user profiles")
    public void sendRequestToGetUserProfiles() {
        SerenityRest.when()
                .get(middlemanAPI.USER_PROFILE);
        if (SerenityRest.then().extract().statusCode() != 200) {
            System.out.println("Error response: " + SerenityRest.then().extract().body().asString());
        }
    }

    @Given("Set path for get user profiles")
    public void setPathForGetUserProfiles() {
    }

    @Given("Set path for update user profile file json {string}")
    public void setPathForUpdateUserProfileFileJson(String fileName) {
        File file = new File(Constants.REQ_BODY + fileName);
        SerenityRest.given()
                .header("Authorization", "Bearer " + LoginUserSteps.TOKEN_USER)
                .contentType(ContentType.JSON)
                .body(file);
    }

    @When("send request update user profile")
    public void sendRequestUpdateUserProfile() {
        SerenityRest.when()
                .put(middlemanAPI.USER_PROFILE);
        if (SerenityRest.then().extract().statusCode() != 200) {
            System.out.println("Error response: " + SerenityRest.then().extract().body().asString());
        }
    }

    @Given("Set path for delete user")
    public void setPathForDeleteUser() {
        SerenityRest.given()
                .header("Authorization", "Bearer " + LoginUserSteps.TOKEN_USER);
    }

    @And("Send request to delete user")
    public void sendRequestToDeleteUser() {
        SerenityRest.when()
                .delete(middlemanAPI.USER_PROFILE);
        if (SerenityRest.then().extract().statusCode() != 200) {
            System.out.println("Error response: " + SerenityRest.then().extract().body().asString());
        }
    }
}