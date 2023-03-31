package endpoints;

import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.Basic;
import utils.RequestMethods;

import static io.restassured.RestAssured.given;

public class Comments extends Basic {
    private static final String COMMENTS_URL = BASE_URL.concat("comments/");

    // GET Comments
    public Response GETComments() {
        return new RequestMethods().getRequest(Comments(), COMMENTS_URL);
    }

    private RequestSpecification Comments() {
        return given();
    }

    // Add new comment
    public Response AddComment() {
        return new RequestMethods().postRequest(CreateComment(), COMMENTS_URL);
    }

    private RequestSpecification CreateComment() throws JsonParseException {
        String jsonBody = "{\r\n" +
                "  \"name\": \"Test\",\r\n" +
                "  \"email\": \"test@test.de\",\r\n" +
                "  \"body\": \"Test long body string\"\r\n" +
                "}";

        JsonObject requestParams = JsonParser.parseString(jsonBody).getAsJsonObject();

        return given().
                body(requestParams).log().all();
    }

    // Delete comment
    public Response RemoveComment(String commentId) {
        return new RequestMethods().deleteRequest(DeleteComment(), COMMENTS_URL.concat(commentId));
    }

    private RequestSpecification DeleteComment() {
        return given();
    }
}
