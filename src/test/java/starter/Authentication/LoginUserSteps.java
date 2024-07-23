package starter.Authentication;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import net.serenitybdd.rest.SerenityRest;
import starter.MiddlemanAPI.MiddlemanAPI;
import starter.utils.Constants;

import org.json.simple.JSONObject;
import starter.utils.TokenReader;

import java.io.FileWriter;
import java.io.IOException;

public class LoginUserSteps {
    public static String TOKEN_USER = TokenReader.getTokenUser();
    MiddlemanAPI middlemanAPI;


    @Given("Set path for login user")
    public void setPathForLoginUser() {
        SerenityRest.given()
                .when()
                .get(middlemanAPI.LOGIN);
    }

    @And("User enter email {string} and password {string}")
    public void userEnterEmailAndPassword(String email, String password) {
        SerenityRest.given()
                .formParam("email", email)
                .formParam("password", password);
    }

    @And("User click login button")
    public void userClickLoginButton() {
        SerenityRest.when().post(middlemanAPI.LOGIN);
//        Response response = SerenityRest.when().post(MiddlemanAPI.LOGIN);
//        JsonPath jsonPathEvaluator = response.jsonPath();
//        TOKEN_USER = jsonPathEvaluator.get("data.token");
        if (SerenityRest.then().extract().statusCode() != 200) {
            System.out.println("Error response: " + SerenityRest.then().extract().body().asString());
        }
    }

    @And("status code user should be {int}")
    public void statusCodeUserShouldBe(int Expected) {
        SerenityRest.then().statusCode(Expected);
        String tokenUser = SerenityRest.then().extract().jsonPath().getString("data.token");
        System.out.println(tokenUser);
        // Create a JSON object to store the token
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("token", tokenUser);

        // Define the file path
        String filePath = Constants.REQ_BODY + "token.json";

        // Write the JSON object to the file
        try (FileWriter file = new FileWriter(filePath)) {
            file.write(jsonObject.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
