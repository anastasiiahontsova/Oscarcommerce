package com.oscarcommerce.glue;

import com.oscarcommerce.fw.ApplicationManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AccountSteps {
    protected static ApplicationManager app;

    public AccountSteps(ApplicationManager app) {
        AccountSteps.app = app;
    }

    @Given("Account page is opened")
    public void openAccountPage() {
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

    @And("Profile email coincides with the registered one")
    public void profileEmailCoincidesWithTheRegisteredOne() {
        app.getAccountHelper().verifyUserEmailIsCorrectInProfile();
    }

    @And("Delete profile button is clicked")
    public void deleteUserProfile() {
        app.getAccountHelper().deleteUserAccount();

    }

    @Then("Profile is deleted")
    public void verifyProfileIsDeleted() {
        app.getAccountHelper().verifyLoginAndRegistrationBtnIsPresent();
    }


}