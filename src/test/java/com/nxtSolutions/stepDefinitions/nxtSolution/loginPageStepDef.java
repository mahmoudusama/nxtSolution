package com.nxtSolutions.stepDefinitions.nxtSolution;

import com.nxtSolutions.common.ui.base.BaseWebDriver;
import com.nxtSolutions.common.ui.uiAutomation.JSUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.nxtSolutions.project.LoginPage;
import org.junit.jupiter.api.Assertions;

public class loginPageStepDef extends BaseWebDriver {
    private final JSUtils jsUtils = new JSUtils();
    private final LoginPage loginPage = new LoginPage();

    @And("user set the username: {string}")
    public void setTheUserName(String userName) {
        loginPage.TypeOnUserNameTextBox(userName);
    }

    @And("user set the Password: {string}")
    public void setThePassword(String password) {
        loginPage.TypeOnPassWordTextBox(password);
    }

    @Then("user click on {string} button")
    public void clickOnLogin(String button) {
        switch (button.toLowerCase()) {
            case "login":
                loginPage.clickLogin();
                break;
            case "skip":
                loginPage.clickSkip();
                break;
            default:
                log.warn("Unknown button: {}", button);
                break;
        }
    }

    @And("user sets correct credentials for nxtSolution")
    public void setUserNameAndPassword(){
        jsUtils.waitDocumentReady();
        loginPage.userOnLoginPage();
        loginPage.enterName();
        loginPage.enterPassword();
        loginPage.clickLogin();
        jsUtils.waitDocumentReady();
        loginPage.userOn2FAPage();
        loginPage.clickSkip();
        jsUtils.waitDocumentReady();
    }

    @When("validate user is on {string} page")
    public void validateLoginPage(String page) {
        jsUtils.waitDocumentReady();
        switch (page.toLowerCase()){
            case "login":
                Assertions.assertTrue(loginPage.userOnLoginPage());
                break;
            case "2fa":
                Assertions.assertTrue(loginPage.userOn2FAPage());
                break;
            default:
                log.error("Unknown button: {}", page);
                break;
        }
    }

    @Then("validate error message {string} is displayed")
    public void validateErrorMessage(String message) {
        loginPage.errorMessage(message);
    }
}