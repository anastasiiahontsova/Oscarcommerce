package com.oscarcommerce.glue;

import com.oscarcommerce.fw.ApplicationManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
    protected static ApplicationManager app;

    public LoginSteps(ApplicationManager app) {
        LoginSteps.app = app;
    }
    @Given("Login page is opened")
    public void openLoginPage() {
        app.goToLoginPage();
    }

    @When("{string} and {string} for login are entered")
    public void enterLoginCredentials(String email, String pwd) {
        app.getLoginHelper().enterEmail(email);
        app.getLoginHelper().enterPassword(pwd);
    }

    @And("Login button is clicked")
    public void clickLoginBtn() {
        app.getLoginHelper().clickLoginBtn();
    }

    @Then("User is logged in")
    public void checkUserIsLoggedIn() {
        app.getLoginHelper().checkForLogOutBtn();
    }

    @Then("Login error message appears")
    public void loginErrorMessage() {
        app.getLoginHelper().hasErrorMsg();
    }

    @Then("Login alert that fields are blank appears")
    public void loginBlankFieldAlert() {
        app.getLoginHelper().waitForAlert();
    }

    @When("I've forgotten my password link is clicked")
    public void clickPwdResetLink() {
        app.getLoginHelper().clickPasswordResetBtn();
    }

    @And("Password reset page is opened")
    public void openPwdResetPage() {
        app.goToPasswordResetPage();
    }

    @And("{string} for reset email is entered")
    public void enterEmail(String email) {
        app.getLoginHelper().enterResetEmail(email);
    }

    @And("Send reset email button is clicked")
    public void clickResetEmailBtn() {
        app.getLoginHelper().clickResetEmailBtn();
    }

    @Then("Reset email is sent to a user")
    public void checkResetEmailIsSentToAUser() {
        app.getLoginHelper().checkResetEmailSent();
    }
}




