package com.oscarcommerce.glue;

import com.oscarcommerce.fw.ApplicationManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegistrationSteps {
    protected static ApplicationManager app;

    public RegistrationSteps(ApplicationManager app) {
        RegistrationSteps.app = app;
    }

    @Given("Registration page is opened")
    public void openRegistrationPage() {
        app.goToRegistrationPage();
    }

    @When("{string} and {string} for registration are entered")
    public void registerUser(String email, String pwd) {
        app.getRegistrationHelper().enterUserRegistrationCredentials(email, pwd);

    }

    @And("Register button is clicked")
    public void clickRegisterButton() {
        app.getRegistrationHelper().clickRegisterBtn();
    }

    @Then("User is registered")
    public void checkUserIsRegistered() {
        app.getRegistrationHelper().checkUserIsRegisteredAndLoggedIn();
    }

    @Then("Registration error message appears")
    public void errorMessageAppears() {
        app.getRegistrationHelper().hasErrorMsg();
    }

    @Then("Registration alert appears")
    public void registrationAlertAppears() {
        app.getRegistrationHelper().waitForAlert();
    }

    @When("Existing user's {string} and {string} for registration are entered")
    public void enterExistingUserCredentials(String email, String pwd) {
        app.getRegistrationHelper().enterEmail(email);
        app.getRegistrationHelper().enterPassword(pwd);
        app.getRegistrationHelper().confirmPassword(pwd);
    }

}
