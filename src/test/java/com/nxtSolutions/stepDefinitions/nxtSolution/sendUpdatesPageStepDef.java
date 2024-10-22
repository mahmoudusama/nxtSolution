package com.nxtSolutions.stepDefinitions.nxtSolution;

import com.nxtSolutions.common.ui.base.BaseWebDriver;
import com.nxtSolutions.common.ui.uiAutomation.JSUtils;
import com.nxtSolutions.project.LoginPage;
import com.nxtSolutions.project.SendUpdatesPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class sendUpdatesPageStepDef extends BaseWebDriver {
    private final JSUtils jsUtils = new JSUtils();
    private final SendUpdatesPage sendUpdatesPage = new SendUpdatesPage();

    @Then("user redirected to {string} inside send updates page")
    public void user_redirected_to_inside_send_updates_page(String page) {
        jsUtils.waitDocumentReady();
        switch (page.toLowerCase()) {
            case "send updates":
                Assertions.assertTrue(sendUpdatesPage.sendUpdatesPageDisplayed());
                break;
            case "notifications queue":
                Assertions.assertTrue(sendUpdatesPage.notificationQueuePageDisplayed());
                break;
            default:
                log.warn("Unknown page: {}", page);
                break;
        }
    }

    @Then("user click on {string} for send updates")
    public void user_click_on_for_send_updates(String button) {
        jsUtils.waitDocumentReady();
        switch (button.toLowerCase()) {
            case "send now":
                sendUpdatesPage.clickOnSendNowSendUpdates();
                break;
            case "cancel":
                sendUpdatesPage.clickOnCancelSendUpdates();
                break;
            case "create new":
                sendUpdatesPage.clickOnCreateNewSendUpdates();
                break;
            default:
                log.warn("Unknown button: {}", button);
                break;
        }
    }

    @Then("user set data for the notification details")
    public void user_set_data_for_the_notification_details() {
        sendUpdatesPage.setTitleBox();
        sendUpdatesPage.setBodyBox();
    }

    @Then("user set Type to {string} for the Options")
    public void user_set_type_to_for_the_options(String type) {
        jsUtils.waitDocumentReady();
        switch (type.toLowerCase()) {
            case "notify now":
                sendUpdatesPage.clickOnTypeDDNotifyNowSendUpdates();
                break;
            case "save for later":
                sendUpdatesPage.clickOnTypeDDSaveLaterSendUpdates();
                break;
            default:
                log.warn("Unknown type: {}", type);
                break;
        }
    }

    @When("user set Methods to {string} for the Options")
    public void user_set_methods_to_for_the_options(String method) {
        jsUtils.waitDocumentReady();
        switch (method.toLowerCase()) {
            case "app notification":
                sendUpdatesPage.clickOnAppNotifCheckBoxSendUpdates();
                break;
            case "email":
                sendUpdatesPage.clickOnEmailCheckBoxSendUpdates();
                break;
            default:
                log.warn("Unknown method: {}", method);
                break;
        }
    }

    @Then("user choose whom to notify to {string}")
    public void user_choose_whom_to_notify_to(String NotifyDd) {
        if (NotifyDd.toLowerCase().equals("by users")) {
            sendUpdatesPage.clickOnNotifyDDByUsers();
        } else {
            log.warn("Unknown choice: {}", NotifyDd);
        }
    }

    @Then("enter name to notify")
    public void enter_name_to_notify() {
        sendUpdatesPage.setUsersBox();
    }

    @Then("system should display a success message {string}")
    public void system_should_display_a_success_message(String string) {
        Assertions.assertTrue(sendUpdatesPage.isSuccessMessageDisplayedSendUpdates());
    }

    @Then("status of the created notification is set to {string}")
    public void status_of_the_created_notification_is_set_to(String status) {
        switch (status.toLowerCase()) {
            case "sent":
                Assertions.assertEquals("Sent",sendUpdatesPage.getStatusValue(), "Notification Status is not Sent");
                break;
            case "scheduled":
                Assertions.assertEquals("Scheduled",sendUpdatesPage.getStatusValue(), "Notification Status is not scheduled");
                break;
            default:
                log.warn("Unknown status: {}", status);
                break;
        }

    }
}