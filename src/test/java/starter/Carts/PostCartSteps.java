package starter.Carts;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import utils.Constants;

import java.io.File;

public class PostCartSteps {

    @Steps
    CartAPI cartAPI;
    @When("send request post add new chart")
    public void sendRequestPostAddNewChart() {
        SerenityRest.when().post(CartAPI.CARTS);
    }

    @And("set request body {string}")
    public void setRequestBody(String filename) {
        File filejson= new File(Constants.REQ_BODY + filename);
        cartAPI.Postcarts(filejson);
    }
}
