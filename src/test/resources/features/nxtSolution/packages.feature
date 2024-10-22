@Ui @packages
Feature: Verify that send updates page is working properly

  Scenario: Create a package - Test to verify that user can create a package
    Given user open "getProp.Browser" browser
    Then user navigate to URL "getProp.nxtSolutionUrl"
    Then user sets correct credentials for nxtSolution
    Then validate user is on My Events page
    Then user click on created event
    Then user click on "planning" button from dashboard
    Then user click on "packages" button from dashboard
    Given user is redirected to the "Packages" page
    When user clicks on the "New Package" button on the packages page
    Then user is redirected to the "New Package" page
    And user fills in the required data for the new package
    And user clicks on the "Save" button on the packages page
    Then user is redirected to the "Packages" page
    And the system displays a success message: "Package created successfully."
    And the created package is listed on the Packages page


  Scenario: Update a package - Test to verify that user can update a package
    Given user clicks the edit icon for the previously created package
    Then user is redirected to the "Update Package" form inside the packages page
    When user updates the package title with new information
    And user clicks on the "Update" button on the packages page
    Then user is redirected to the "Packages" page
    And the system displays a success message: "Package updated successfully."
    And the updated package is listed on the Packages page with the new title


  Scenario: Delete a package - Test to verify that user can delete a package
    Given user clicks the edit icon for the previously created package
    Then user is redirected to the "Update Package" form inside the packages page
    When user clicks on the "Delete" button on the packages page
    And user confirms the deletion by clicking the Delete button in the confirmation dialog
    Then user is redirected to the "Packages" page
    And the system displays a success message: "Package deleted successfully."
    And the deleted package no longer appears on the Packages page