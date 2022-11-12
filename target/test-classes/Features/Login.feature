@LoginFeature @Regression
Feature: Login functionality

Background:
Given user should be on login page

@invalidLogin
Scenario Outline: TC01_InvalidLogin
When user enters invalid userid as "<userid>" and password as "<password>" and click on login button
Then user can see the error message
Examples:
|userid | password |
|ad1111| pass123 |
|ad2222| pass3333|
|ad3333| pas222211|

@Sanity
Scenario: TC02_validLogin
When user enters valid userid and password and click on login button
Then user should be navigated to home page
And logout link should be appear on right coner on the home page