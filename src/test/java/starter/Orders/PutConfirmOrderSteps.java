package starter.Orders;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.MiddlemanAPI.MiddlemanAPI;

public class PutConfirmOrderSteps {
    @Steps
    OrdersAPI ordersAPI;
    MiddlemanAPI middlemanAPI;
    @Given("update confirm order by admin with valid id {int}")
    public void updateConfirmOrderByAdminWithValidIdValidid(int id) {
        ordersAPI.putconfirmorder(id);
    }

    @When("send request put update confirm order")
    public void sendRequestPutUpdateConfirmOrder() {
        SerenityRest.when().put(middlemanAPI.ORDERS_CONFIRMS);
        if (SerenityRest.then().extract().statusCode() != 200) {
            System.out.println("Error response: " + SerenityRest.then().extract().body().asString());
        }
    }


}
