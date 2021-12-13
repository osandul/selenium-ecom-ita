Feature: Login page
  As an unregistered user
  I want to register to the system with my credentials
  So that I can have access to store

  Scenario: Property File check
    Given User is logged in on Login Page

    @smoke
  Scenario: Error message about unsuccessful login with invalid credentials is displayed
    Given Login page is opened in header dropdown
    And I click OK button on Login page
    Then Error popup with message 'Warning: No match for E-Mail Address and/or Password.' is displayed

  Scenario:[PARAMS] My Account page is displayed after successful login
    Given Login page is opened in header dropdown
    When I enter in the field 'email' data 'sajowi9588@epeva.com' on Login page
    And I enter in the field 'password' data '123123' on Login page
    And I click 'Login' button on Login page
    Then My Account page is displayed

  Scenario:[ENUM] My Account page is displayed after successful login
    Given Login page is opened in header dropdown
    When I enter in the enum field EMAIL_INPUT_FIELD data 'hdvjsvdj@gmail' on Login page
    And I enter in the enum field PASSWORD_INPUT_FIELD data 'hdvjsvdj@gmail' on Login page
    And I click 'Login' button on Login page
    Then My Account page is displayed

  Scenario:[DATA TABLE] My Account page is displayed after successful login
    Given Login page is opened in header dropdown
    When I enter text into field on Login Page:
      | inputData            | fieldName |
      | sajowi9588@epeva.com | email     |
      | 123123               | password  |
    And I click 'Login' button on Login page
    Then My Account page is displayed

