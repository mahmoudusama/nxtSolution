package com.nxtSolutions.stepDefinitions.nxtSolution;

import com.nxtSolutions.common.ui.base.BaseWebDriver;
import com.nxtSolutions.common.ui.uiAutomation.JSUtils;
import com.nxtSolutions.common.ui.uiAutomation.SeleUtils;
import com.nxtSolutions.project.MyEventsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;


public class myEventsPageStepDef extends BaseWebDriver {
    private final JSUtils jsUtils = new JSUtils();
    private final MyEventsPage myEventsPage = new MyEventsPage();


    @When("validate user is on My Events page")
    public void validateMyEventsPage() {
        jsUtils.waitDocumentReady();
        Assertions.assertTrue(myEventsPage.userOnMyEventsPage(), "User is not on My Events Page");
    }

    @Then("user click on {string} button on My Events page")
    public void clickOnMyEventsPage(String button) {
        switch (button.toLowerCase()) {
            case "new event":
                myEventsPage.clickNewEvent();
                break;
            case "edit event":
                myEventsPage.clickEditEvent();
                break;
            default:
                log.warn("Unknown button: {}", button);
                break;
        }
    }

    @Then("user click on created event")
    public void clickOnCreatedEvent() {
        myEventsPage.clickFirstEvent();
    }

    @Then("the event should be {string} successfully")
    public void validateEventCreated(String status) {
        jsUtils.waitDocumentReady();
        switch (status.toLowerCase()){
            case "created":
                Assertions.assertTrue(myEventsPage.isSuccessMessageDisplayed(), "Event not created successfully");
                break;
            case "deleted":
                Assertions.assertTrue(myEventsPage.isSuccessMessageDisplayed(), "Event not deleted successfully");
                break;
            case "updated":
                Assertions.assertTrue(myEventsPage.isSuccessMessageDisplayed(), "Event not updated successfully");
                break;
            default:
                log.warn("Unknown status: {}", status);
                break;
        }
    }
}