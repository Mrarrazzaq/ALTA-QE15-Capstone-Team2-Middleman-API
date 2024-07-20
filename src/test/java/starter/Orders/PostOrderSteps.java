package starter.Orders;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Carts.CartAPI;
import starter.MiddlemanAPI.MiddlemanAPI;
import starter.utils.Constants;

import java.io.File;

public class PostOrderSteps {
    @Steps
    OrdersAPI ordersAPI;
    MiddlemanAPI middlemanAPI;
    @Given("create add new order with file json {string}")
    public void createAddNewOrderWithFileJson(String filename) {
        File jsonfile = new File(Constants.REQ_BODY+filename);
        ordersAPI.Postorderuser(jsonfile);
    }
    @When("send request post add new order")
    public void sendRequestPostAddNewOrder() {
        SerenityRest.when().post(middlemanAPI.ORDERS);
        if (SerenityRest.then().extract().statusCode() != 200) {
            System.out.println("Error response: " + SerenityRest.then().extract().body().asString());
        }
    }



}
