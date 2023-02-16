package com.oscarcommerce.glue;

import com.oscarcommerce.fw.ApplicationManager;
import com.oscarcommerce.fw.BaseHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;


public class RegistrationSteps {
    protected static ApplicationManager app;

    public RegistrationSteps(ApplicationManager app) {
        RegistrationSteps.app = app;
    }

    @Given("Registration page is opened")
    public void openRegistrationPage() {
        app.goToLoginAndRegistrationPage();
    }

    @When("{string} and {string} for registration are entered")
    public void registerUser(String email, String pwd) {
        app.getRegistrationHelper().enterUserRegistrationCredentials(email, pwd);
    }

    @When("{string} and {string} for existing user registration are entered")
    public void registerExistingUser(String email, String pwd) {
        app.getRegistrationHelper().enterUserRegistrationCredentials(BaseHelper.VALID_EMAIL, BaseHelper.VALID_PASSWORD);
    }

    @And("Register button is clicked")
    public void clickRegisterButton() {
        app.getRegistrationHelper().clickRegisterBtn();
    }

    @Then("User is registered")
    public void checkUserIsRegistered() {
        app.getRegistrationHelper().checkForLogOutBtn();
    }

    @Then("Registration {string} appears")
    public void registrationErrorMessageAppears(String expectedMessage) {
        Assert.assertEquals(app.getRegistrationHelper().hasPasswordErrorMsg(), expectedMessage, "Registration error message appears");
    }

    @When("Existing user's credentials for registration are entered")
    public void enterExistingUserCredentials() {
        app.getRegistrationHelper().enterUserRegistrationCredentials(BaseHelper.VALID_EMAIL, BaseHelper.VALID_PASSWORD);
    }

    @Then("{string} error message appears")
    public void errorMessageAppears(String errorMessage) {
        Assert.assertEquals(app.getRegistrationHelper().hasPasswordErrorMsg(), errorMessage, "Registration error message appears");
    }

    @And("User is logged out")
    public void userIsLoggedOut() {
        app.getRegistrationHelper().logOutUser();
    }


}