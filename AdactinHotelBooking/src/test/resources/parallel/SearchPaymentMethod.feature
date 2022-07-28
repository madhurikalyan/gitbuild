Feature: Payment Method Page Feature from JSON File

Background:
Given user has already logged in to application



Scenario: Adding Payment Method
Given user navigate to Payment method process
When user enter first name 
And user enter last name 
Then user enter billing address
Then user enter Credit card no
Then user enter Credit card type
Then user enter expiry data 
Then user enter expriy data
And user enter Cvv number
Then user click on Book now tab

Then user click on logout