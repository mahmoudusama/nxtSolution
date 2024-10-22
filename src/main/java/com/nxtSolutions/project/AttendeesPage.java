package com.nxtSolutions.project;

import com.nxtSolutions.common.ui.base.BaseWebDriver;
import com.nxtSolutions.common.ui.uiAutomation.JSUtils;
import com.nxtSolutions.common.ui.uiAutomation.SeleUtils;
import com.nxtSolutions.common.utils.generator.Generator;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class AttendeesPage extends BaseWebDriver {
    private final JSUtils jsUtils = new JSUtils();
    private final SeleUtils seleUtils = new SeleUtils();

    private static String firstName = null;
    private static String lastName = null;
    private static String title = null;
    private static String organization = null;
    private static String phoneNumber = null;
    private static String email = null;


    private static final By allGroupsTitle = By.xpath("//h2[normalize-space()=\"All Groups\"]");
    private static final By usersTitle = By.xpath("//h2[normalize-space()=\"Users\"]");
    private static final By userDetailsTitle = By.xpath("(//h2[normalize-space()='User Details'])[1]");


    private static final By allUsersBtn = By.xpath("(//div[@role='button'])[2]");
    private static final By addUserBtn = By.xpath("(//div[@class='flex items-center space-x-2 py-1'])[1]");
    private static final By createBtn = By.xpath("//button[normalize-space()=\"Create\"]");
    private static final By deleteUserBtn = By.xpath("(//*[name()='svg'][@class='w-7 h-7'])[2]");
    private static final By confirmDeleteBtn = By.xpath("//button[normalize-space()=\"Delete\"]");
    private static final By saveBtn = By.xpath("//button[normalize-space()='Save']");


    private static final By editIcon = By.xpath("(//td[@id='col-5'])[1]");

    private static final By nameTile = By.xpath("(//td[@id='col-2'])[1]");

    private static final By firstNameBox = By.xpath("//input[@id=\"firstName\"]");
    private static final By lastNameBox = By.xpath("//input[@id=\"lastName\"]");
    private static final By titleBox = By.xpath("//input[@id=\"title\"]");
    private static final By organizationBox = By.xpath("//input[@id=\"organization\"]");
    private static final By phoneNumBox = By.xpath("//input[@placeholder=\"Phone Number\"]");
    private static final By emailBox = By.xpath("//input[@id=\"email\"]");


    private static final By statusMessage = By.xpath("(//div[@role='status'])");


    public boolean allGroupsPageTitle() {
        return seleUtils.isElementDisplayed(allGroupsTitle);
    }

    public boolean usersPageTitle() {
        return seleUtils.isElementDisplayed(usersTitle);
    }

    public boolean userDetailsPageTitle() {
        return seleUtils.isElementDisplayed(userDetailsTitle);
    }

    public void clickAllUsersBtn() {
        jsUtils.click(allUsersBtn);
    }

    public void clickAddUserBtn() {
        seleUtils.clickOnElement(addUserBtn);
    }

    public void clickCreateBtn() {
        jsUtils.scrollUp();
        seleUtils.clickOnElement(createBtn);
    }


    public void clickSaveBtn() {
        seleUtils.clickOnElement(saveBtn);
    }

    public void clickEditIcon() {
        seleUtils.clickOnElement(editIcon);
    }

    public void clickDeleteIcon() {
        jsUtils.click(deleteUserBtn);
    }

    public void confirmDelete() {
        seleUtils.clickOnElement(confirmDeleteBtn);
    }


    public void typeFirstName() {
        firstName = Generator.generateRandomName();
        System.out.println("value of first name : " + firstName);
        seleUtils.clearText(firstNameBox);
        seleUtils.setText(firstNameBox, firstName);
    }

    public void typeLastName() {
        lastName = Generator.generateRandomName();
        seleUtils.setText(lastNameBox, lastName);
    }

    public void typeTitle() {
        title = Generator.generateRandomName();
        seleUtils.setText(titleBox, title);
    }

    public void typeOrganization() {
        organization = Generator.generateRandomName();
        seleUtils.setText(organizationBox, organization);
    }

    public void typePhoneNum() {
        phoneNumber = Generator.generateRandomPhoneNumber();
        seleUtils.setText(phoneNumBox, phoneNumber);
    }

    public void typeEmail() {
        email = Generator.generateRandomEmail();
        seleUtils.setText(emailBox, email);
    }


    public void isUserCreated() {
        Assertions.assertEquals(firstName+ " " +lastName, seleUtils.getText(nameTile), "User is not listed at the users list");
    }

    public boolean isUserDeleted() {
       return seleUtils.isElementInvisible(nameTile);
    }

    public String getStatusMessage() {
        return seleUtils.getText(statusMessage);
    }
}
