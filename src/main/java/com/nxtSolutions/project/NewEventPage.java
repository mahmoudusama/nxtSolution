package com.nxtSolutions.project;

import com.nxtSolutions.common.ui.base.BaseWebDriver;
import com.nxtSolutions.common.ui.uiAutomation.SeleUtils;
import org.openqa.selenium.By;

public class NewEventPage extends BaseWebDriver {
    private static final By startScratchBtn = By.xpath("(//div[@class='self-center text-center'])[1]");
    private static final By setUpLaterBtn = By.xpath("(//div[@role='button'])[4]");
    private final SeleUtils seleUtils = new SeleUtils();

    public boolean userOnNewEventPage() {
        return seleUtils.isElementDisplayed(startScratchBtn);
    }

    public void clickScratchButton() {
        seleUtils.clickOnElement(startScratchBtn);
    }

    public void clickSetUpLaterBtn() {
        seleUtils.clickOnElement(setUpLaterBtn);
    }

}
