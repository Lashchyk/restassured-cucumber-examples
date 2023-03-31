package utils;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RequestMethods {
    public Response getRequest(RequestSpecification requestSpecification, String requestPath) {
        return requestSpecification.given()
                .when()
                .log().all()
                .get(requestPath)
                .then()
                .log().body()
                .extract()
                .response();
    }

    public Response postRequest(RequestSpecification requestSpecification, String requestPath) {
        return requestSpecification.given()
                .when()
                .log().all()
                .post(requestPath)
                .then()
                .log().body()
                .extract()
                .response();
    }

    public Response deleteRequest(RequestSpecification requestSpecification, String requestPath) {
        return requestSpecification.given()
                .when()
                .log().all()
                .delete(requestPath)
                .then()
                .log().body()
                .extract()
                .response();
    }
}
