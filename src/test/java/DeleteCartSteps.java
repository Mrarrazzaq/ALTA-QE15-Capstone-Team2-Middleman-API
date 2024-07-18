import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Carts.CartAPI;

public class DeleteCartSteps {
    @Steps
    CartAPI cartAPI;
    @Given("Delete cart with id {int}")
    public void deleteCartWithId(int idproduct) {
        cartAPI.Deletecart(idproduct);
    }

    @When("send request delete cart")
    public void sendRequestDeleteCart() {
        SerenityRest.when().delete(CartAPI.CARTS_ID);
    }

}
