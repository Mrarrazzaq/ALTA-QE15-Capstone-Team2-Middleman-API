package starter.Inoutbounds;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.MiddlemanAPI.MiddlemanAPI;

public class GetInoutboundsSteps {
    @Steps
    InoutboundSteps inoutboundSteps;

    @Given("Set path for stock user and admin in and out")
    public void setPathForStockUserAndAdminInAndOut() {
        inoutboundSteps.Getinoutbound();
    }

    @When("Send request inoutbound")
    public void sendRequestInoutbound() {
        SerenityRest.when().get(MiddlemanAPI.INOUTBOUNDS);
    }

    @Then("Status code inoutbound should be {int}")
    public void statusCodeInoutboundShouldBe(int statuscode) {
        SerenityRest.then().statusCode(statuscode);
    }
}
