package starter.Orders;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.MiddlemanAPI.MiddlemanAPI;

public class PutFinishOrderSteps {
    @Steps
    OrdersAPI ordersAPI;
    MiddlemanAPI middlemanAPI;
    @Given("update finish order by admin with valid id {int}")
    public void updateFinishOrderByAdminWithValidIdValidid(int id) {
        ordersAPI.putfinisihorder(id);

    }

    @When("send request put update finish order")
    public void sendRequestPutUpdateFinishOrder() {
        SerenityRest.when().put(middlemanAPI.ORDERS_DONE);
        if (SerenityRest.then().extract().statusCode() != 200) {
            System.out.println("Error response: " + SerenityRest.then().extract().body().asString());
        }
    }
}
