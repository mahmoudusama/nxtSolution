package com.nxtSolutions.stepDefinitions.nxtSolution;

import com.nxtSolutions.common.ui.base.BaseWebDriver;
import com.nxtSolutions.common.ui.uiAutomation.JSUtils;
import com.nxtSolutions.common.ui.uiAutomation.SeleUtils;
import com.nxtSolutions.project.MyEventsPage;
import com.nxtSolutions.project.NewEventPage;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;


public class newEventPageStepDef extends BaseWebDriver {
    private final SeleUtils seleUtils = new SeleUtils();
    private final JSUtils jsUtils = new JSUtils();
    private final NewEventPage newEventsPage = new NewEventPage();


    @Then("validate user is on New Event page")
    public void validateNewEventPage() {
        jsUtils.waitDocumentReady();
        Assertions.assertTrue(newEventsPage.userOnNewEventPage());
    }

    @Then("user click on {string} button on New Event page")
    public void clickOnNewEventsPageBtn(String button) {
        switch (button.toLowerCase()) {
            case "start from scratch":
                newEventsPage.clickScratchButton();
                break;
            case "set up later":
                newEventsPage.clickSetUpLaterBtn();
                break;
            default:
                log.warn("Unknown button: {}", button);
                break;
        }
    }


}