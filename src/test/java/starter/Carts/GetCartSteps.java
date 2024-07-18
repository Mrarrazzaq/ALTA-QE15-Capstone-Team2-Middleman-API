package starter.Carts;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import static starter.Carts.AuthStepsdef.token;

public class GetCartSteps {

    @Steps
    CartAPI cartAPI;
    @Given("Set path for get from cart")
    public void setPathForGetFromCart() {
        SerenityRest.when().get(CartAPI.CARTS);
    }

    @When("Send request to get carts")
    public void sendRequestToGetCarts() {
        SerenityRest.given().header("Authorization","Ba");
    }


}
