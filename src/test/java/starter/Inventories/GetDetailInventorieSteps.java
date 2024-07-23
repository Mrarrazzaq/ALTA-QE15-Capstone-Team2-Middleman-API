package starter.Inventories;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.MiddlemanAPI.MiddlemanAPI;

public class GetDetailInventorieSteps {
    @Steps
    InventoriesAPI inventoriesAPI;
    @Given("Get detailed product from inventory by user and set parameter to {int}")
    public void getDetailedProductFromInventoryByUserAndSetParameterTo(int idinventory) {
        inventoriesAPI.Detailinventoriesuser(idinventory);
    }

    @When("Send request get detailed product from inventory id")
    public void sendRequestGetDetailedProductFromInventoryId() {
        SerenityRest.when().get(MiddlemanAPI.USERS_INVENTORY_ID);
    }

    @Given("Get detailed product from inventory by admin and set parameter to {int}")
    public void getDetailedProductFromInventoryByAdminAndSetParameterTo(int idinventory) {
        inventoriesAPI.Detailinventoriesadmin(idinventory);
    }

    @When("Send request get detailed product from inventory id for admin")
    public void sendRequestGetDetailedProductFromInventoryIdForAdmin() {
        SerenityRest.when().get(MiddlemanAPI.ADMINS_INVENTORY_ID);
    }
}
