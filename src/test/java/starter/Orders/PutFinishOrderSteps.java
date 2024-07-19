package starter.Orders;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

public class PutFinishOrderSteps {
    @Steps
    OrdersAPI ordersAPI;
    @Given("update finish order by admin with valid id {int}")
    public void updateFinishOrderByAdminWithValidIdValidid(int id) {
        ordersAPI.putfinisihorder(id);

    }

    @When("send request put update finish order")
    public void sendRequestPutUpdateFinishOrder() {
        SerenityRest.when().post(OrdersAPI.ORDERS_FINISH);
    }
}
