Feature: Renewal after Reinstatement
Scenario: Renew with Reinstate
Given User login as Internal user
When User will navigate to IRP 
Then User will navigate to renew fleet and search for  Reinstated Account Number
Then User should navigate to Account screen and provides all the required input to proceed 
Then user should navigate to Account verification screen and proceed further
Then user should navigate to Fleet  screen and update Fleet Expiration Date & Fleet Type & Commodity Class and proceed further
Then user should navigate to Fleet verification screen and proceed further
Then user should land on Distance screen and select Estimated Distance and proceed further
Then user should navigate to Distance verification screen and proceed further
Then user should land on the Weight Group screen and go for Add Weight group
Then user should land on the Add Weight Group screen and provide all the required input to proceed
Then user should land on the Add Weight Group Verification screen and go for  Weight group
Then user should land on the Weight Group and edit the existing weight group to proceed to Vehicle screen
Then user should land on the Vehicle Screen and 




Then user should land on the Billing screen with open status and Request for TVR & set Delivery Type as PDF with Comments 
And system calculates Fee and user change the supplement status as invoiced 
And system should calculates the In-state fee and Fees should be waived/overridden for some vehicles.
And user should check Installment payment and should be selected and proceed further
Then system should generate PDF and should go to Payment Init screen.
Then user should verify the screen and set Delivery Types as PDF & proceed further
Then user should land on the Payment Init Verification screen & click on Pay Now
Then user should land on the Payment Collection page
And user select multiple payment types and select PDF delivery type & clicks Paynow
Then payment receipt should get generated & Hard stop message should get displayed
