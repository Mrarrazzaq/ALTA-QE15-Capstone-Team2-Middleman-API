package starter.Orders;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.MiddlemanAPI.MiddlemanAPI;
import starter.utils.Constants;

public class DetailOrdersSteps {

    @Steps
    MiddlemanAPI middlemanAPI;
    OrdersAPI ordersAPI;


    @When("Send request to get detail order")
    public void sendRequestToGetDetailOrder() {
        SerenityRest.when().get(middlemanAPI.ORDERS_ID);
        if (SerenityRest.then().extract().statusCode() != 200) {
            System.out.println("Error response: " + SerenityRest.then().extract().body().asString());
        }

    }


    @Given("Set path for detail order with {int}")
    public void setPathForDetailOrderWith(int idorder) {
        ordersAPI.Getdetailuser(idorder);
    }

    @Given("Set path for detail order with {string}")
    public void setPathForDetailOrderWith(String idorder) {
        ordersAPI.Getdetailuserinvalid(idorder);

    }
}
