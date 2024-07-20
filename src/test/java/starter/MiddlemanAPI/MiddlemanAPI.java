package starter.MiddlemanAPI;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

import java.io.File;

public class MiddlemanAPI {
    //Authentication
    public static String LOGIN = Constants.BASE_URL+"login";
    public static String REGISTER = Constants.BASE_URL+"register";

    //User
    public static String USER_PROFILE = Constants.BASE_URL+"users";
    public static String USER_UPDATE = Constants.BASE_URL+"users/{IntIdUser}";
    public static String USER_DELETE = Constants.BASE_URL+"users/{IntIdUser}";

    //User Product
    public static String USER_PRODUCT = Constants.BASE_URL+"users/products";
    public static String USER_PRODUCT_SEARCH = Constants.BASE_URL+"users/products/search?productname={stringNamProduct}";
    public static String USER_UPDATE_PRODUCT = Constants.BASE_URL+"users/products/{IntIdProduct}";
    public static String USER_UPDATEorDELETE_PRODUCT = Constants.BASE_URL+"users/products/{IntIdProduct}";

    //Admin Product
    public static String ADMIN_PRODUCT = Constants.BASE_URL+"admins/products";
    public static String ADMIN_PRODUCT_SEARCH = Constants.BASE_URL+"admins/products/search?productname={stringNamProduct}";
    public static String ADMIN_UPDATEorDELETE_PRODUCT = Constants.BASE_URL+"admins/products/{IntIdProduct}";

    //Carts
    public static String CARTS = Constants.BASE_URL + "carts";
    public static String CARTS_ID = Constants.BASE_URL + "carts/{id}";
    public static String ORDERS = Constants.BASE_URL + "orders/users";
    public static String ORDERS_ID = Constants.BASE_URL + "orders/{id}";
    public static String ORDERS_ADMINS = Constants.BASE_URL + "orders/admins";
    public static String ORDERS_ADMINS_INCOMING = Constants.BASE_URL + "orders/admins/incoming";
    public static String ORDERS_CONFIRM = Constants.BASE_URL + "orders/confirm/{id}";
    public static String ORDERS_CONFIRMS = Constants.BASE_URL + "orders/confirm/{idorder}";
    public static String ORDERS_DONE = Constants.BASE_URL + "orders/done/{idorder}";
    public static String INOUTBOUNDS = Constants.BASE_URL + "inoutbounds";
    public static String INOUTBOUNDS_ID = Constants.BASE_URL + "inoutbounds/{id}";
    public static String USERS_INVENTORY = Constants.BASE_URL + "users/inventory";
    public static String USERS_INVENTORY_ID = Constants.BASE_URL + "users/inventory/{id}";
    public static String ADMINS_INVENTORY = Constants.BASE_URL + "admins/inventory";
    public static String ADMINS_INVENTORY_ID = Constants.BASE_URL + "admins/inventory/{id}";



}