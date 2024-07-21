package starter.UserProducts;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.serenitybdd.rest.SerenityRest;
import org.junit.Assert;
import starter.MiddlemanAPI.MiddlemanAPI;
import starter.utils.Constants;

import java.io.File;

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

    @And("Send request to get product by search")
    public void sendRequestToGetProductBySearch() {
        SerenityRest.when()
                .get(middlemanAPI.USER_PRODUCT_SEARCH);
        String msg = SerenityRest.then().extract().body().asString();
        System.out.println(msg);
    }

    @Given("Set path for get product by search product name {string}")
    public void setPathForGetProductBySearchProductName(String stringNamProduct) {
        SerenityRest.given()
                .pathParam("stringNamProduct", stringNamProduct)
                .header("Authorization", "Bearer " + Constants.TOKEN_USER);

    }

    @Then("Extract body response")
    public void extractBodyResponse() {
        String msg = SerenityRest.then().extract().body().asString();
        System.out.println(msg);
    }

    @Given("Set path for add product and insert product data")
    public void setPathForAddProductAndInsertProductData() {
        File fileImage = new File(Constants.IMAGE_FOLDER + "Gambar1.png");
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.TOKEN_USER)
                .contentType("multipart/form-data")
                .multiPart("product_name", "Batu Aquarium")
                .multiPart("unit", "kg")
                .multiPart("stock", "1000")
                .multiPart("price", "1500")
                .multiPart("product_image", fileImage);
    }

    @And("Send request to add product")
    public void sendRequestToAddProduct() {
        SerenityRest.when()
                .post(middlemanAPI.USER_PRODUCT);
    }

    @Given("Set path for add product and insert incomplete product data")
    public void setPathForAddProductAndInsertIncompleteProductData() {
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.TOKEN_USER)
                .contentType("multipart/form-data")
                .multiPart("product_name", "Batu Aquarium")
                .multiPart("unit", "kg")
                .multiPart("stock", "1000")
                .multiPart("price", "1500");
    }

    @Given("Set path for update product with parameter id {int}")
    public void setPathForUpdateProductWithParameterId(int IntIdProduct) {
        File fileImage = new File(Constants.IMAGE_FOLDER + "Gambar1.png");
        SerenityRest
                .given()
                .pathParam("IntIdProduct", IntIdProduct)
                .header("Authorization", "Bearer " + Constants.TOKEN_USER)
                .contentType("multipart/form-data")
                .multiPart("product_name", "Product ini di update")
                .multiPart("unit", "kg")
                .multiPart("stock", "1000")
                .multiPart("price", "1500")
                .multiPart("product_image", fileImage);
    }

    @And("Send request to update product")
    public void sendRequestToUpdateProduct() {
        SerenityRest
                .when()
                .put(middlemanAPI.USER_UPDATE_PRODUCT);
    }

    @Then("Response body should be {string}")
    public void responseBodyShouldBe(String expectedMessage) {
        String actualMessage = SerenityRest.then().extract().jsonPath().getString("message");
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @Given("Set path for delete product id {int}")
    public void setPathForDeleteProductId(int IntIdProduct) {
        SerenityRest
                .given()
                .pathParam("IntIdProduct", IntIdProduct)
                .header("Authorization", "Bearer " + Constants.TOKEN_USER);
    }

    @And("Send request to delete product")
    public void sendRequestToDeleteProduct() {
        SerenityRest
                .when()
                .delete(middlemanAPI.USER_UPDATEorDELETE_PRODUCT);
    }
}
