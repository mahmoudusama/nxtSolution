@Ui @logInPage
Feature: Testing Login page

  Background:
    Given user open "getProp.Browser" browser
    Then user navigate to URL "getProp.nxtSolutionUrl"

  Scenario: Positive Scenario - Login to nxtSolution website with correct credentials
    When validate user is on "login" page
    And user set the username: "nxttester"
    And user set the Password: "nxt#qA@23"
    Then user click on "Login" button
    And validate user is on "2FA" page
    Then user click on "Skip" button
    Then validate user is on My Events page

  Scenario Outline: Negative Scenarios - Login with invalid credentials
    When validate user is on "login" page
    And user set the username: "<userName>"
    And user set the Password: "<passWord>"
    Then user click on "Login" button
    Then validate error message "Invalid login information, please check and try again." is displayed
    Examples:
      | userName      | passWord      |
      | wrongUsername | nxt#qA@23     |
      | nxttester     | wrongPassword |
      |               | nxt#qA@23     |
      | nxttester     |               |
      |               |               |