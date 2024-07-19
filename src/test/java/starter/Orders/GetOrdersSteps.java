package starter.Orders;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Carts.CartAPI;

public class GetOrdersSteps {
    @Steps
    OrdersAPI ordersAPI;
    @Given("Set path for get all history order user")
    public void setPathForGetAllHistoryOrderUser() {
        ordersAPI.Getallorderuser();

    }

    @When("Send request to get all history order")
    public void sendRequestToGetAllHistoryOrder() {
        SerenityRest.when().get(OrdersAPI.ORDERS_USER);
    }

    @Given("Set path for get all history order admin")
    public void setPathForGetAllHistoryOrderAdmin() {
        ordersAPI.Getallorderadmin();
    }

    @When("Send request to get all history order admin")
    public void sendRequestToGetAllHistoryOrderAdmin() {
        SerenityRest.when().get(OrdersAPI.ORDERS_ADMIN);
    }
}