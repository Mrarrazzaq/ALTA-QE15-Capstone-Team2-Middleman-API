package starter.Carts;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import starter.Authentication.LoginAdminSteps;
import starter.MiddlemanAPI.MiddlemanAPI;
import starter.utils.Constants;

import java.io.File;

public class PostSteps {

    MiddlemanAPI middlemanAPI;
    @Given("Set path for add new product with file json {string}")
    public void setPathForAddNewProductWithFileJson(String arg0) {
    }

    @When("send request add new product")
    public void sendRequestAddNewProduct() {
        SerenityRest
                .when()
                .post(middlemanAPI.ADMIN_PRODUCT);
    }

    @Given("Set path for add admin product and insert product data")
    public void setPathForAddAdminProductAndInsertProductData() {
        File fileImage = new File(Constants.IMAGE_FOLDER + "Gambar1.png");
        SerenityRest.given()
                .header("Authorization", "Bearer " + LoginAdminSteps.TOKEN_ADMIN)
                .contentType("multipart/form-data")
                .multiPart("product_name", "Batuuu")
                .multiPart("unit", "kg")
                .multiPart("stock", "1000")
                .multiPart("price", "1500")
                .multiPart("product_image", fileImage);
    }

    @Given("Set path for add product and insert invalid product data")
    public void setPathForAddProductAndInsertInvalidProductData() {
        SerenityRest.given()
                .header("Authorization", "Bearer " + LoginAdminSteps.TOKEN_ADMIN)
                .contentType("multipart/form-data")
                .multiPart("product_name", "Batu Aquarium")
                .multiPart("unit", "kg")
                .multiPart("stock", "1000")
                .multiPart("price", "1500");
    }
}
