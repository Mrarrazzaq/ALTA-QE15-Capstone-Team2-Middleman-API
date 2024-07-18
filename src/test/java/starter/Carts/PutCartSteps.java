package starter.Carts;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import utils.Constants;

import java.io.File;

public class PutCartSteps {

    @Steps
    CartAPI cartAPI;

    @Given("update cart with parameter id product {int} file json {string}")
    public void updateCartWithParameterIdProductFileJson(int cart, String jsonfile) {
        File filejson = new File(Constants.REQ_BODY+jsonfile);
        cartAPI.Updatecarts(cart,filejson);
    }
    @When("send request update chart")
    public void sendRequestUpdateChart() {
        SerenityRest.when().put(CartAPI.CARTS_ID);
    }


}
