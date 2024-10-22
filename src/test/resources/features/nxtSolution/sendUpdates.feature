@Ui @sendUpdates
Feature: Verify that send updates page is working properly

  Background:
    Given user open "getProp.Browser" browser
    Then user navigate to URL "getProp.nxtSolutionUrl"
    Then user sets correct credentials for nxtSolution
    Then validate user is on My Events page
    Then user click on created event

  Scenario Outline: Create update - send now to the user by notification and By email
    Then user click on "content" button from dashboard
    Then user click on "Send Updates" button from dashboard
    Then user redirected to "Notifications Queue" inside send updates page
    And user click on "Create New" for send updates
    Then user redirected to "Send Updates" inside send updates page
    Then user set Type to "Notify Now" for the Options
    When user set Methods to "<method>" for the Options
    Then user set data for the notification details
    Then user choose whom to notify to "By Users"
    Then enter name to notify
    And user click on "Send Now" for send updates
    Then user redirected to "Notifications Queue" inside send updates page
    Then system should display a success message "Notification created successfully"
    And status of the created notification is set to "Sent"

    Examples:
      | method           |
      | App Notification |
      | Email            |


  Scenario Outline: Create update - save for later to the user by notification and By email
    Then user click on "content" button from dashboard
    Then user click on "Send Updates" button from dashboard
    Then user redirected to "Notifications Queue" inside send updates page
    And user click on "Create New" for send updates
    Then user redirected to "Send Updates" inside send updates page
    Then user set Type to "Save for Later" for the Options
    When user set Methods to "<method>" for the Options
    Then user set data for the notification details
    Then user choose whom to notify to "By Users"
    Then enter name to notify
    And user click on "Send Now" for send updates
    Then user redirected to "Notifications Queue" inside send updates page
    Then system should display a success message "Notification created successfully"
    And status of the created notification is set to "Scheduled"

    Examples:
      | method           |
      | App Notification |
      | Email            |







