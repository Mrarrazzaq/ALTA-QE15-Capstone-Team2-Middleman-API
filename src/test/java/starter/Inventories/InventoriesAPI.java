package starter.Inventories;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Authentication.LoginAdminSteps;
import starter.Authentication.LoginUserSteps;
import starter.utils.Constants;

import java.io.File;

public class InventoriesAPI {


    @Step("Get all inventories user shop")
    public void Getinventoriesshop() {
        SerenityRest.given().header("Authorization", "Bearer " + LoginUserSteps.TOKEN_USER);
    }

    @Step("Detail invetories user shop")
    public void Detailinventoriesuser(int idinventory) {
        SerenityRest.given().header("Authorization", "Bearer " + LoginUserSteps.TOKEN_USER)
                .pathParam("id",idinventory);
    }

    @Step("Get all inventories admin")
    public void Getinventoriesadmin() {
        SerenityRest.given().header("Authorization", "Bearer " + LoginAdminSteps.TOKEN_ADMIN);
    }

    @Step("Detail invetories user admin")
    public void Detailinventoriesadmin(int idinventory) {
        SerenityRest.given().header("Authorization", "Bearer " + LoginAdminSteps.TOKEN_ADMIN)
                .pathParam("id",idinventory);
    }

    @Step("Post Create a form to list product (OUT)")
    public void Postinventoriesuser(File json){
        SerenityRest.given()
                .header("accept", "application/json")
                .contentType(ContentType.JSON)
                .header("Authorization","Bearer " + LoginUserSteps.TOKEN_USER)
                .body(json);
    }
    @Step("Post Create a form to list product (IN)")
    public void Postinventoriesadmin(File json){
        SerenityRest.given()
                .header("accept", "application/json")
                .contentType(ContentType.JSON)
                .header("Authorization","Bearer " + LoginAdminSteps.TOKEN_ADMIN)
                .body(json);
    }




}
