package com.vtiger.stepdefinitions;

import com.vtiger.pages.APIPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class APIstepdefinitions extends BaseStepDefinitions {
	
	Response resp;
	String Endpoint;
	APIPage api;
	
	@Before
	public void before(Scenario scenario) {
	    this.scenario = scenario;
	}
	
	@After
	public void after()
	{
		extent.flush();
		
	}
	
	@Given("user should have endpoint url")
	public void user_should_have_endpoint_url() {
		init();		
		logger = extent.createTest(scenario.getName());
		TCName = scenario.getName();		
		api = new APIPage(logger);
		Endpoint = prop.getProperty("ApiEndPoint")+TestData.get(TCName).get("QueryString");
	   
	}

	@When("user send the get request with data")
	public void user_send_the_get_request_with_data() {
		 resp = RestAssured.get(Endpoint);
	}

	@Then("User will get the response")
	public void user_will_get_the_response() {
		api.writeRequestResponseinReport(Endpoint, resp.body().asPrettyString());		
	}

	@Then("response contains status code,email and page value")
	public void response_contains_status_code_email_and_page_value() {
		api.verifyStatusLine(TestData.get(TCName).get("StatusLine"), resp.getStatusLine());
		String json = resp.body().asPrettyString();
		JsonPath jsonPath = new JsonPath(json);
		String id	 = jsonPath.getString("data.id");		
		api.verifyJsonResponse(TestData.get(TCName).get("id"),id);
		api.verifyJsonResponse(TestData.get(TCName).get("email"),jsonPath.getString("data.email"));
		api.verifyJsonResponse(TestData.get(TCName).get("first_name"),jsonPath.getString("data.first_name"));
		api.verifyJsonResponse(TestData.get(TCName).get("last_name"),jsonPath.getString("data.last_name"));
	}


}
