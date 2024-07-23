package starter.AdminProductsSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import starter.Authentication.LoginAdminSteps;
import starter.MiddlemanAPI.MiddlemanAPI;
import starter.utils.Constants;

public class GetSteps {
    @Given("set path for get admin products")
    public void setPathForGetAdminProducts() {
        SerenityRest
                .given()
                .header("Authorization", "Bearer " + LoginAdminSteps.TOKEN_ADMIN);
    }

    @When("send request to get admin products")
    public void sendRequestToGetAdminProducts() {
        SerenityRest
                .when()
                .get(MiddlemanAPI.ADMIN_PRODUCT);
    }

    @Given("set path for get admin products name {string}")
    public void setPathForGetAdminProductsName(String stringNamProduct) {
        SerenityRest
                .given()
                .header("Authorization", "Bearer " + LoginAdminSteps.TOKEN_ADMIN)
                .pathParam("stringNamProduct", stringNamProduct);
    }

    @When("send request to get admin products by search")
    public void sendRequestToGetAdminProductsBySearch() {
        SerenityRest
                .when()
                .get(MiddlemanAPI.ADMIN_PRODUCT_SEARCH);
        String msg = SerenityRest.then().extract().body().asString();
        System.out.println(msg);
    }
}
