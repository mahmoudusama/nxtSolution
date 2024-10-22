package com.nxtSolutions.stepDefinitions.nxtSolution;

import com.nxtSolutions.common.ui.base.BaseWebDriver;
import com.nxtSolutions.common.ui.uiAutomation.JSUtils;
import com.nxtSolutions.common.ui.uiAutomation.SeleUtils;
import com.nxtSolutions.project.ExplorePage;
import com.nxtSolutions.project.ItineraryPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.awt.*;

import static com.nxtSolutions.project.ItineraryPage.SecondGeneratedNameForActivity;

public class itineraryPageStepDef extends BaseWebDriver {
    private final JSUtils jsUtils = new JSUtils();
    private final ItineraryPage itineraryPage = new ItineraryPage();


    @Then("user click on calendar to add an activity")
    public void user_click_on_calendar_to_add_an_activity() {
        itineraryPage.clickOnCalendar();
    }

    @Then("an Activity Details page display")
    public void an_activity_details_page_display() {
        Assertions.assertTrue(itineraryPage.userOnActivityPageItinerary(), "Activity Details page does not displayed.");
    }

    @Then("user set data for the activity")
    public void user_set_data_for_the_activity() throws AWTException {
        itineraryPage.uploadCoverImageActivityDetails();
        itineraryPage.typeActivityTitleItinerary();
        itineraryPage.typeActivityDate();
        itineraryPage.typeStartTimeActivity();
        itineraryPage.typeEndTimeActivity();
    }

    @Then("user click on {string} for activity details")
    public void user_click_on_for_activity_details(String button) {
        switch (button.toLowerCase()) {
            case "save":
                itineraryPage.clickOnSaveItinerary();
                break;
            case "cancel":
                itineraryPage.clickOnCancelItinerary();
                break;
            case "update":
                itineraryPage.clickOnUpdateItinerary();
                break;
            default:
                log.warn("Unknown button: {}", button);
                break;
        }
    }

    @Then("the system should display a success message {string}")
    public void the_system_should_display_a_success_message(String string) {
        Assertions.assertTrue(itineraryPage.isSuccessMessageDisplayedItinerary());
    }

    @When("user click on the added activity")
    public void user_click_on_the_added_activity() {
        itineraryPage.clickOnCreatedActivity();
    }


    @Then("user change the Activity title")
    public void user_change_the_activity_title() {
        itineraryPage.updateTitleItinerary();
    }

    @Then("the title should be changed successfully")
    public void the_title_should_be_changed_successfully() {
        Assertions.assertEquals(SecondGeneratedNameForActivity, itineraryPage.getTitleValue(), "Title does not change");
    }

    @Then("user click on delete icon")
    public void user_click_on_delete_icon() {
        itineraryPage.clickOnDeleteIcon();
    }

    @Then("user confirm deleting this activity")
    public void user_confirm_deleting_this_activity() {
        itineraryPage.clickOnConfirmDelete();

    }

    @Then("the activity should be deleted successfully")
    public void the_activity_should_be_deleted_successfully() {
        Assertions.assertTrue(itineraryPage.createdActivityNotVisible(), "Activity not deleted");
    }

}