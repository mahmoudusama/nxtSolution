package com.nxtSolutions.project;

import com.nxtSolutions.common.ui.uiAutomation.JSUtils;
import com.nxtSolutions.common.ui.uiAutomation.SeleUtils;
import com.nxtSolutions.common.utils.generator.Generator;
import com.nxtSolutions.common.ui.base.BaseWebDriver;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class PackagePage extends BaseWebDriver {
    private static final By newPackageBtn = By.xpath("//span[contains(.,'New Package')]");
    private static final By savePackageBtn = By.xpath("//button[contains(.,'Save')]");
    private static final By deletePackageBtn = By.xpath("(//*[name()='svg'][@class='w-7 h-7'])[1]");
    private static final By updateBtn = By.xpath("//button[normalize-space()=\"Update\"]");
    private static final By titlePackageBox = By.id("package_title");
    private static final By priorityPackageBox = By.id("package_priority");
    private static final By namePackageBox = By.id("feature_name");
    private static final By createdPackage = By.xpath("(//div[@class='flex flex-col w-full h-full p-5 min-h-full bg-secondary-accent'])[1]");
    private static final By confirmDeleteBtn = By.xpath("//button[normalize-space()=\"Delete\"]");

    private static final By titlePackageOutSide = By.xpath("(//h4[@class='font-bold hidden sm:block Heading_h4__xAIwp font-bold'])[1]");
    private static final By editPackageBtn = By.xpath("(//*[name()='svg'][@class='w-7 h-7'])[1]");

    private static final By packagePageTitle = By.xpath("//h2[normalize-space()=\"Packages\"]");
    private static final By newPackagePageTitle = By.xpath("//h1[normalize-space()=\"New Package\"]");
    private static final By updatedPackagePageTitle = By.xpath("//h1[normalize-space()=\"Update Package\"]");

    private static final By statusMessage = By.xpath("(//div[@role='status'])[1]");


    private final JSUtils jsUtils = new JSUtils();
    private final SeleUtils seleUtils = new SeleUtils();
    private static String packageTitle = null;
    private static String packageNameBox = null;
    private static String priority = null;


    public boolean packagePageTitle() {
        return seleUtils.isElementDisplayed(packagePageTitle);
    }

    public boolean newPackagePageTitle() {
        return seleUtils.isElementDisplayed(newPackagePageTitle);
    }

    public boolean updatedPackagePageTitle() {
        return seleUtils.isElementDisplayed(updatedPackagePageTitle);
    }

    public void clickEditPackageBtn() {
        jsUtils.click(editPackageBtn);
    }

    public void clickNewPackage() {
        seleUtils.clickOnElement(newPackageBtn);
    }
    public void clickUpdatePackage() {
        seleUtils.clickOnElement(updateBtn);
    }

    public void typeName() {
        packageNameBox = Generator.generateRandomString();
        log.info("Package Name : {}", packageNameBox);
        seleUtils.setText(namePackageBox, packageNameBox);
    }


    public void typeTitle() {
        packageTitle = Generator.generateRandomString();
        log.info("Package Title : {}", packageTitle);
        seleUtils.clearText(titlePackageBox);
        seleUtils.setText(titlePackageBox, packageTitle);
    }

    public void typePriority() {
        priority = Generator.generateRandomNumbers();
        jsUtils.scrollToElement(priorityPackageBox);
        seleUtils.setText(priorityPackageBox,priority);
    }

    public void clickDeletePackage() {
        jsUtils.click(deletePackageBtn);
    }


    public void confirmDelete(){
        jsUtils.waitDocumentReady();
        seleUtils.clickOnElement(confirmDeleteBtn);
    }

    public void clickSave(){
        seleUtils.clickOnElement(savePackageBtn);
    }

    public boolean isPackageCreated() {
        return seleUtils.isElementDisplayed(createdPackage);
    }

    public boolean isPackageDeleted() {
        String namePackageOutSide = "//p[normalize-space()='"+packageNameBox+"']";
        return seleUtils.isElementInvisible(By.xpath(namePackageOutSide));
    }

    public String getStatusMessage() {
        return seleUtils.getText(statusMessage);
    }

    public void getPackageTitleOutside() {
        Assertions.assertEquals(packageTitle, seleUtils.getText(titlePackageOutSide), "Package Title did not change.");
    }

}
