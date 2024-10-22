package com.nxtSolutions.stepDefinitions.nxtSolution;

import com.nxtSolutions.common.ui.base.BaseWebDriver;
import com.nxtSolutions.project.DashboardPage;
import com.nxtSolutions.project.ExplorePage;
import io.cucumber.java.en.Then;

public class dashboardStepDef extends BaseWebDriver {
    private final DashboardPage dashboardPage = new DashboardPage();

    @Then("user click on {string} button from dashboard")
    public void clickOnDashboardList(String button) {
        switch (button.toLowerCase()) {
            case "content":
                dashboardPage.clickContentDropDown();
                break;
            case "explore":
                dashboardPage.clickExploreBtn();
                break;
            case "itinerary":
                dashboardPage.clickItineraryBtn();
                break;
            case "send updates":
                dashboardPage.clickSendUpdatesBtn();
                break;
            case "planning":
                dashboardPage.clickPlanningDropDown();
                break;
            case "packages":
                dashboardPage.clickPackagesBtn();
                break;
            case "sessions":
                dashboardPage.clickSessionsBtn();
                break;
            case "registration":
                dashboardPage.clickRegistrationDropDown();
                break;
            case "attendees":
                dashboardPage.clickAttendeesBtn();
                break;
            case "application":
                dashboardPage.clickApplicationsBtn();
                break;
            case "reports":
                dashboardPage.clickReportsDropDown();
                break;
            case "user reports":
                dashboardPage.clickUserReportsBtn();
                break;
            default:
                log.warn("Unknown button: {}", button);
                break;
        }
    }


}
