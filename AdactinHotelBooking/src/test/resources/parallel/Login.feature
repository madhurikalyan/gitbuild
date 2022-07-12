Feature: Login Page Feature

Scenario: login page
Given user is on login page
Then forgot your password link should be displayed

Scenario: Login with correct credentials
Given user is on login page
When user enter Username 
And user enter Password 
And user click on login button