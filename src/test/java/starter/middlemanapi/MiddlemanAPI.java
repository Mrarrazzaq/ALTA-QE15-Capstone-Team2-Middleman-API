package starter.middlemanapi;

import utils.Constants;

public class MiddlemanAPI {

    public static String LOGIN = Constants.BASE_URL + "/login";
    public static String REGISTER = Constants.BASE_URL + "/register";
    public static String USERS = Constants.BASE_URL + "/users";
    public static String USERS_PRODUCTS = Constants.BASE_URL + "/users/products";
    public static String USERS_PRODUCTS_SEARCH = Constants.BASE_URL + "/users/products/search?{param}";
    public static String USERS_PRODUCTS_ID = Constants.BASE_URL + "/users/products/{id}";
    public static String ADMIN_PRODUCTS = Constants.BASE_URL + "/admins/products";
    public static String ADMIN_PRODUCTS_SEARCH = Constants.BASE_URL + "/admins/products/search";
    public static String ADMIN_PRODUCTS_ID = Constants.BASE_URL + "/admins/products/{id}";
    public static String CARTS = Constants.BASE_URL + "/carts";
    public static String CARTS_ID = Constants.BASE_URL + "/carts/{id}";
    public static String ORDERS = Constants.BASE_URL + "/orders/users";
    public static String ORDERS_ID = Constants.BASE_URL + "/orders/{id}";
    public static String ORDERS_ADMINS = Constants.BASE_URL + "/orders/admins";
    public static String ORDERS_ADMINS_INCOMING = Constants.BASE_URL + "/orders/admins/incoming";
    public static String ORDERS_CONFIRM = Constants.BASE_URL + "/orders/confirm/{id}";
    public static String ORDERS_DONE = Constants.BASE_URL + "/orders/done/{id}";
    public static String INOUTBOUNDS = Constants.BASE_URL + "/inoutbounds";
    public static String INOUTBOUNDS_ID = Constants.BASE_URL + "/inoutbounds/{id}";
    public static String USERS_INVENTORY = Constants.BASE_URL + "/users/inventory";
    public static String USERS_INVENTORY_ID = Constants.BASE_URL + "/users/inventory/{id}";
    public static String ADMINS_INVENTORY = Constants.BASE_URL + "/admins/inventory";
    public static String ADMINS_INVENTORY_ID = Constants.BASE_URL + "/admins/inventory/{id}";
}
