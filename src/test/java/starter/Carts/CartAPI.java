package starter.Carts;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import utils.Constants;

import java.io.File;

import static starter.Carts.AuthStepsdef.token;

public class CartAPI {
    public static String CARTS = Constants.BASE_URL + "/carts";
    public static String CARTS_ID = Constants.BASE_URL + "/carts/{id}";


    @Step("Get to cart")
    public void Getcarts(){
        SerenityRest.given().header("Authorization","Bearer" + AuthStepsdef.token);
    }

    @Step("Post crate cart")
    public void Postcarts(File json){
        SerenityRest.given().header("Authorization","Bearer" + AuthStepsdef.token);
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }

}
