package starter.Orders;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Carts.AuthStepsdef;
import utils.Constants;

import java.io.File;

public class OrdersAPI {
    public static String ORDERS_USER = Constants.BASE_URL + "/orders/users";
    public static String ORDERS_DETAIL = Constants.BASE_URL + "/orders/{idorder}";
    public static String ORDERS_ADMIN = Constants.BASE_URL + "/orders/admins";
    public static String ORDERS_ADMIN_INCOMMING = Constants.BASE_URL + "/orders/admins/incoming";
    public static String ORDERS_CONFIRM = Constants.BASE_URL + "/orders/confirm/{idorder}";
    public static String ORDERS_FINISH = Constants.BASE_URL + "/orders/done/{idorder}";


    @Step("Post order user")
    public void Postorderuser(File json) {
        SerenityRest.given().header("Authorization", "Bearer" + AuthStepsdef.token);
        SerenityRest.given().contentType(ContentType.JSON).body(json);

    }
    @Step("Get all order user")
    public void Getallorderuser(){

        SerenityRest.given().header("Authorization","Bearer" + AuthStepsdef.token);
    }
    @Step("Get all order admin")
    public void Getallorderadmin(){

        SerenityRest.given().header("Authorization","Bearer" + AuthStepsdef.token);
    }

    @Step("Get Detail order user")
    public void Getdetailuser(int idorder){
        SerenityRest.given().pathParam("idorder",idorder)
                .header("Authorization","Bearer" + AuthStepsdef.token);
    }
    @Step("Get Detail order user invalid id order")
    public void Getdetailuserinvalid(String idorder){
        SerenityRest.given().pathParam("idorder",idorder)
                .header("Authorization","Bearer" + AuthStepsdef.token);
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
        SerenityRest.given().pathParam("idorder", idorder).header("Authorization", "Bearer" + AuthStepsdef.tokenAdmin);
    }
    @Step("Put finisih order")
    public void putfinisihorder(int idorder2){
        SerenityRest.given().pathParam("idorder",idorder2).header("Authorization", "Bearer" + AuthStepsdef.tokenAdmin);


    }

}
