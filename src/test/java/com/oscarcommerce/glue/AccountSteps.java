package com.oscarcommerce.glue;

import com.oscarcommerce.fw.ApplicationManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AccountSteps {
    protected static ApplicationManager app;

    public AccountSteps(ApplicationManager app) {
        AccountSteps.app = app;
    }

    @Given("Login and Registration page is opened")
    public void openLoginAndRegistrationPage() {
        app.goToLoginAndRegistrationPage();
    }

    @And("Account button is clicked")
    public void accountButtonIsClicked() {
        app.getAccountHelper().clickAccountBtn();
    }

    @And("Profile page is visible")
    public void verifyProfilePageIsVisible() {
        app.getAccountHelper().checkProfilePageIsVisible();
    }

    @Then("Profile name is blank")
    public void profileNameIsBlank() throws Exception {
        app.getAccountHelper().verifyProfileNameIsBlank();
    }

    @And("Login btn is clicked")
    public void loginBtnIsClicked() {
        app.getAccountHelper().clickLoginBtn();
    }

    @And("Profile email coincides with the registered one")
    public void profileEmailCoincidesWithTheRegisteredOne() {
        app.getAccountHelper().verifyUserEmailIsCorrectInProfile();
    }

//    @And("Date registered is correct")
//    public void dateRegisteredIsCorrect() {
//        app.getAccountHelper().verifyDateRegistredIsCorrect();
//    }

    @And("Delete profile button is clicked")
    public void deleteUserProfile() {
        app.getAccountHelper().deleteUserProfile();

    }

    @Then("Profile is deleted")
    public void verifyProfileIsDeleted() {
        app.getAccountHelper().verifyLoginAndRegistrationBtnIsPresent();
    }


    @When("User is registered and logged in with {string} and {string}")
    public void registerAndLogInUser(String email, String pwd) {
        app.getAccountHelper().enterUserRegistrationCredentials(email, pwd);
        app.getAccountHelper().clickRegisterBtn();

    }

}
