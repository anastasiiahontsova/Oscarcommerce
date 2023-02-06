package com.oscarcommerce.glue;

import com.oscarcommerce.fw.ApplicationManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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
        Assert.assertTrue(app.getAccountHelper().verifyLoginAndRegistrationBtnIsPresent(), "Profile is deleted");
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
        app.getAccountHelper().clickSaveUpdateProfileBtn();
    }

    @Then("All changes are saved")
    public void allChangesAreSaved() {
        Assert.assertEquals(app.getAccountHelper().verifyProfileUpdatedTextIsPresent(), "Profile updated", "Profile updated message appears");
        Assert.assertEquals(app.getAccountHelper().verifyProfileNameIsCorrect(), "TestName TestLastName", "Updated profile name is correct");
        Assert.assertEquals(app.getAccountHelper().verifyProfileEmailIsCorrect(), "testemail.edited@gmail.com", "Updated profile email is correct");
    }

    @And("Cancel button is clicked")
    public void cancelButtonIsClicked() {
        app.getAccountHelper().clickCancelUpdateProfileBtn();
    }

    @Then("All changes are not saved")
    public void allChangesAreNotSaved() throws Exception {
        app.getAccountHelper().verifyProfileNameIsBlank();
        app.getAccountHelper().verifyUserEmailIsCorrectInProfile();
    }

    @When("Order History is clicked")
    public void orderHistoryIsClicked() {
        app.getAccountHelper().clickOrderHistoryBtn();
    }

    @Then("You haven't placed any orders message is displayed")
    public void correctOrderHistoryMessageIsDisplayed() {
        Assert.assertEquals(app.getAccountHelper().verifyOrderHistoryMsgIsCorrect(), "You haven't placed any orders.", "Order history message is correct");
    }

    @When("Address Book is clicked")
    public void addressBookIsClicked() {
        app.getAccountHelper().clickAddressBookBtn();
    }

    @Then("There are no addresses in your address book. message is displayed")
    public void correctAddressBookMessageIsDisplayed() {
        Assert.assertEquals(app.getAccountHelper().verifyAddressBookMsgIsCorrect(), "There are no addresses in your address book.", "Address book message is correct");
    }

    @When("Email History is clicked")
    public void emailHistoryIsClicked() {
        app.getAccountHelper().clickEmailHistoryBtn();
    }

    @Then("Thank you for registering. message is displayed")
    public void correctEmailHistoryMessageIsDisplayed() {
        Assert.assertEquals(app.getAccountHelper().verifyEmailHistoryMsgIsCorrect(), "TThank you for registering.", "Email history message is correct");
    }

    @When("Product Alerts is clicked")
    public void productAlertsIsClicked() {
        app.getAccountHelper().clickProductAlertsBtn();
    }

    @Then("You do not have any active alerts for out-of-stock products. message is displayed")
    public void correctProductAlertsMessageIsDisplayed() {
        Assert.assertEquals(app.getAccountHelper().verifyProductAlertsMsgIsCorrect(), "You do not have any active alerts for out-of-stock products.", "Products alert message is correct");
    }

    @When("Notifications is clicked")
    public void notificationsIsClicked() {
        app.getAccountHelper().clickNotificationsBtn();
    }

    @Then("There are no notifications to display. message is displayed")
    public void correctNotificationsMessageIsDisplayed() {
        Assert.assertEquals(app.getAccountHelper().verifyNotificationsMsgIsCorrect(), "There are no notifications to display.", "Notifications message is correct");
    }

    @When("Wish Lists is clicked")
    public void wishListsIsClicked() {
        app.getAccountHelper().clickWishListBtn();
    }

    @Then("You don't have any wish lists yet. message is displayed")
    public void correctWishListMessageIsDisplayed() {
        Assert.assertEquals(app.getAccountHelper().verifyWishListMsgIsCorrect(), "You don't have any wish lists yet.", "Wish list message is correct");

    }

    @And("Add a new address button is clicked")
    public void addANewAddressButtonIsClicked() {
        app.getAccountHelper().clickAddANewAddressBtn();
    }

    @And("All required user's info fields are filled")
    public void allUserSInfoFieldsAreFilled() {
        app.getAccountHelper().fillUserFieldsToAddNewAddress("FirstName","LastName", "FirstLineAddress", "Berlin", "10587");
    }

    @And("Save new address button is clicked")
    public void saveNewAddressButtonIsClicked() {
        app.getAccountHelper().clickSaveNewAddressBtn();
    }

    @Then("New address is saved and displayed on user's profile")
    public void newAddressIsSaved() {
        Assert.assertEquals(app.getAccountHelper().verifyNewAddressIsDisplayed(), "Address 'FirstName LastName, FirstLineAddress, Berlin, 10587, Germany' created", "New address is saved");

    }

    @And("Cancel adding new address button is clicked")
    public void cancelAddingNewAddressButtonIsClicked() {
        app.getAccountHelper().clickCancelAddingNewAddressBtn();
    }

    @And("All user's info fields are filled with invalid data")
    public void allFieldsFilledWithInvalidData() {
        app.getAccountHelper().fillUserFieldsToAddNewAddress("a", "a", "a", "a", "1");
    }

    @Then("Postcode error message is displayed")
    public void newAddressErrorMessageIsDisplayed() {
        Assert.assertEquals(app.getAccountHelper().verifyPostcodeErrorDisplayedIsCorrect(), "The postcode '111' is not valid for Germany", "Postcode error is correct");
    }
}
