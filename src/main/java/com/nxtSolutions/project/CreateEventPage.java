package com.nxtSolutions.project;

import com.nxtSolutions.common.ui.uiAutomation.SeleUtils;
import com.nxtSolutions.common.utils.generator.Generator;
import com.nxtSolutions.common.ui.base.BaseWebDriver;
import com.nxtSolutions.common.ui.uiAutomation.JSUtils;
import org.openqa.selenium.By;

public class CreateEventPage extends BaseWebDriver {
    public static String title = null;
    public static String slug = null;
    private final JSUtils jsUtils = new JSUtils();
    private final SeleUtils seleUtils = new SeleUtils();

    private static final By eventNameBox = By.xpath("(//input[@class='Input_root__fi0ZK'])[1]");
    private static final By slugBtn = By.xpath("(//input[@class='Input_root__fi0ZK'])[2]");
    private static final By startDate = By.xpath("(//input[@class='Input_root__fi0ZK'])[3]");
    private static final By startTime = By.xpath("(//input[@class='Input_root__fi0ZK'])[4]");
    private static final By endDate = By.xpath("(//input[@class='Input_root__fi0ZK'])[5]");
    private static final By endTime = By.xpath("(//input[@class='Input_root__fi0ZK'])[6]");

    private static final By eventDdl = By.xpath("(//select[@class='Input_root__fi0ZK Input_selectInput__aHlvF'])[1]");
    private static final By zoneDdl = By.xpath("(//select[@class='Input_root__fi0ZK Input_selectInput__aHlvF'])[2]");
    private static final By createBtn = By.xpath("//button[contains(text(),'Create')]");
    private static final By editBtn = By.xpath("//button[contains(text(),'Edit')]");


    public boolean userOnNewEventFromScratchPage() {
        return seleUtils.isElementDisplayed(eventNameBox);
    }


    public void typeTitle() {
        title = Generator.generateRandomString();
        log.info("Event Created Name: {}", title);
        seleUtils.clearText(eventNameBox);
        seleUtils.setText(eventNameBox, title);
    }

    public void typeSlug() {
        slug = Generator.generateRandomString();
        seleUtils.setText(slugBtn, Generator.generateRandomString());
    }

    public void selectRandomEvent() {
        seleUtils.selectRandomValueByIndex(eventDdl);
    }

    public void selectZoneEvent() {
        seleUtils.selectRandomValueByIndex(zoneDdl);
    }

    public void clickCreateButton(){
        jsUtils.scrollUp();
        seleUtils.clickOnElement(createBtn);
    }

    public void typeStartDate() {
        seleUtils.setText(startDate, Generator.getDatePlusDays(0));
    }

    public void typeStartTime() {
        seleUtils.setText(startTime, "11111");
    }

    public void typeEndDate() {
        seleUtils.setText(endDate, Generator.getDatePlusDays(2));
    }

    public void typeEndTime() {
        seleUtils.setText(endTime, "11112");
    }

    public void clickEditButton() {
        jsUtils.scrollUp();
        seleUtils.clickOnElement(editBtn);
    }

}
