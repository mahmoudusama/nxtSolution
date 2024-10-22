@Ui @Attendees
Feature: Verify that send updates page is working properly

  Scenario: Create a user - Test to verify that user can create a user
    Given user open "getProp.Browser" browser
    Then user navigate to URL "getProp.nxtSolutionUrl"
    Then user sets correct credentials for nxtSolution
    Then validate user is on My Events page
    Then user click on created event
    Then user click on "Registration" button from dashboard
    Then user click on "Attendees" button from dashboard
    Given user is redirected to the "All Groups" Attendees page
    When user clicks on the "All Users" button on the Attendees page
    Then user is redirected to the "Users" Attendees page
    When user clicks on the "Add User" button on the Attendees page
    Then user is redirected to the "User Details" Attendees page
    And user fills in the required data for the new user
    When user clicks on the "Create" button on the Attendees page
    And the system pop up a success message: "User created successfully"
    Then user is redirected to the "User Details" Attendees page
    Then user click on "Attendees" button from dashboard
    When user clicks on the "All Users" button on the Attendees page
    And the created user is listed on the Users page


  Scenario: Edit a user - Test to verify that user can update a user
    Given user clicks the edit icon for the previously created user
    Then user is redirected to the "User Details" Attendees page
    When user updates the first name with new name
    When user clicks on the "Save" button on the Attendees page
    And the system pop up a success message: "User updated successfully"
    Then user click on "Attendees" button from dashboard
    When user clicks on the "All Users" button on the Attendees page
    And the created user is listed on the Users page with his new name


  Scenario: Delete a user - Test to verify that user can delete a user
    Given user clicks the edit icon for the previously created user
    Then user is redirected to the "User Details" Attendees page
    When user clicks on the "Delete" button on the Attendees page
    And user confirms the deletion of user by clicking the Delete button in the confirmation dialog
    And the system pop up a success message: "User deleted successfully"
    Then user click on "Attendees" button from dashboard
    When user clicks on the "All Users" button on the Attendees page
    And the deleted user no longer appears on the Users page