@LeadPage @Regression
Feature: Lead functionality

Background:
Given user should be on login page
When user enters valid userid and password and click on login button

@Sanity
Scenario Outline: TC04_Lead_creation_with_all_data
When user click on new lead link
Then create lead page should be open
When user select the salutation type , firstname, lastname, company, leadsource, mobile, city, state and click on save button
Then lead should be created successfully
Examples:
|Salutation | fname    | lname | company|leadsource | mobile     | city | state      | 
|Mr.        | Narendra | Modi  | BJP    | Call      | 8427111111 | pune | Maharastra | 


@run
Scenario: TC03_createLeadandAccount
When user click on new lead link
Then create lead page should be open
When user enters mandatory fields and click on save button
Then lead should be created successfully
