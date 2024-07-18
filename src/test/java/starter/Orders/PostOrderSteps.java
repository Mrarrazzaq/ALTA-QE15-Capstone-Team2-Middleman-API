package starter.Orders;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import jdk.vm.ci.meta.Constant;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Carts.CartAPI;
import utils.Constants;

import java.io.File;

public class PostOrderSteps {
    @Steps
    CartAPI cartAPI;
    @Given("create add new order with file json {string}")
    public void createAddNewOrderWithFileJson(String filename) {
        File jsonfile = new File(Constants.REQ_BODY+filename);
        cartAPI.Postorder(jsonfile);
    }
//    @When("send request post add new order")
//    public void sendRequestPostAddNewOrder() {
//        SerenityRest.when().post()
//    }

    @Then("status code should be response {int}")
    public void statusCodeShouldBeResponse(int arg0) {
    }
}
