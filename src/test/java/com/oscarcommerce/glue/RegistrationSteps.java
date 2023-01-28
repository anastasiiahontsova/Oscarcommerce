package com.oscarcommerce.glue;

import com.oscarcommerce.fw.ApplicationManager;
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

    @And("Register button is clicked")
    public void clickRegisterButton() {
        app.getRegistrationHelper().clickRegisterBtn();
    }

    @Then("User is registered")
    public void checkUserIsRegistered() {
        app.getRegistrationHelper().checkUserIsRegisteredAndLoggedIn();
    }

    @Then("Registration {string} appears")
    public void registrationErrorMessageAppears(String expectedMessage) {
        Assert.assertEquals(app.getRegistrationHelper().hasPasswordErrorMsg(), expectedMessage, "Registration error message appears" );
    }

    @Then("Registration alert appears")
    public void registrationAlertAppears() {
        app.getRegistrationHelper().waitForAlert();
    }

    @When("Existing user's {string} and {string} for registration are entered")
    public void enterExistingUserCredentials(String email, String pwd) {
        app.getRegistrationHelper().enterRegistrationEmail(email);
        app.getRegistrationHelper().enterRegistrationPassword(pwd);
        app.getRegistrationHelper().confirmRegistrationPassword(pwd);
    }
}
