package com.vtiger.stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.vtiger.pages.HomePage;
import com.vtiger.pages.LoginPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Loginstepdefinition extends BaseStepDefinitions {
	LoginPage lp;
	HomePage hp;
	
		
	@Before
	public void before(Scenario scenario) {
	    this.scenario = scenario;
	}
	
	@After
	public void after()
	{
		extent.flush();
		
	}
	@Given("user should be on login page")
	public void user_should_be_on_login_page() {
		init();		
		logger = extent.createTest(scenario.getName());
		TCName = scenario.getName();
		lp = new LoginPage(driver,logger);
		hp = new HomePage(driver,logger);
	}
	@When("user enters valid userid and password and click on login button")
	public void user_enters_valid_userid_and_password_and_click_on_login_button() {
	   lp.login(TestData.get(TCName).get("Userid"),TestData.get(TCName).get("Password"));
	}
	@Then("user should be navigated to home page")
	public void user_should_be_navigated_to_home_page() {
	  
	   hp.verifyLogout();
	   
	}
	@Then("logout link should be appear on right coner on the home page")
	public void logout_link_should_be_appear_on_right_coner_on_the_home_page() {
		
		hp.ClickLogout();
	}
	
	@When("user enters invalid userid and password and click on login button")
	public void user_enters_invalid_userid_and_password_and_click_on_login_button() {
		 lp.login(TestData.get(TCName).get("Userid"),TestData.get(TCName).get("Password"));
	}
	@Then("user can see the error message")
	public void user_can_see_the_error_message() {
	  
	   lp.verifyErrorMsg();
	}
	
	@When("user enters invalid userid as {string} and password as {string} and click on login button")
	public void user_enters_invalid_userid_as_and_password_as_and_click_on_login_button(String user, String pwd) {
		lp.login(user, pwd);
	}




}
