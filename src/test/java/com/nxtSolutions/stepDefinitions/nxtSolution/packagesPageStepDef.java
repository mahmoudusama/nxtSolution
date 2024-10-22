package com.nxtSolutions.stepDefinitions.nxtSolution;

import com.nxtSolutions.common.ui.base.BaseWebDriver;
import com.nxtSolutions.common.ui.uiAutomation.JSUtils;
import com.nxtSolutions.project.PackagePage;
import com.nxtSolutions.project.SendUpdatesPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class packagesPageStepDef extends BaseWebDriver {
    private final JSUtils jsUtils = new JSUtils();
    private final PackagePage packagePage = new PackagePage();

    @Given("user is redirected to the {string} page")
    public void user_is_redirected_to_the_page(String page) {
        jsUtils.waitDocumentReady();
        switch (page.toLowerCase()) {
            case "packages":
                Assertions.assertTrue(packagePage.packagePageTitle());
                break;
            case "update package":
                Assertions.assertTrue(packagePage.updatedPackagePageTitle());
                break;
            case "new package":
                Assertions.assertTrue(packagePage.newPackagePageTitle());
                break;
            default:
                log.warn("Unknown page: {}", page);
                break;
        }
    }

    @When("user clicks on the {string} button on the packages page")
    public void user_clicks_on_the_button_on_the_page(String button) {
        jsUtils.waitDocumentReady();
        switch (button.toLowerCase()) {
            case "delete":
                packagePage.clickDeletePackage();
                break;
            case "save":
                packagePage.clickSave();
                break;
            case "update":
                packagePage.clickUpdatePackage();
                break;
            case "new package":
                packagePage.clickNewPackage();
                break;
            default:
                log.warn("Unknown button: {}", button);
                break;
        }
    }

    @Then("user is redirected to the {string} form inside the packages page")
    public void user_is_redirected_to_the_form_inside_the_packages_page(String string) {
    }

    @Then("user fills in the required data for the new package")
    public void user_fills_in_the_required_data_for_the_new_package() {
        packagePage.typeTitle();
        packagePage.typePriority();
        packagePage.typeName();
    }

    @Then("user clicks the edit icon for the previously created package")
    public void user_clicks_on_the_button() {
        packagePage.clickEditPackageBtn();
    }

    @Then("user updates the package title with new information")
    public void packageTitleNew() {
        packagePage.typeTitle();
    }

    @Then("the updated package is listed on the Packages page with the new title")
    public void updatedPackageTitle() {
        packagePage.getPackageTitleOutside();
    }


    @Then("user confirms the deletion by clicking the Delete button in the confirmation dialog")
    public void confirmDeletePackage(){
        packagePage.confirmDelete();
    }


    @Then("the system displays a success message: {string}")
    public void the_system_displays_a_success_message(String message) {
        Assertions.assertEquals(message, packagePage.getStatusMessage(), "Status message is not correct");
    }

    @Then("the created package is listed on the Packages page")
    public void the_created_package_is_listed_on_the_page() {
        Assertions.assertTrue(packagePage.isPackageCreated());
    }

    @Then("the deleted package no longer appears on the Packages page")
    public void pacakgeDeleted() {
        Assertions.assertTrue(packagePage.isPackageDeleted());
    }
}