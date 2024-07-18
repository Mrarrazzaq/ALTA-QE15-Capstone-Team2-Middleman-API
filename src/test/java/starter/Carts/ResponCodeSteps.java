package starter.Carts;

import io.cucumber.java.en.Then;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

public class ResponCodeSteps {
    @Steps
    CartAPI cartAPI;

    @Then("Status code should be {int}")
    public void statusCodeShouldBe(int statuscode) {
        SerenityRest.then().statusCode(statuscode);
    }
}
