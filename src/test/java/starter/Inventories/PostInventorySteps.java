package starter.Inventories;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.MiddlemanAPI.MiddlemanAPI;
import starter.utils.Constants;

import java.io.File;

public class PostInventorySteps {

    @Steps
    InventoriesAPI inventoriesAPI;

    @Given("Post create product with valid request body {string}")
    public void postCreateProductWithValidRequestBody(String filename) {
        File jsonfile = new File(Constants.REQ_BODY + filename);
        inventoriesAPI.Postinventoriesuser(jsonfile);

    }

    @When("Send request post inventory")
    public void sendRequestPostInventory() {
        SerenityRest.given().post(MiddlemanAPI.USERS_INVENTORY);
    }


    @Given("Post create product admin with valid request body {string}")
    public void postCreateProductAdminWithValidRequestBody(String filename) {
        File jsonfile = new File(Constants.REQ_BODY + filename);
        inventoriesAPI.Postinventoriesadmin(jsonfile);
    }

    @When("Send request post inventory admin")
    public void sendRequestPostInventoryAdmin() {
        SerenityRest.given().post(MiddlemanAPI.ADMINS_INVENTORY);
    }
}
