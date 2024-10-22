package com.nxtSolutions.stepDefinitions.nxtSolution;

import com.nxtSolutions.common.ui.base.BaseWebDriver;
import com.nxtSolutions.common.ui.uiAutomation.JSUtils;
import com.nxtSolutions.project.AttendeesPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class attendeesPageStepDef extends BaseWebDriver {
    private final JSUtils jsUtils = new JSUtils();
    private final AttendeesPage attendeesPage = new AttendeesPage();


    @Given("user is redirected to the {string} Attendees page")
    public void user_is_the_attendees_page(String page) {
        jsUtils.waitDocumentReady();
        switch (page.toLowerCase()) {
            case "all groups":
                Assertions.assertTrue(attendeesPage.allGroupsPageTitle());
                break;
            case "users":
                Assertions.assertTrue(attendeesPage.usersPageTitle());
                break;
            case "user details":
                Assertions.assertTrue(attendeesPage.userDetailsPageTitle());
                break;
            default:
                log.warn("Unknown page: {}", page);
                break;
        }
    }

    @When("user clicks on the {string} button on the Attendees page")
    public void user_clicks_on_the_button_on_the_attendees_page(String button) {
        jsUtils.waitDocumentReady();
        switch (button.toLowerCase()) {
            case "all users":
                attendeesPage.clickAllUsersBtn();
                break;
            case "add user":
                attendeesPage.clickAddUserBtn();
                break;
            case "create":
                attendeesPage.clickCreateBtn();
                break;
            case "delete":
                attendeesPage.clickDeleteIcon();
                break;
            case "save":
                attendeesPage.clickSaveBtn();
                break;
            default:
                log.warn("Unknown button: {}", button);
                break;
        }
    }


    @Then("user fills in the required data for the new user")
    public void user_fills_in_the_required_data_for_the_new_user() {
        attendeesPage.typeFirstName();
        attendeesPage.typeLastName();
        attendeesPage.typeTitle();
        attendeesPage.typeOrganization();
        attendeesPage.typePhoneNum();
        attendeesPage.typeEmail();
    }

    @And("the created user is listed on the Users page with his new name")
    @When("the created user is listed on the Users page")
    public void the_created_user_is_listed_on_the_users_page() {
        attendeesPage.isUserCreated();
    }

    @When("user updates the first name with new name")
    public void updateFirstName() {
        attendeesPage.typeFirstName();
    }

    @Given("user clicks the edit icon for the previously created user")
    public void editUser() {
        attendeesPage.clickEditIcon();
    }

    @And("the deleted user no longer appears on the Users page")
    public void userDeleted() {
        Assertions.assertTrue(attendeesPage.isUserDeleted(), "User is not deleted from the users list");
    }


    @And("user confirms the deletion of user by clicking the Delete button in the confirmation dialog")
    public void confirmDeleteUser() {
        attendeesPage.confirmDelete();
    }

    @Then("the system pop up a success message: {string}")
    public void the_system_displays_a_success_message(String message) {
        Assertions.assertEquals(message, attendeesPage.getStatusMessage(), "Status message is not correct");
    }
}