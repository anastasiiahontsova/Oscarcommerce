package com.oscarcommerce.glue;

import com.oscarcommerce.fw.ApplicationManager;
import com.oscarcommerce.fw.BaseHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import static com.oscarcommerce.fw.RegistrationHelper.EXISTING_USER_ERROR_MSG;

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

    @Then("Existing user registration error message appears")
    public void existingUserRegistrationErrorMessageAppears() {
        Assert.assertEquals(app.getRegistrationHelper().hasPasswordErrorMsg(), EXISTING_USER_ERROR_MSG, "Registration error message appears");
    }
}