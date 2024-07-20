package starter.Carts;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.MiddlemanAPI.MiddlemanAPI;
import starter.utils.Constants;

import static starter.Carts.AuthStepsdef.token;

public class GetCartSteps {

    @Steps
    CartAPI cartAPI;
    MiddlemanAPI middlemanAPI;
    @Given("Set path for get from cart")
    public void setPathForGetFromCart() {
        cartAPI.Getcarts();
    }

    @When("Send request to get carts")
    public void sendRequestToGetCarts() {
        SerenityRest.when()
                .get(middlemanAPI.CARTS);
        if (SerenityRest.then().extract().statusCode() != 200) {
            System.out.println("Error response: " + SerenityRest.then().extract().body().asString());
        }
    }


}
