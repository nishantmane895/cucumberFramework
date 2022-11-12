@LoginFeature @Regression
Feature: API functionality



@api
Scenario: ListUsers_TC01
Given user should have endpoint url
When user send the get request with data
Then User will get the response
And response contains status code,email and page value
