package pages;

import io.restassured.response.Response;
import org.json.JSONObject;

public class UserPage extends BasePage {
    
    public Response getUsers(int page) {
        return request
                .queryParam("page", page)
                .when()
                .get("/users");
    }

    public Response createUser(String name, String job) {
        JSONObject requestBody = new JSONObject();
        requestBody.put("name", name);
        requestBody.put("job", job);

        return request
                .body(requestBody.toString())
                .when()
                .post("/users");
    }

    public Response updateUser(int id, String name, String job) {
        JSONObject requestBody = new JSONObject();
        requestBody.put("name", name);
        requestBody.put("job", job);

        return request
                .body(requestBody.toString())
                .when()
                .put("/users/" + id);
    }

    public Response deleteUser(int id) {
        return request
                .when()
                .delete("/users/" + id);
    }
} 