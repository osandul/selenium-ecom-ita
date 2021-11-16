Feature: As an unregistered user
  I want to register to the system with my credentials
  So that I can have access to store

  Scenario: Store page is displayed after successful login
    Given Login page is opened in header dropdown
    When I enter email 'sajowi9588@epeva.com' on Login page
    And I enter password '123123' on Login page
    And I click OK button on Login page
    Then Store page is displayed

  Scenario: Error message about unsuccessful login with invalid credentials is displayed
    Given Login page is opened in header dropdown
    When I enter email 'vsf@gmail.com' on Login page
    And I enter password '111' on Login page
    And I click OK button on Login page
    Then Error popup with message 'Warning: No match for E-Mail Address and/or Password.' is displayed