Feature: Renew Fleet feature
Scenario: IRP Renew fleet
Given User login as Internal user
When User will navigate to IRP 
Then User will navigate to renew fleet and input all the details
Then User will add, amend or delete vehicle as per the requirement
Then User will navigate to billing to verify as well to adjust the cost
And User will navigate to payment
Then User will assign the inventory

