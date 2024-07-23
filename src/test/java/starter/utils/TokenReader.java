package starter.utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class TokenReader {
    private static final String TOKEN_FILE_PATH = Constants.REQ_BODY + "token.json";
    private static final String TOKEN_FILE_PATH2 = Constants.REQ_BODY + "tokenAdmin.json";


    public static String getTokenUser() {
        JSONParser parser = new JSONParser();
        String token = null;

        try (FileReader reader = new FileReader(TOKEN_FILE_PATH)) {
            Object obj = parser.parse(reader);
            JSONObject jsonObject = (JSONObject) obj;
            token = (String) jsonObject.get("token");
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return token;
    }

    public static String getTokenAdmin() {
        JSONParser parser = new JSONParser();
        String token = null;

        try (FileReader reader = new FileReader(TOKEN_FILE_PATH2)) {
            Object obj = parser.parse(reader);
            JSONObject jsonObject = (JSONObject) obj;
            token = (String) jsonObject.get("token");
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return token;
    }

    public static void main(String[] args) {
        String token = getTokenUser();
        if (token != null) {
            System.out.println("Token: " + token);
        } else {
            System.out.println("Failed to read token.");
        }
    }
}