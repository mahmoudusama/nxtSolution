package com.nxtSolutions.stepDefinitions.nxtSolution;

import com.nxtSolutions.common.ui.base.BaseWebDriver;
import com.nxtSolutions.common.ui.uiAutomation.JSUtils;
import com.nxtSolutions.common.ui.uiAutomation.SeleUtils;
import com.nxtSolutions.project.CreateEventPage;
import com.nxtSolutions.project.EditEventPage;
import com.nxtSolutions.project.MyEventsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;


public class editEventPageStepDef extends BaseWebDriver {
    private final SeleUtils seleUtils = new SeleUtils();
    private final JSUtils jsUtils = new JSUtils();
    private final EditEventPage editEventPage = new EditEventPage();
    private final MyEventsPage myEventsPage = new MyEventsPage();


    @When("validate user is on Edit Events page")
    public void validateEditEventPage() {
        jsUtils.waitDocumentReady();
        Assertions.assertTrue(editEventPage.userOnEditEventPage(), "User is not on Edit Event Page");
    }

    @Then("user click on {string} button on Edit Events page")
    public void clickOnEditEventPage(String button) {
        switch (button.toLowerCase()) {
            case "edit":
                editEventPage.clickEditEvent();
                break;
            case "dots":
                editEventPage.clickDotsInEvent();
                break;
            case "delete":
                editEventPage.clickDeleteEvent();
                break;
            default:
                log.warn("Unknown button: {}", button);
                break;
        }
    }


}