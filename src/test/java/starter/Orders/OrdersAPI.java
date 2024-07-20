package starter.Orders;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Carts.AuthStepsdef;
import starter.utils.Constants;

import java.io.File;

public class OrdersAPI {

    @Step("Post order user")
    public void Postorderuser(File json) {
        SerenityRest.given().header("Authorization", "Bearer " + Constants.TOKEN_USER);
        SerenityRest.given().contentType(ContentType.JSON).body(json);

    }
    @Step("Get all order user")
    public void Getallorderuser(){
        SerenityRest.given()
                .header("accept", "application/json")
                .header("Authorization","Bearer " + Constants.TOKEN_ADMIN);
    }
    @Step("Get all order admin")
    public void Getallorderadmin(){

        SerenityRest.given()
                .header("accept", "application/json")
                .header("Authorization","Bearer " + Constants.TOKEN_ADMIN);
    }

    @Step("Get Detail order user")
    public void Getdetailuser(int idorder){
        SerenityRest.given()
                .pathParam("idorder",idorder)
//                .header("accept", "application/json")
                .header("Authorization","Bearer " + Constants.TOKEN_USER);
    }
    @Step("Get Detail order user invalid id order")
    public void Getdetailuserinvalid(String idorder){
        SerenityRest.given()
                .pathParam("idorder",idorder)
                .header("accept", "application/json")
                .header("Authorization","Bearer " + Constants.TOKEN_ADMIN);
    }
    @Step("Get Detail order admin")
    public void Getdetailadmin(int idorder){
        SerenityRest.given().pathParam("idorder",idorder)
                .header("Authorization","Bearer" + AuthStepsdef.tokenAdmin);
    }

    @Step("Get incoming order admin")
    public void Getincomingorderadmin(){
        SerenityRest.given().header("Authorization","Bearer" + AuthStepsdef.tokenAdmin);
    }

    @Step("Put confirm order")
    public void putconfirmorder(int idorder) {
        SerenityRest.given()
                .pathParam("idorder", idorder)
                .header("accept", "application/json")
                .header("Authorization", "Bearer " + Constants.TOKEN_ADMIN);
    }
    @Step("Put finisih order")
    public void putfinisihorder(int idorder2){
        SerenityRest.given()
                .pathParam("idorder",idorder2)
                .header("Authorization", "Bearer " + Constants.TOKEN_ADMIN);


    }

}
