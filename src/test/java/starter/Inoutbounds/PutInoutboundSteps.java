package starter.Inoutbounds;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Inoutbounds.InoutboundSteps;
import starter.MiddlemanAPI.MiddlemanAPI;
import starter.utils.Constants;

import java.io.File;

public class PutInoutboundSteps {

    @Steps
    InoutboundSteps inoutboundSteps;

    @Given("Put update admin inbounds product quantity with valid parameter {int} and request body {string}")
    public void putUpdateAdminInboundsProductQuantityWithValidParameterAndRequestBody(int id, String filename) {
        File jsonFile = new File(Constants.REQ_BODY + filename);
        inoutboundSteps.Updateinoutbound(id, jsonFile);
    }

    @When("Send request put update inbounds")
    public void sendRequestPutUpdateInbounds() {
        SerenityRest.when().put(MiddlemanAPI.INOUTBOUNDS_ID);
    }


    @Given("Put update admin inbounds product quantity with valid parameter {string} and request body {string}")
    public void putUpdateAdminInboundsProductQuantityWithValidParameterAndRequestBody(String id1, String filename) {
        File jsonFile = new File(Constants.REQ_BODY + filename);
        inoutboundSteps.Updateinoutboundinvalid(id1, jsonFile);
    }
}
