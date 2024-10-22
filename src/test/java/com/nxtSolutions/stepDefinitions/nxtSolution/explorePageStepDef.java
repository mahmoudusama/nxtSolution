package com.nxtSolutions.stepDefinitions.nxtSolution;

import com.nxtSolutions.common.ui.base.BaseWebDriver;
import com.nxtSolutions.common.ui.uiAutomation.JSUtils;
import com.nxtSolutions.project.ExplorePage;
import com.nxtSolutions.project.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;

import java.awt.*;

public class explorePageStepDef extends BaseWebDriver {
    private final ExplorePage explorePage = new ExplorePage();
    private final JSUtils jsUtils = new JSUtils();

    @Then("user click on Add Group button")
    public void user_click_on_add_group_button() {
        explorePage.clickOnAddGroupExplore();
    }

    @Then("user sits Group Title with {string}")
    public void user_sits_group_title_with(String title) {
        explorePage.typeGroupTitleExplore(title);
    }

    @Then("user upload an image to Group Thumbnail")
    public void user_drop_a_file_to_group_thumbnail() throws AWTException {
        explorePage.uploadGroupThumbnailExplore();
    }

    @And("user click on {string} for new group")
    public void clickSaveCancelExplore(String button) {
        switch (button.toLowerCase()) {
            case "save":
                explorePage.clickOnSaveExplore();
                break;
            case "cancel":
                explorePage.clickOnCancelExplore();
                break;
            default:
                log.warn("Unknown button: {}", button);
                break;
        }
    }

    @Then("the group should be added successfully")
    public void groupAddedSuccessfully() {
        explorePage.isSuccessMessageDisplayedExplore();
    }

    @Then("Error message for title is displayed")
    public void titleIsEmpty() {
        jsUtils.waitDocumentReady();
        Assertions.assertTrue(explorePage.isTitleErrorMessageDisplayedExplore(), "Title error message does not displayed");
    }

    @Then("Error message for image is displayed")
    public void imageIsEmpty() {
        jsUtils.waitDocumentReady();
        Assertions.assertTrue(explorePage.isImageErrorMessageDisplayedExplore(), "Image error message does not displayed");
    }
}