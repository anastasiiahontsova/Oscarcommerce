package com.oscarcommerce.glue;

import com.oscarcommerce.fw.ApplicationManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class LoginSteps {
    protected static ApplicationManager app;

    public LoginSteps(ApplicationManager app) {
        LoginSteps.app = app;
    }

    @Given("Login and Registration page is opened")
    public void openLoginPage() {
        app.goToLoginAndRegistrationPage();
    }

    @When("User is registered without login with {string} and {string}")
    public void registerUserWithoutLogin(String email, String pwd) {
        app.getRegistrationHelper().enterUserRegistrationCredentials(email, pwd);
        app.getRegistrationHelper().clickRegisterBtn();
        app.getRegistrationHelper().logOutUser();
        app.goToLoginAndRegistrationPage();
    }

    @And("Login {string} and {string} are entered")
    public void enterLoginCredentials(String email, String pwd) {
        app.getLoginHelper().enterLoginEmail(email);
        app.getLoginHelper().enterLoginPassword(pwd);
    }

    @And("Login button is clicked")
    public void clickLoginBtn() {
        app.getLoginHelper().clickLoginBtn();
    }

    @Then("User is logged in")
    public void checkUserIsLoggedIn() {
        app.getLoginHelper().checkForLogOutBtn();
    }

    @Then("Login {string} appears")
    public void loginErrorMessage(String expectedText) {
        Assert.assertEquals(app.getLoginHelper().hasLoginErrorMsg(), expectedText, "Login error message appears");
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

    @And("Valid email for reset email is entered")
    public void enterResetEmail() {
        app.getLoginHelper().enterResetEmail();
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




