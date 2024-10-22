@Ui @Explore
Feature: Verify that Explore page is working properly

  Scenario: Add data - Create group in Explore page
    Given user open "getProp.Browser" browser
    Then user navigate to URL "getProp.nxtSolutionUrl"
    Then user sets correct credentials for nxtSolution
    Then validate user is on My Events page
    Then user click on created event
    Then user click on "content" button from dashboard
    Then user click on "explore" button from dashboard
    Then user click on Add Group button
    Then user upload an image to Group Thumbnail
    Then user sits Group Title with "MO-Test"
    And user click on "save" for new group
    Then the group should be added successfully

  Scenario: Validate that the group is not added if the group title is empty.
    Then user click on Add Group button
    Then user upload an image to Group Thumbnail
    Then user sits Group Title with ""
    And user click on "save" for new group
    Then Error message for title is displayed
    And user click on "cancel" for new group

  Scenario: Validate that the group is not added if the group title is empty.
    Then user click on Add Group button
    Then user sits Group Title with "Test-MO"
    And user click on "save" for new group
    Then Error message for image is displayed
    And user click on "cancel" for new group
