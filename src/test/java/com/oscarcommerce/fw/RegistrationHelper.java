package com.oscarcommerce.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationHelper extends BaseHelper {
    public RegistrationHelper(WebDriver webDriver) {
        super(webDriver);
    }

    public void enterUserRegistrationCredentials(String email, String pwd) {
        type(By.id("id_registration-email"), email);
        type(By.id("id_registration-password1"), pwd);
        type(By.id("id_registration-password2"), pwd);
    }

<<<<<<< Updated upstream
<<<<<<< Updated upstream
<<<<<<< Updated upstream
    public void enterEmail(String email) {

=======
>>>>>>> Stashed changes
=======
>>>>>>> Stashed changes
=======
>>>>>>> Stashed changes
    public void enterRegistrationEmail(String email) {
        type(By.id("id_registration-email"), email);
    }

    public void enterRegistrationPassword(String pwd) {
        type(By.id("id_registration-password1"), pwd);
    }

    public void confirmRegistrationPassword(String pwd) {
        type(By.id("id_registration-password2"), pwd);
    }


    public void clickRegisterBtn() {
        click(By.cssSelector("button[name='registration_submit']"));
    }


    public void checkUserIsRegisteredAndLoggedIn() {
        checkForLogOutBtn();

    }

    public void checkForLogOutBtn() {
        waitForElementToBeClickable(By.id("logout_link"));
    }

<<<<<<< Updated upstream
<<<<<<< Updated upstream
<<<<<<< Updated upstream

=======
>>>>>>> Stashed changes
=======
>>>>>>> Stashed changes
=======
>>>>>>> Stashed changes
    public String hasPasswordErrorMsg() {
        return hasText(By.xpath("//span[@class='error-block'][1]"));
    }

    public void logOutUser() {
        click(By.id("logout_link"));
    }
}



