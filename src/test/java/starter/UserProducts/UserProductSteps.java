package starter.UserProducts;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import net.serenitybdd.rest.SerenityRest;
import starter.MiddlemanAPI.MiddlemanAPI;
import starter.utils.Constants;

public class UserProductSteps {

    MiddlemanAPI middlemanAPI;
    @Given("Set path for get user products")
    public void setPathForGetUserProducts() {
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.TOKEN_USER);
    }

    @And("Send request to get user products")
    public void sendRequestToGetUserProducts() {
        SerenityRest.when()
                .get(middlemanAPI.USER_PRODUCT);
        if (SerenityRest.then().extract().statusCode() != 404) {
            System.out.println("Error response: " + SerenityRest.then().extract().body().asString());
        }
    }

    @Given("Set path for get product by search")
    public void setPathForGetProductBySearch() {
    }

    @And("Send request to get product by search")
    public void sendRequestToGetProductBySearch() {
    }
}
