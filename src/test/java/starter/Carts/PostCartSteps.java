package starter.Carts;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.MiddlemanAPI.MiddlemanAPI;
import starter.utils.Constants;

import java.io.File;

public class PostCartSteps {

    @Steps
    CartAPI cartAPI;
    MiddlemanAPI middlemanAPI;
    @Given("create add new cart with file json {string}")
    public void createAddNewCartWithFileJson(String filename) {
        File filejson= new File(Constants.REQ_BODY + filename);
        cartAPI.Postcarts(filejson);
    }

    @When("send request post add new chart")
    public void sendRequestPostAddNewChart() {
        SerenityRest.when().post(middlemanAPI.CARTS);
        if (SerenityRest.then().extract().statusCode() != 200) {
            System.out.println("Error response: " + SerenityRest.then().extract().body().asString());
        }
    }
}
