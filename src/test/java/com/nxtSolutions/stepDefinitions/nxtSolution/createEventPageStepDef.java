package com.nxtSolutions.stepDefinitions.nxtSolution;

import com.nxtSolutions.common.ui.base.BaseWebDriver;
import com.nxtSolutions.common.ui.uiAutomation.JSUtils;
import com.nxtSolutions.common.ui.uiAutomation.SeleUtils;
import com.nxtSolutions.project.CreateEventPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;


public class createEventPageStepDef extends BaseWebDriver {
    private final SeleUtils seleUtils = new SeleUtils();
    private final JSUtils jsUtils = new JSUtils();
    private final CreateEventPage createEventPage = new CreateEventPage();


    @Then("validate user is on New Event From Scratch page")
    public void validateNewEventFromScratchPage() {
        jsUtils.waitDocumentReady();
        Assertions.assertTrue(createEventPage.userOnNewEventFromScratchPage());
    }

    @And("User fills in the event details")
    public void fillsEventDetails() {
        createEventPage.typeTitle();
        createEventPage.typeSlug();
    }

    @And("User edits event name")
    public void editEventName() {
        createEventPage.typeTitle();
    }

    @And("User selects a random event type")
    public void selectRandomEvent() {
        createEventPage.selectRandomEvent();
    }


    @And("User fills in the event start and end dates and times")
    public void fillsEventDates() {
        createEventPage.typeStartDate();
        createEventPage.typeStartTime();
        createEventPage.typeEndDate();
        createEventPage.typeEndTime();
    }

    @And("User selects the event zone")
    public void selectEventZone() {
        createEventPage.selectZoneEvent();
    }

    @And("User clicks on the Create Event button")
    public void clickOnCreateEvent() {
        createEventPage.clickCreateButton();
    }
}