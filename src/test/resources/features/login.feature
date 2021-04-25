@login

Feature: To test login functionality

  @Test-001
  Scenario: User logs-in to the application with valid username and password
    Given user is on the application home page
    When user enters valid loginID and Password
    And user clicks submit button
    Then user should be logged in

  @Test-002
  Scenario Outline: User enters invalid loginID
    Given user is on the application home page
    And user enters <invalid_userName> in the userName field
    Then user should see invalid username error
    Examples:
      | invalid_userName   |
      | test@qa-experience |
      | test               |
      | test@!@#$          |
      | test.com           |

  @Test-003
  Scenario Outline: User enters invalid password
    Given user is on the application home page
    And user enters <invalid_password> in the password field
    Then user should see invalid password error
    Examples:
      | invalid_password |
      | Pass             |
      | !@#$%^&          |
      | 123456           |