package com.oscarcommerce.glue;

import com.oscarcommerce.fw.ApplicationManager;
import com.oscarcommerce.utils.ShippingAddress;
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
        app.getAccountHelper().clickAccountBtn();
    }

    @And("Profile page is visible")
    public void verifyProfilePageIsVisible() {
        app.getAccountHelper().checkProfilePageIsVisible();
    }

    @Then("Profile name is blank")
    public void profileNameIsBlank() throws Exception {
        Assert.assertEquals(app.getAccountHelper().getProfileNameText(), "-", "Profile name is blank");
    }

    @Then("Profile email matches the registered one")
    public void profileEmailCoincidesWithTheRegisteredOne() {
        Assert.assertEquals(app.getAccountHelper().getUserEmailIsCorrectInProfile(), app.getCurrentUser().getEmail(), "The email coincides with the one in the profile");;
    }

    @And("Delete profile button is clicked")
    public void deleteUserProfile() {
        app.getAccountHelper().deleteUserAccount();

    }

    @Then("Profile is deleted")
    public void verifyProfileIsDeleted() {
        Assert.assertTrue(app.getAccountHelper().getLoginAndRegistrationBtn(), "Profile is deleted");
    }

    @And("Edit profile button is clicked")
    public void editProfileButtonIsClicked() {
        app.getAccountHelper().clickEditProfileBtn();
    }

    @And("Firstname {string} and lastname {string} are entered")
    public void firstnameAndLastnameAreEntered(String firstName, String lastname) {
        app.getAccountHelper().enterFirstName(firstName);
        app.getAccountHelper().enterLastName(lastname);
        app.getCurrentUser().setName(firstName);
        app.getCurrentUser().setLastName(lastname);
    }

    @And("{string} email is entered")
    public void emailAddressIsChanged(String email) {
        app.getAccountHelper().enterEmail(email);
        app.getCurrentUser().setEmail(email);
    }

    @And("Save button is clicked")
    public void saveButtonIsClicked() {
        app.getAccountHelper().clickSaveUpdateProfileBtn();
    }

    @Then("All changes are saved")
    public void allChangesAreSaved() {
        Assert.assertEquals(app.getAccountHelper().getProfileUpdatedText(), "Profile updated", "Profile updated message appears");
        Assert.assertEquals(app.getAccountHelper().getProfileName(), app.getCurrentUser().getName() + " " + app.getCurrentUser().getLastName(), "Updated profile name is correct");
        Assert.assertEquals(app.getAccountHelper().getProfileEmail(), "edited.email@gmail.com", "Updated profile email is correct");
    }

    @And("Cancel button is clicked")
    public void cancelButtonIsClicked() {
        app.getAccountHelper().clickCancelUpdateProfileBtn();
    }

    @Then("All changes are not saved")
    public void allChangesAreNotSaved()  {
        ShippingAddress expectedProfileName = app.getCurrentUser().getShippingAddresses(0);
        Assert.assertEquals(app.getAccountHelper().getProfileNameText(), expectedProfileName.getName() + " " + expectedProfileName.getLastName());
        Assert.assertEquals(app.getAccountHelper().getProfileEmail(), app.getCurrentUser().getEmail(), "Updated profile email is correct");
    }

    @When("Order History is clicked")
    public void orderHistoryIsClicked() {
        app.getAccountHelper().clickOrderHistoryBtn();
    }

    @Then("You haven't placed any orders message is displayed")
    public void correctOrderHistoryMessageIsDisplayed() {
        Assert.assertEquals(app.getAccountHelper().getOrderHistoryMsg(), "You haven't placed any orders.", "Order history message is correct");
    }

    @When("Address Book is clicked")
    public void addressBookIsClicked() {
        app.getAccountHelper().clickAddressBookBtn();
    }

    @Then("There are no addresses in your address book message is displayed")
    public void correctAddressBookMessageIsDisplayed() {
        Assert.assertEquals(app.getAccountHelper().getAddressBookMsg(), "There are no addresses in your address book.", "Address book message is correct");
    }

    @When("Email History is clicked")
    public void emailHistoryIsClicked() {
        app.getAccountHelper().clickEmailHistoryBtn();
    }

    @Then("Thank you for registering message is displayed")
    public void correctEmailHistoryMessageIsDisplayed() {
        Assert.assertEquals(app.getAccountHelper().getEmailHistoryMsg(), "Thank you for registering.", "Email history message is correct");
    }

    @When("Product Alerts is clicked")
    public void productAlertsIsClicked() {
        app.getAccountHelper().clickProductAlertsBtn();
    }

    @Then("You do not have any active alerts for out-of-stock products message is displayed")
    public void correctProductAlertsMessageIsDisplayed() {
        Assert.assertEquals(app.getAccountHelper().getProductAlertsMsg(), "You do not have any active alerts for out-of-stock products.", "Products alert message is correct");
    }

    @When("Notifications is clicked")
    public void notificationsIsClicked() {
        app.getAccountHelper().clickNotificationsBtn();
    }

    @Then("There are no notifications to display message is displayed")
    public void correctNotificationsMessageIsDisplayed() {
        Assert.assertEquals(app.getAccountHelper().getNotificationsMsg(), "There are no notifications to display.", "Notifications message is correct");
    }

    @When("Wish Lists is clicked")
    public void wishListsIsClicked() {
        app.getAccountHelper().clickWishListBtn();
    }

    @Then("Create a new new wish list button is present")
    public void correctWishListMessageIsDisplayed() {
        Assert.assertTrue(app.getAccountHelper().getANewWishListBtnSize(), "Create a new wish list button is present");

    }

    @And("Add a new address button is clicked")
    public void addANewAddressButtonIsClicked() {
        app.getAccountHelper().clickAddANewAddressBtn();
    }

    @And("Save new address button is clicked")
    public void saveNewAddressButtonIsClicked() {
        app.getAccountHelper().clickSaveNewAddressBtn();
    }

    @Then("New address is saved and displayed on user's profile")
    public void newAddressIsSaved() {
        ShippingAddress expectedShippingAddress = app.getCurrentUser().getShippingAddresses(0);
        Assert.assertEquals(app.getAccountHelper().getShippingAddressInfo(), expectedShippingAddress.getName()
                + " " + expectedShippingAddress.getLastName()
                + " " + expectedShippingAddress.getFirstLineAddress()
                + " " + expectedShippingAddress.getCity()
                + " " + expectedShippingAddress.getPostcode(),
                "Current shipping name is: " + expectedShippingAddress.getName()
                        + " " + expectedShippingAddress.getLastName()
                        + " " + expectedShippingAddress.getFirstLineAddress()
                        + " " + expectedShippingAddress.getCity()
                        + " " + expectedShippingAddress.getPostcode());
    }


    @Then("Postcode error message is displayed")
    public void newAddressErrorMessageIsDisplayed() {
        Assert.assertEquals(app.getAccountHelper().getPostcodeError(), "The postcode '111' is not valid for Germany", "Postcode error is correct");
    }

    @And("Enter {string}, {string}, {string}, {string}, {string} into shipping address fields")
    public void enterIntoShippingAddressFields(String name, String lastName, String firstLineAddress, String city, String postcode) {
        app.getAccountHelper().fillUserFieldsToAddNewAddress(name, lastName, firstLineAddress, city, postcode);
        app.getCurrentUser().addShippingAddress(name, lastName, firstLineAddress, city, postcode);
    }


}
