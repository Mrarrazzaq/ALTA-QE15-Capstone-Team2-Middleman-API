package starter.Carts;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import starter.Authentication.LoginAdminSteps;
import starter.MiddlemanAPI.MiddlemanAPI;
import starter.utils.Constants;

public class DeleteSteps {
    @Given("Set path for delete product by product id {int}")
    public void setPathForDeleteProductByProductId(int IntIdProduct) {
        SerenityRest
                .given()
                .pathParam("IntIdProduct", IntIdProduct)
                .header("Authorization","Bearer " + LoginAdminSteps.TOKEN_ADMIN);
    }

    @When("Send request to delete admin product")
    public void sendRequestToDeleteAdminProduct() {
        SerenityRest
                .when()
                .delete(MiddlemanAPI.ADMIN_UPDATEorDELETE_PRODUCT);
    }
}
