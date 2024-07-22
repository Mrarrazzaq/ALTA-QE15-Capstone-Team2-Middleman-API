package starter.AdminProductsSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import starter.Authentication.LoginAdminSteps;
import starter.MiddlemanAPI.MiddlemanAPI;
import starter.utils.Constants;

import java.io.File;

public class PutSteps {
    @Given("Set path for update product")
    public void setPathForUpdateProduct() {
        SerenityRest
                .given()
                .header("Authorization", "Bearer " + LoginAdminSteps.TOKEN_ADMIN);
    }

    @And("Send request update product")
    public void sendRequestUpdateProduct() {
        SerenityRest
                .when()
                .put(MiddlemanAPI.ADMIN_UPDATEorDELETE_PRODUCT);
    }

    @Given("Set path for admin update product with parameter id {int}")
    public void setPathForAdminUpdateProductWithParameterId(int IntIdProduct) {
        File fileImage = new File(Constants.IMAGE_FOLDER + "Gambar1.png");
        SerenityRest
                .given()
                .pathParam("IntIdProduct", IntIdProduct)
                .header("Authorization", "Bearer " + LoginAdminSteps.TOKEN_ADMIN)
                .contentType("multipart/form-data")
                .multiPart("product_name", "Vacum")
                .multiPart("unit", "pcs")
                .multiPart("stock", "1000")
                .multiPart("price", "1500")
                .multiPart("product_image", fileImage);
    }
}
