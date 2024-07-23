package starter.Inoutbounds;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.cucumber.suiteslicing.SerenityTags;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Authentication.LoginAdminSteps;
import starter.Authentication.LoginUserSteps;
import starter.MiddlemanAPI.MiddlemanAPI;
import starter.utils.Constants;

import java.io.File;

public class PostInoutboundSteps {
    @Steps
    InoutboundSteps inoutboundSteps;
    @Given("Get admin products inbounds {string}")
    public void getAdminProductsInbounds(String filename) {
        File jsonfile = new File(Constants.REQ_BODY + filename);
        inoutboundSteps.Postinoutbound(jsonfile);

    }

    @When("Send request get admin inbounds")
    public void sendRequestGetAdminInbounds() {
        SerenityRest.when().post(MiddlemanAPI.INOUTBOUNDS);
    }

    @Given("Get admin products inbounds form-data")
    public void getAdminProductsInboundsFormData() {
        SerenityRest.given()
                .header("Authorization", "Bearer " + LoginAdminSteps.TOKEN_ADMIN)
                .contentType("multipart/form-data")
                .multiPart("product_id", "19")
                .multiPart("qty", "5");
    }
}
