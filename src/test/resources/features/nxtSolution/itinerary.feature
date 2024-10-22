@Ui @Itinerary
Feature: Verify that itinerary is working properly

  Scenario: Create Activity - Test to verify that user can Create Activity
    Given user open "getProp.Browser" browser
    Then user navigate to URL "getProp.nxtSolutionUrl"
    Then user sets correct credentials for nxtSolution
    Then validate user is on My Events page
    Then user click on created event
    Then user click on "content" button from dashboard
    Then user click on "itinerary" button from dashboard
    Then user click on calendar to add an activity
    And an Activity Details page display
    Then user set data for the activity
    And user click on "save" for activity details
    Then the system should display a success message "Activity created successfully"


  Scenario: Edit Activity - Test to verify that user can Edit Activity
    When user click on the added activity
    And an Activity Details page display
    Then user change the Activity title
    Then user click on "update" for activity details
    Then the system should display a success message "Activity updated successfully"
    And the title should be changed successfully


  Scenario: Delete Activity - Test to verify that user can Delete Activity
    When user click on the added activity
    And an Activity Details page display
    Then user click on delete icon
    Then user confirm deleting this activity
    Then the system should display a success message "Activity deleted successfully"
    And the activity should be deleted successfully




    #  Scenario: New Event Created
#    When user click on "New Event" button on My Events page
#    Then validate user is on New Event page
#    Then user click on "Start From Scratch" button on New Event page
#    Then validate user is on New Event From Scratch page
#    And User fills in the event details
#    And User selects a random event type
#    And User fills in the event start and end dates and times
#    And User selects the event zone
#    And User clicks on the Create Event button
#    Then the event should be "created" successfully