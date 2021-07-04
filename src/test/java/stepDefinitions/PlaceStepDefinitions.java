package stepDefinitions;

import Utils.RequestResponseSpecBuilder;
import data.TestDataBuilder;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static org.junit.Assert.assertEquals;

public class PlaceStepDefinitions {
    RequestSpecification requestSpecification;
    TestDataBuilder data = new TestDataBuilder();
    Response response;

    @Given("Add Place payload")
    public void add_place_payload() {
        requestSpecification = RequestResponseSpecBuilder.getRequestSpec();
    }

    @When("User calls {string} api with post request")
    public void user_calls_api_with_post_request(String api) {
        response = RestAssured.given()
                .spec(requestSpecification)
                .body(data.getPostUserData())
                .when()
                .post("/api/users")
                .then()
                .extract()
                .response();
    }

    @Then("API call should be successful with status code {int}")
    public void api_call_should_be_successful_with_status_code(int statusCode) {
        assertEquals(statusCode, response.statusCode());
    }

    @Then("{string} in status response should be {string}")
    public void in_status_response_should_be(String param, String value) {
        JsonPath jsonPath = new JsonPath(response.asString());
        assertEquals(value, jsonPath.getString(param));
    }
}
