package com.nxtSolutions.project;

import com.nxtSolutions.common.ui.base.BaseWebDriver;
import com.nxtSolutions.common.ui.uiAutomation.SeleUtils;
import org.openqa.selenium.By;

public class DashboardPage extends BaseWebDriver {
    private static final By Content_DropDown = By.xpath("//span[normalize-space()=\"Content\"]");
    private static final By ExploreBtn = By.xpath("//a[@href='/explore']");
    private static final By ItineraryBtn= By.xpath("//a[@href='/itinerary']");
    private static final By SendUpdatesBtn = By.xpath("//p[normalize-space()='Send Updates']");

    private static final By Planning_DropDown = By.xpath("(//span[normalize-space()='Planning'])[1]");
    private static final By PackagesBtn = By.xpath("//a[@href='/packages']");
    private static final By SessionsBtn = By.xpath("//a[@href='/sessions']");


    private static final By Registration_DropDown = By.xpath("(//span[normalize-space()='Registration'])[1]");
    private static final By AttendeesBtn = By.xpath("//a[@href='/users']");
    private static final By ApplicationsBtn = By.xpath("//a[@href='/applications']");


    private static final By Reports_DropDown = By.xpath("//span[normalize-space()=\"Reports\"]");
    private static final By UserReportsBtn = By.xpath("//a[@href='/user_reports']");

    private final SeleUtils seleUtils = new SeleUtils();



    public void clickContentDropDown() {
        seleUtils.clickOnElement(Content_DropDown);
    }

    public void clickExploreBtn() {
        seleUtils.clickOnElement(ExploreBtn);
    }

    public void clickItineraryBtn() {
        seleUtils.clickOnElement(ItineraryBtn);
    }

    public void clickSendUpdatesBtn() {
        seleUtils.clickOnElement(SendUpdatesBtn);
    }


    public void clickPlanningDropDown() {
        seleUtils.clickOnElement(Planning_DropDown);
    }

    public void clickPackagesBtn() {
        seleUtils.clickOnElement(PackagesBtn);
    }

    public void clickSessionsBtn() {
        seleUtils.clickOnElement(SessionsBtn);
    }

    public void clickRegistrationDropDown() {
        seleUtils.clickOnElement(Registration_DropDown);
    }

    public void clickAttendeesBtn() {
        seleUtils.clickOnElement(AttendeesBtn);
    }

    public void clickApplicationsBtn() {
        seleUtils.clickOnElement(ApplicationsBtn);
    }

    public void clickReportsDropDown() {
        seleUtils.clickOnElement(Reports_DropDown);
    }

    public void clickUserReportsBtn() {
        seleUtils.clickOnElement(UserReportsBtn);
    }

}