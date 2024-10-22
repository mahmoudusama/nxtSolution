package com.nxtSolutions.project;

import com.nxtSolutions.common.ui.base.BaseWebDriver;
import com.nxtSolutions.common.ui.uiAutomation.SeleUtils;
import com.nxtSolutions.common.utils.properties.PropertiesManager;
import org.openqa.selenium.By;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class ExplorePage extends BaseWebDriver {
    private final SeleUtils seleUtils = new SeleUtils();
    private static final PropertiesManager propertiesManager = new PropertiesManager();
    private static final By saveBtn = By.xpath("//button[normalize-space()='Save']");
    private static final By cancelBtn = By.xpath("//button[normalize-space()='Cancel']");
    private static final By groupTitleBox = By.xpath("//input[@id='title']");
    private static final By groupThumbnailBtn = By.xpath("(//div[@class='flex flex-col w-full h-full space-y-2 absolute inset-0 items-center justify-center'])[1]");
    private static final By addGroupBtn = By.xpath("(//button[@class='Button_root__0RbKd Button_primary-outline__xLB56 min-h-[45px]'])[1]");
    private static final By newGroupPopUp = By.xpath("//h3[normalize-space()='New Group']");
    private static final By successMessageExplore = By.xpath(("//*[contains(text(),'successfully')]"));
    private static final By titleErrorMessageExplore = By.xpath(("//*[contains(text(),'title')]"));
    private static final By imageErrorMessageExplore = By.xpath(("//*[contains(text(),'image')]"));


    public boolean userOnNewGroupPopUpExplore() {
        return seleUtils.isElementDisplayed(newGroupPopUp);
    }

    public void typeGroupTitleExplore(String title) {
        seleUtils.setText(groupTitleBox, title);
    }

    public void clickOnSaveExplore() {
        seleUtils.clickOnElement(saveBtn);
    }

    public void clickOnCancelExplore() {
        seleUtils.clickOnElement(cancelBtn);
    }

    public void uploadGroupThumbnailExplore() throws AWTException {
        seleUtils.clickOnElement(groupThumbnailBtn);
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

    public void clickOnAddGroupExplore() {
        seleUtils.clickOnElement(addGroupBtn);
    }

    public boolean isSuccessMessageDisplayedExplore() {
        return seleUtils.isElementDisplayed(successMessageExplore);
    }

    public boolean isTitleErrorMessageDisplayedExplore() {
        return seleUtils.isElementDisplayed(titleErrorMessageExplore);
    }

    public boolean isImageErrorMessageDisplayedExplore() {
        return seleUtils.isElementDisplayed(imageErrorMessageExplore);
    }

}