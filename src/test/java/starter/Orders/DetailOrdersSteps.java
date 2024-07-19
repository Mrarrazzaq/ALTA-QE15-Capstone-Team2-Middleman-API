package starter.Orders;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

public class DetailOrdersSteps {

    @Steps
    OrdersAPI ordersAPI;


    @When("Send request to get detail order")
    public void sendRequestToGetDetailOrder() {
        SerenityRest.when().post(OrdersAPI.ORDERS_DETAIL);
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
