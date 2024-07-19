package starter.Orders;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

public class PutConfirmOrderSteps {
    @Steps
    OrdersAPI ordersAPI;
    @Given("update confirm order by admin with valid id {int}")
    public void updateConfirmOrderByAdminWithValidIdValidid(int id) {
        ordersAPI.putconfirmorder(id);
    }

    @When("send request put update confirm order")
    public void sendRequestPutUpdateConfirmOrder() {
        SerenityRest.when().post(OrdersAPI.ORDERS_CONFIRM);
    }


}
