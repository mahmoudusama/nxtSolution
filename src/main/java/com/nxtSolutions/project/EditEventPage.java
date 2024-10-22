package com.nxtSolutions.project;

import com.nxtSolutions.common.ui.base.BaseWebDriver;
import org.openqa.selenium.By;
import com.nxtSolutions.common.ui.uiAutomation.SeleUtils;

public class EditEventPage extends BaseWebDriver {
    private static final By dotsBtn = By.xpath("(//div[@class='h-full relative']/button)[2]");
    private static final By editBtn = By.xpath("//button[contains(text(), 'Edit')]");
    private static final By deleteBtn = By.xpath("//strong[contains(text(), 'Delete')]");
    private static final By deleteInput = By.id("delete-input");
    private static final By confirmDelete = By.xpath("//button[contains(text(), 'Delete Forever')]");
    private final SeleUtils seleUtils = new SeleUtils();


    public boolean userOnEditEventPage() {
        return seleUtils.isElementDisplayed(editBtn);
    }

    public void clickDotsInEvent() {
        seleUtils.clickOnElement(dotsBtn);
    }

    public void clickEditEvent() {
        seleUtils.clickOnElement(editBtn);
    }

    public void clickDeleteEvent() {
        seleUtils.clickOnElement(deleteBtn);
    }

    public void confirmDeleteEvent(){
        seleUtils.setText(deleteInput, "delete-event-permanently");
        seleUtils.clickOnElement(confirmDelete);
    }

}
