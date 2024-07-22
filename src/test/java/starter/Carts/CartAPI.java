package starter.Carts;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Authentication.LoginUserSteps;
import starter.MiddlemanAPI.MiddlemanAPI;
import starter.utils.Constants;
import java.io.File;
import static starter.Carts.AuthStepsdef.token;

public class CartAPI {

    MiddlemanAPI middlemanAPI;
    @Step("Get to cart")
    public void Getcarts(){
        SerenityRest.given()
                .header("accept", "application/json")
                .header("Authorization","Bearer " + LoginUserSteps.TOKEN_USER);
    }

    @Step("Post crate cart")
    public void Postcarts(File json){
        SerenityRest.given()
                .header("accept", "application/json")
                .contentType(ContentType.JSON)
                .header("Authorization","Bearer " +LoginUserSteps.TOKEN_USER)
                .body(json);
    }

    @Step("Update cart")
    public void Updatecarts(int id, File json){

        SerenityRest.given()
                .given().pathParam("id",id)
                .header("Authorization","Bearer " + LoginUserSteps.TOKEN_USER)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Delete cart")
    public void Deletecart(int id){
        SerenityRest.given()
                .pathParam("id",id)
                .header("Authorization","Bearer " + LoginUserSteps.TOKEN_USER);
    }
    @Step("Post crate order")
    public void Postorder(File json){
        SerenityRest.given().header("Authorization","Bearer" + AuthStepsdef.token);
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }


}
