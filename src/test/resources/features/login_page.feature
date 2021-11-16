Feature: As an unregistered user
  I want to register to the system with my credentials
  So that I can have access to store

  Scenario: Successful login
    Given Account page is opened in header dropdown
    When I enter email '' on Login page
    And I enter password '' on Login page
    And I click OK button on Login page
    Then Store page is displayed