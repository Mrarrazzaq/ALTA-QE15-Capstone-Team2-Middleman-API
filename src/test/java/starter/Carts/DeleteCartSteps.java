package starter.Carts;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Carts.CartAPI;
import starter.MiddlemanAPI.MiddlemanAPI;
import starter.utils.Constants;

public class DeleteCartSteps {
    @Steps
    CartAPI cartAPI;
    MiddlemanAPI middlemanAPI;

    @Given("Delete cart with id {int}")
    public void deleteCartWithId(int idproduct) {
        cartAPI.Deletecart(idproduct);
    }

    @When("send request delete cart")
    public void sendRequestDeleteCart() {
        SerenityRest.when().delete(middlemanAPI.CARTS_ID);
        if (SerenityRest.then().extract().statusCode() != 200) {
            System.out.println("Error response: " + SerenityRest.then().extract().body().asString());
        }
    }

}
