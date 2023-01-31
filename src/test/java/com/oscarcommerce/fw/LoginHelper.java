package com.oscarcommerce.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginHelper extends BaseHelper {

    public static final String LOGIN_EMAIL_FIELD_ID = "id_login-username";
    public static final String LOGIN_PWD_FIELD_ID = "id_login-password";
    public static final String LOGIN_BTN_CSS = "button[name='login_submit']";
    public static final String LOGOUT_BTN_ID = "logout_link";
    public static final String PWD_RESET_BTN_XPATH = "//a[@href='/en-gb/password-reset/']";
    public static final String RESET_EMAIL_BTN_XPATH = "//button[contains(text(), 'Send reset email')]";
    public static final String RESET_EMAIL_SENT_MSG_XPATH = "//h1[contains(text(), 'Email sent')]";
    public static final String RESET_EMAIL_FIELD_ID = "id_email";
    public static final String LOGIN_ERROR_MSG_FIELD_XPATH = "//div[@class='alert alert-danger'][2]";

    public LoginHelper(WebDriver webDriver) {
        super(webDriver);
    }

    public void enterLoginEmail(String email) {
        clearAndType(By.id(LOGIN_EMAIL_FIELD_ID), email);
    }

    public void enterLoginPassword(String pwd) {
        clearAndType(By.id(LOGIN_PWD_FIELD_ID), pwd);
    }

    public void clickLoginBtn() {
        click(By.cssSelector(LOGIN_BTN_CSS));
    }

    public void checkForLogOutBtn() {
        waitForElementToBeClickable(By.id(LOGOUT_BTN_ID));
    }

    public void clickPasswordResetBtn() {
        click(By.xpath(PWD_RESET_BTN_XPATH));
    }

    public void clickResetEmailBtn() {
        webDriver.findElement(By.xpath(RESET_EMAIL_BTN_XPATH)).click();
    }

    public void checkResetEmailSent() {
        webDriver.findElement(By.xpath(RESET_EMAIL_SENT_MSG_XPATH)).isDisplayed();
    }

    public void enterResetEmail() {
        type(By.id(RESET_EMAIL_FIELD_ID), VALID_EMAIL);
    }


    public String hasLoginErrorMsg() {
        return hasText(By.xpath(LOGIN_ERROR_MSG_FIELD_XPATH));
    }

}