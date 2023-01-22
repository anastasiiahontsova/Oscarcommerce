package com.oscarcommerce.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginHelper extends BaseHelper {
    public LoginHelper(WebDriver webDriver) {
        super(webDriver);
    }

    public void enterEmail(String email) {
        type(By.id("id_login-username"), email);
    }

    public void enterPassword(String password) {
        type(By.id("id_login-password"), password);
    }

    public void clickLoginBtn() {
        click(By.cssSelector("button[name='login_submit']"));
    }

    public void checkForLogOutBtn() {
        waitForElementToBeClickable(By.id("logout_link"));
    }

    public void clickPasswordResetBtn() {
        click(By.xpath("//a[@href='/en-gb/password-reset/']"));
    }

    public void clickResetEmailBtn() {
        webDriver.findElement(By.xpath("//button[contains(text(), 'Send reset email')]")).click();
    }

    public void checkResetEmailSent() {
        webDriver.findElement(By.xpath("//h1[contains(text(), 'Email sent')]")).isDisplayed();
    }

    public void enterResetEmail(String email) {
        type(By.id("id_email"), email);
    }

}
