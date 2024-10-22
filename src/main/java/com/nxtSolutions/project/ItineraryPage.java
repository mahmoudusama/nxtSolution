package com.nxtSolutions.project;

import com.nxtSolutions.common.ui.base.BaseWebDriver;
import com.nxtSolutions.common.ui.uiAutomation.JSUtils;
import com.nxtSolutions.common.ui.uiAutomation.SeleUtils;
import com.nxtSolutions.common.utils.generator.Generator;
import com.nxtSolutions.common.utils.properties.PropertiesManager;
import org.openqa.selenium.By;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class ItineraryPage extends BaseWebDriver {
    private final SeleUtils seleUtils = new SeleUtils();
    private final JSUtils jsUtils = new JSUtils();
    public static String generatedNameForActivity = null;
    public static String SecondGeneratedNameForActivity = null;
    private static final PropertiesManager propertiesManager = new PropertiesManager();
    private static final By calendar = By.xpath("(//div[@class='rbc-events-container'])[6]");
    private static final By saveBtn = By.xpath("//button[normalize-space()='Save']");
    private static final By cancelBtn = By.xpath("//button[normalize-space()='Cancel']");

    private static final By updateBtn = By.xpath("//button[normalize-space()='Update']");
    private static final By activityTitleBox = By.xpath("//input[@id='activityTitle']");
    private static final By coverImageBtn = By.xpath("(//div[@class='flex flex-col w-full h-full space-y-2 absolute inset-0 items-center justify-center'])[1]");
    private static final By activityDateBox = By.xpath("//input[@id='activityDate']");
    private static final By fromTimeBox = By.xpath("//input[@id='startTime']");
    private static final By toTimeBox = By.xpath("//input[@id='endTime']");
    private static final By activityDetailsPage = By.xpath("//h1[normalize-space()='Activity Details']");

    private static final By deleteIcon = By.xpath("(//*[name()='svg'][@class='w-7 h-7'])[1]");
    private static final By confirmDelete = By.xpath("//button[normalize-space()='Delete']");
    private static final By successMessageItinerary = By.xpath(("//*[contains(text(),'successfully')]"));


    public void uploadCoverImageActivityDetails() throws AWTException {
        seleUtils.clickOnElement(coverImageBtn);
        Robot robot = new Robot();
        String imgPath = System.getProperty("user.dir") + propertiesManager.getProp("groupThumbnailImg");
        StringSelection selection = new StringSelection(imgPath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
        robot.delay(3000);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.delay(3000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.delay(3000);
    }
    public void clickOnCalendar() {
        seleUtils.clickOnElement(calendar);
    }

    public void clickOnSaveItinerary() {
        seleUtils.clickOnElement(saveBtn);
    }

    public void clickOnUpdateItinerary() {
        seleUtils.clickOnElement(updateBtn);
    }

    public void clickOnCancelItinerary() {
        seleUtils.clickOnElement(cancelBtn);
    }

    public void typeActivityTitleItinerary() {
        generatedNameForActivity = Generator.generateRandomString();
        seleUtils.clearText(activityTitleBox);
        seleUtils.setText(activityTitleBox, generatedNameForActivity);
    }

    public void updateTitleItinerary() {
        SecondGeneratedNameForActivity = Generator.generateRandomString();
        seleUtils.clearText(activityTitleBox);
        seleUtils.setText(activityTitleBox, SecondGeneratedNameForActivity);
    }

    public void typeActivityDate() {
        seleUtils.setText(activityDateBox, Generator.getDatePlusDays(0));
    }

    public void typeStartTimeActivity() {
        seleUtils.setText(fromTimeBox, "11111");
    }

    public void typeEndTimeActivity() {
        seleUtils.setText(toTimeBox, "11112");
    }


    public void clickOnCreatedActivity() {
        String createdActivity = "//strong[contains(text(), '"+generatedNameForActivity+"')]";
        jsUtils.scrollToElement(By.xpath(createdActivity));
        jsUtils.click(By.xpath(createdActivity));
    }

    public String getTitleValue() {
        String createdActivity = "//div[@class='rbc-event']//div[contains(@class, 'rbc-event-label') and text()='2:00 PM – 4:00 PM']/following-sibling::div//strong[text()='"+generatedNameForActivity+"']";
        return seleUtils.getText(By.xpath(createdActivity));
    }

    public void clickOnDeleteIcon() {
        seleUtils.clickOnElement(deleteIcon);
    }
    public void clickOnConfirmDelete() {
        seleUtils.clickOnElement(confirmDelete);
    }

    public boolean createdActivityNotVisible() {
        String createdActivity = "//div[@class='rbc-event']//div[contains(@class, 'rbc-event-label') and text()='2:00 PM – 4:00 PM']/following-sibling::div//strong[text()='"+generatedNameForActivity+"']";
        jsUtils.scrollToElement(By.xpath(createdActivity));
        return seleUtils.isElementInvisible(By.xpath(createdActivity));
    }

    public boolean userOnActivityPageItinerary() {
        return seleUtils.isElementDisplayed(activityDetailsPage);
    }

    public boolean isSuccessMessageDisplayedItinerary() {
        return seleUtils.isElementDisplayed(successMessageItinerary);
    }

}