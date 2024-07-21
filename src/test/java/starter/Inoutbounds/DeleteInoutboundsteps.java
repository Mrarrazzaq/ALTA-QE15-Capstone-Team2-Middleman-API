package starter.Inoutbounds;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.sl.In;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.MiddlemanAPI.MiddlemanAPI;

public class DeleteInoutboundsteps {

    @Steps
    InoutboundSteps inoutboundSteps;

    @Given("Delete user product outbounds by id {int}")
    public void deleteUserProductOutboundsById(int id) {
        inoutboundSteps.Deleteinoutbound(id);
    }

    @When("Send request delete outbounds")
    public void sendRequestDeleteOutbounds() {
        SerenityRest.when().delete(MiddlemanAPI.INOUTBOUNDS_ID);
    }
}
