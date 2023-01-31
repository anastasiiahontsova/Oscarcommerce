package com.oscarcommerce.glue;

import com.oscarcommerce.fw.ApplicationManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class AccountSteps {
    protected static ApplicationManager app;

    public AccountSteps(ApplicationManager app) {
        AccountSteps.app = app;
    }

    @Given("Account page is opened")
    public void openAccountPage() {
        app.getAccountHelper().goToAccountPage();
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

    @And("Edit profile button is clicked")
    public void editProfileButtonIsClicked() {
        app.getAccountHelper().clickEditProfileBtn();
    }

    @And("First name field is entered")
    public void firstNameFieldIsEntered() {
        app.getAccountHelper().editFirstName();
    }

    @And("Last name field is entered")
    public void lastNameFieldIsEntered() {
        app.getAccountHelper().editLastName();
    }

    @And("Email address is changed")
    public void emailAddressIsChanged() {
        app.getAccountHelper().editEmail();
    }

    @And("Save button is clicked")
    public void saveButtonIsClicked() {
        app.getAccountHelper().clickSaveBtn();
    }

    @Then("All changes are saved")
    public void allChangesAreSaved() {
        Assert.assertEquals(app.getAccountHelper().verifyProfileUpdatedTextIsPresent(), "Profile updated", "Profile updated message appears");
        Assert.assertEquals(app.getAccountHelper().verifyProfileNameIsCorrect(), "TestName TestLastName", "Updated profile name is correct");
        Assert.assertEquals(app.getAccountHelper().verifyProfileEmailIsCorrect(), "testemail.edited@gmail.com", "Updated profile email is correct");
    }

    @And("Cancel button is clicked")
    public void cancelButtonIsClicked() {
        app.getAccountHelper().clickCancelBtn();
    }

    @Then("All changes are not saved")
    public void allChangesAreNotSaved() throws Exception {
        app.getAccountHelper().verifyProfileNameIsBlank();
        app.getAccountHelper().verifyUserEmailIsCorrectInProfile();
    }
}