package starter.Inoutbounds;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Authentication.LoginUserSteps;
import starter.utils.Constants;

import java.io.File;

public class InoutboundSteps {


    @Step("Get inoutbound")
    public void Getinoutbound(){
        SerenityRest.given().header("Authorization","Bearer " + LoginUserSteps.TOKEN_USER);
    }

    @Step("Post Create new cart for stock user (out) and admin (in)")
    public void Postinoutbound(File json){
        SerenityRest.given()
                .header("accept", "application/json")
                .contentType(ContentType.JSON)
                .header("Authorization","Bearer " + LoginUserSteps.TOKEN_USER)
                .body(json);
    }

    @Step("Update quantity product in carts for stock user (out) and admin (in)")
    public void Updateinoutbound(int id, File json){
        SerenityRest.given()
                .given().pathParam("id",id)
                .header("Authorization","Bearer " + LoginUserSteps.TOKEN_USER)
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Update quantity product in carts for stock user (out) and admin (in)")
    public void Updateinoutboundinvalid(String id, File json){
        SerenityRest.given()
                .given().pathParam("id",id)
                .header("Authorization","Bearer " + LoginUserSteps.TOKEN_USER)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Delete user inbound product by valid id")
    public void Deleteinoutbound(int id){
        SerenityRest.given().pathParam("id",id).header("Authorization","Bearer " + LoginUserSteps.TOKEN_USER);
    }
}
