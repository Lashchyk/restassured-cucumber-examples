package stepDefinition;

import endpoints.Comments;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertEquals;

public class CommentsSteps {
    private Response response;

    @When("User retrieves all the comments")
    public void getComments() {
        response = new Comments().GETComments();
    }

    @When("User creates new comment")
    public void addComment() {
        response = new Comments().AddComment();
    }

    @When("User deletes existing comment with id {string}")
    public void deleteComment(String commentId) {
        response = new Comments().RemoveComment(commentId);
    }

    @Then("Response code is {int}")
    public void responseCode(int code) {
        assertEquals(code, response.getStatusCode());
    }

    @Then("Response includes {string} key")
    public void matchKey(String field) {
        response.then().assertThat().body(field, notNullValue());
    }
}
