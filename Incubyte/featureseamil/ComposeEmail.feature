
Feature: To test the compose function in Gmail 
  
  Scenario: To test the compose function in Gmail
    Given User Open Chrome and Nevigate to gmail
    And Login with valid username and password
    When Click on compose
    
    Then User enter in body  "Automation QA test for Incubyte"
    And  User enter in subject "Incubyte"
    

 