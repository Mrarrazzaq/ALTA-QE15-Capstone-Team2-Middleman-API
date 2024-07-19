package starter.Orders;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

public class GetIncomingOrdersAdminSteps {
    @Steps
    OrdersAPI ordersAPI;
    @Given("set path for incoming order from admin")
    public void setPathForIncomingOrderFromAdmin() {
        ordersAPI.Getincomingorderadmin();
    }

    @When("Send request to get incoming order admin")
    public void sendRequestToGetIncomingOrderAdmin() {
        SerenityRest.when().post(OrdersAPI.ORDERS_ADMIN_INCOMMING);
    }
}
