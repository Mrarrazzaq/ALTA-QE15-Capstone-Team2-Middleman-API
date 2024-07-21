package starter.Inventories;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.MiddlemanAPI.MiddlemanAPI;


public class GetAllInventory {

    @Steps
    InventoriesAPI inventoriesAPI;

    @Given("Set path for get all product invetory shop")
    public void setPathForGetAllProductInvetoryShop() {
        inventoriesAPI.Getinventoriesshop();
    }

    @When("Send request to get all product inventory shop")
    public void sendRequestToGetAllProductInventoryShop() {
        SerenityRest.given().get(MiddlemanAPI.USERS_INVENTORY);
    }

    @Given("Set path for get all product invetory admin")
    public void setPathForGetAllProductInvetoryAdmin() {
        inventoriesAPI.Getinventoriesadmin();
    }

    @When("Send request to get all product inventory admin")
    public void sendRequestToGetAllProductInventoryAdmin() {
        SerenityRest.given().get(MiddlemanAPI.ADMINS_INVENTORY);
    }

}
