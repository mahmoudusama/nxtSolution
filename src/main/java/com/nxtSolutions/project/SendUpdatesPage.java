package com.nxtSolutions.project;

import com.nxtSolutions.common.ui.base.BaseWebDriver;
import com.nxtSolutions.common.ui.uiAutomation.SeleUtils;
import com.nxtSolutions.common.utils.generator.Generator;
import org.openqa.selenium.By;

public class SendUpdatesPage extends BaseWebDriver {
    private final SeleUtils seleUtils = new SeleUtils();

    public static String title = null;
    public static String body = null;
    public static String users = null;
    private static final By createNewBtn = By.xpath("(//p[@class='Text_root__M6tno'][normalize-space()='Create New'])[1]");
    private static final By sendNowBtn = By.xpath("//button[normalize-space()=\"Send Now\"]");
    private static final By cancelBtn = By.xpath("//button[normalize-space()=\"Cancel\"]");
    private static final By titleBox = By.xpath("//input[@id=\"title\"]");
    private static final By bodyBox = By.xpath("//textarea[@id=\"description\"]");
    private static final By typeDropDownNotifyNow = By.xpath("(//select)[1]");
    private static final By typeDropDownSaveLater = By.xpath("(//select)[1]");

    private static final By notifyDropDownByUsers = By.xpath("(//select)[2]");
    private static final By ByUsers = By.xpath("//option[@value=\"byUsers\"]");
    private static final By usersBox = By.xpath("//input[@placeholder=\"Type and hit enter...\"]");
    private static final By statusValue = By.xpath("(//td[@id='col-5'])[1]");
    private static final By appNotifCheckBox = By.id("appNotification");
    private static final By emailCheckBox = By.id("email");
    private static final By sendUpdatesPageTitle = By.xpath("//h2[normalize-space()=\"Send Updates\"]");
    private static final By notificationPageTitle = By.xpath("//h2[normalize-space()=\"Notifications Queue\"]");
    private static final By successMessageSendUpdates = By.xpath(("//*[contains(text(),'successfully')]"));




    public void clickOnCancelSendUpdates() {
        seleUtils.clickOnElement(cancelBtn);
    }

    public void clickOnSendNowSendUpdates() {
        seleUtils.clickOnElement(sendNowBtn);
    }

    public void clickOnCreateNewSendUpdates() {
        seleUtils.clickOnElement(createNewBtn);
    }

    public void clickOnAppNotifCheckBoxSendUpdates() {
        seleUtils.clickOnElementWithoutCheck(appNotifCheckBox);
    }

    public void clickOnEmailCheckBoxSendUpdates() {
        seleUtils.clickOnElementWithoutCheck(emailCheckBox);
    }

    public void setTitleBox() {
        title = Generator.generateRandomString();
        seleUtils.setText(titleBox, title);
    }

    public void setBodyBox() {
        body = Generator.generateRandomString();
        seleUtils.setText(bodyBox, body);
    }

    public void setUsersBox() {
        users = Generator.generateRandomString();

        seleUtils.setText(usersBox, users);
    }

    public String getStatusValue() {
        return seleUtils.getText(statusValue);
    }

    public boolean sendUpdatesPageDisplayed() {
        return seleUtils.isElementDisplayed(sendUpdatesPageTitle);
    }

    public boolean notificationQueuePageDisplayed() {
        return seleUtils.isElementDisplayed(notificationPageTitle);
    }

    public void clickOnTypeDDNotifyNowSendUpdates() {
        seleUtils.clickOnElement(typeDropDownNotifyNow);
    }

    public void clickOnTypeDDSaveLaterSendUpdates() {
        seleUtils.clickOnElement(typeDropDownSaveLater);
    }

    public void clickOnNotifyDDByUsers() {
        seleUtils.clickOnElement(notifyDropDownByUsers);
        seleUtils.clickOnElement(ByUsers);
    }

    public boolean isSuccessMessageDisplayedSendUpdates() {
        return seleUtils.isElementDisplayed(successMessageSendUpdates);
    }
}