package com.oscarcommerce.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationHelper extends BaseHelper {

    public static final String REGISTRATION_EMAIL_FIELD_ID = "id_registration-email";
    public static final String REGISTRATION_PWD_FIELD_ID = "id_registration-password1";
    public static final String REGISTRATION_CONFIRM_PWD_FIELD_ID = "id_registration-password2";
    public static final String REGISTER_BTN_CSS = "button[name='registration_submit']";
    public static final String LOGOUT_BTN_ID = "logout_link";
    public static final String REGISTRATION_PWD_ERROR_MSG_FIELD_XPATH = "//span[@class='error-block'][1]";

    public RegistrationHelper(WebDriver webDriver) {
        super(webDriver);
    }

    public void enterUserRegistrationCredentials(String email, String pwd) {
        type(By.id(REGISTRATION_EMAIL_FIELD_ID), email);
        type(By.id(REGISTRATION_PWD_FIELD_ID), pwd);
        type(By.id(REGISTRATION_CONFIRM_PWD_FIELD_ID), pwd);
    }

    public void clickRegisterBtn() {
        click(By.cssSelector(REGISTER_BTN_CSS));
    }

    public void checkForLogOutBtn() {
        waitForElementToBeClickable(By.id(LOGOUT_BTN_ID));
    }

    public String hasPasswordErrorMsg() {
        return getText(By.xpath(REGISTRATION_PWD_ERROR_MSG_FIELD_XPATH));
    }

    public void logOutUser() {
        click(By.id(LOGOUT_BTN_ID));
    }

}



