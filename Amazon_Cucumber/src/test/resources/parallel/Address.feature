Feature: Adding address and validate all field

  
  #Scenario:  Address validating and adding
  #Given user login the application
  #And user bypassing the mandate fields of the address to place the order
  #Then User Adding the current address
  Scenario: Address validating and adding
    Given user login the application
    And user navigates Account page
    Then user should be on account page
    When user click on your address
    Then user should be your address page
    When user clicks on add address button
    Then user should be on add new address page
    When user clicks on add address button on new address page
    Then user should see error messages for mandatory fileds
     When user enters data for address
     