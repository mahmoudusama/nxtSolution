package com.nxtSolutions.project;

import com.nxtSolutions.common.ui.base.BaseWebDriver;
import com.nxtSolutions.common.ui.uiAutomation.SeleUtils;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import com.nxtSolutions.common.utils.files.JsonUtils;

public class LoginPage extends BaseWebDriver {
    private static final By nameBox = By.id("username");
    private static final By passwordBox = By.id("password");
    private static final By loginBtn = By.xpath("//button[@type='submit']");
    private static final By skipBtn = By.xpath("//button[contains(text(),'Skip')]");
    private static final By errorMessage = By.tagName("p");
    private static final By faCode = By.xpath("//label[normalize-space()='Enter 2FA code']");
    private final SeleUtils seleUtils = new SeleUtils();

    private String getJsonValue(String key) {
        return JsonUtils.ReadJson(key);
    }

    public boolean userOnLoginPage() {
        return seleUtils.isElementDisplayed(nameBox);
    }

    public boolean userOn2FAPage() {
        return seleUtils.isElementDisplayed(faCode);
    }

    public void enterName() {
        String name = getJsonValue("name");
        log.info("Username is set to : {}", name);
        seleUtils.setText(nameBox, name);
    }

    public void TypeOnUserNameTextBox(String userName) {
        seleUtils.setText(nameBox, userName);
    }

    public void enterPassword(){
        String password = getJsonValue("password");
        log.info("Password is set to : {}", password);
        seleUtils.setText(passwordBox, password);
    }

    public void TypeOnPassWordTextBox(String passWord) {
        seleUtils.setText(passwordBox, passWord);
    }

    public void clickLogin() {
        seleUtils.clickOnElement(loginBtn);
    }

    public void clickSkip() {
        seleUtils.clickOnElement(skipBtn);
    }

    public void errorMessage(String message) {
        seleUtils.isElementDisplayed(errorMessage);
        String actualErrorMessage = seleUtils.getText(errorMessage);
        Assertions.assertEquals(message, actualErrorMessage);
    }
}
