package com.nxtSolutions.project;

import com.nxtSolutions.common.ui.base.BaseWebDriver;
import com.nxtSolutions.common.ui.uiAutomation.SeleUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class MyEventsPage extends BaseWebDriver {
    private static final By successMessage = By.xpath(("//*[contains(text(),'successfully')]"));
    private static final By newEvent = By.xpath("//a[@href='/events/options']");
    private static final By editEvent = By.xpath("(//button[@class='Button_root__0RbKd Button_ghost__tLrp+ Button_tiny__+g2s1 Button_circle__MofPb'])[2]");
    private static final By myEventsPage = By.xpath("//h2[normalize-space()='My Events']");
    private static final By firstEvent = By.xpath("//tbody/tr[1]/td[3]");
    private final SeleUtils seleUtils = new SeleUtils();

    public boolean userOnMyEventsPage() {
        return seleUtils.isElementDisplayed(myEventsPage);
    }

    public void clickFirstEvent() {
        seleUtils.clickOnElement(firstEvent);
    }

    public void clickNewEvent() {
        seleUtils.clickOnElement(newEvent);
    }

    public void clickEditEvent() {
        seleUtils.clickOnElement(editEvent);
    }

    public void OpenCreatedEvent() {
        WebElement element = getDriver().findElement(By.xpath("//td/div[contains(text(), '" + CreateEventPage.title + "')]"));
        seleUtils.clickOnElement(element);
    }

    public boolean isEventCreated() {
        try {
            WebElement element = getDriver().findElement(By.xpath("//td/div[contains(text(), '" + CreateEventPage.title + "')]"));
            return seleUtils.isElementDisplayed(element);
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isSuccessMessageDisplayed() {
        try {
            return seleUtils.isElementDisplayed(successMessage);
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
