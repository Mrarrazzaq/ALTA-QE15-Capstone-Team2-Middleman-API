package starter.Orders;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Carts.CartAPI;
import starter.MiddlemanAPI.MiddlemanAPI;

public class GetOrdersSteps {
    @Steps
    OrdersAPI ordersAPI;
    MiddlemanAPI middlemanAPI;
    @Given("Set path for get all history order user")
    public void setPathForGetAllHistoryOrderUser() {
        ordersAPI.Getallorderuser();

    }

    @When("Send request to get all history order")
    public void sendRequestToGetAllHistoryOrder() {
        SerenityRest.when().get(middlemanAPI.ORDERS);
        if (SerenityRest.then().extract().statusCode() != 200) {
            System.out.println("Error response: " + SerenityRest.then().extract().body().asString());
        }
    }

    @Given("Set path for get all history order admin")
    public void setPathForGetAllHistoryOrderAdmin() {
        ordersAPI.Getallorderadmin();
    }

    @When("Send request to get all history order admin")
    public void sendRequestToGetAllHistoryOrderAdmin() {
        SerenityRest.when().get(middlemanAPI.ORDERS_ADMINS);
        if (SerenityRest.then().extract().statusCode() != 200) {
            System.out.println("Error response: " + SerenityRest.then().extract().body().asString());
        }
    }
}