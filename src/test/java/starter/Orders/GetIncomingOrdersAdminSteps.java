package starter.Orders;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import starter.MiddlemanAPI.MiddlemanAPI;

public class GetIncomingOrdersAdminSteps {
    @Steps
    OrdersAPI ordersAPI;
    MiddlemanAPI middlemanAPI;
    @Given("set path for incoming order from admin")
    public void setPathForIncomingOrderFromAdmin() {
        ordersAPI.Getincomingorderadmin();
    }

    @When("Send request to get incoming order admin")
    public void sendRequestToGetIncomingOrderAdmin() {
        SerenityRest.when().post(middlemanAPI.ORDERS_ADMINS_INCOMING);
    }
}
