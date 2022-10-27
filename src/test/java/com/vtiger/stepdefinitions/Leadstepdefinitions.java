package com.vtiger.stepdefinitions;

import com.vtiger.pages.HomePage;
import com.vtiger.pages.LeadPage;
import com.vtiger.pages.LoginPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Leadstepdefinitions extends BaseStepDefinitions {

	HomePage hp;
	LeadPage lp;
	
		
	@Before
	public void before(Scenario scenario) {
	    this.scenario = scenario;
	}
	
	@After
	public void after()
	{
		extent.flush();
		driver.quit();
	}
	
	@When("user enters mandatory fields and click on save button")
	public void user_enters_mandatory_fields_and_click_on_save_button() {
		lp.createlead(TestData.get(TCName).get("FirstName"), TestData.get(TCName).get("LastName"), TestData.get(TCName).get("Company"));
	}
	
	@When("user click on new lead link")
	public void user_click_on_new_lead_link() {
		
		hp = new HomePage(driver,logger);
		hp.ClickNewLead();
		lp = new LeadPage(driver,logger);
		
	   
	}
	@Then("create lead page should be open")
	public void create_lead_page_should_be_open() {
		System.out.println("create lead page should be open");
	}
	@When("user select the salutation type , firstname, lastname, company, leadsource, mobile, city, state and click on save button")
	public void user_select_the_salutation_type_firstname_lastname_company_leadsource_mobile_city_state_and_click_on_save_button() {
		System.out.println("user select the salutation type , firstname,");
	}
	@Then("lead should be created successfully")
	public void lead_should_be_created_successfully() {
		System.out.println("lead should be created successfully");
	}


}
