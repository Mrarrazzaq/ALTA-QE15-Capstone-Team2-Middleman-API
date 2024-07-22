package starter.Inoutbounds;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
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

}
