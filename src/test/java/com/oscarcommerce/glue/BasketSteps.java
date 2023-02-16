package com.oscarcommerce.glue;

import com.oscarcommerce.fw.ApplicationManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class BasketSteps {

    protected static ApplicationManager app;

    public BasketSteps(ApplicationManager app) {
        BasketSteps.app = app;
    }


    @And("View basket button is clicked")
    public void viewBasketBtnIsClicked() {
        app.getBasketHelper().viewBasketBtnIsClicked();
    }


    @When("Scrolled down to {string}")
    public void scrolledDownTo(String bookTitle) {
        app.getItemListContainerHelper().scrollToAddToBasketBtn(bookTitle);
    }

    @And("Item Quantity is increased to {string} items")
    public void itemQuantityIsIncreasedToItems(String itemNumber) {
        app.getBasketHelper().enterItemQuantity(itemNumber);
    }

    @And("Update button is clicked")
    public void updateButtonIsClicked() {
        app.getBasketHelper().clickUpdateBtn();
    }

    @Then("{string} price is shown in basket total")
    public void priceIsShownInBasketTotal(String priceTotal) {
        //todo explicit wait
        Assert.assertEquals(app.getBasketHelper().getBasketTotalPrice(), priceTotal, "The Basket total displays the correct price.");
    }


    @And("Enter email address page is opened")
    public void enterEmailAddressPageIsOpened() {

    }

    @And("Email address is entered")
    public void emailAddressIsEntered() {
        app.getBasketHelper().enterEmail();
    }

    @And("Continue button is clicked")
    public void continueButtonIsClicked() {
        app.getBasketHelper().clickContinueBtn();
    }

    @And("Continue to Preview order button is clicked")
    public void continueToPreviewOrderButtonIsClicked() {

    }

    @And("Enter payment details")
    public void enterPaymentDetails() {
    }

    @And("Preview order page is opened")
    public void previewOrderPageIsOpened() {
        Assert.assertTrue(app.getBasketHelper().verifyPreviewOrderPageIsOpened(), "Preview Order Page is opened");
    }

    @And("Place order button is clicked")
    public void placeOrderButtonIsClicked() {
        app.getBasketHelper().clickPlaceOrderBtn();
    }


    @Then("Confirmation page appears")
    public void confirmationPageIsOpened() {
        Assert.assertTrue(app.getBasketHelper().verifyConfirmationPageAppears(), "Confirmation Page appears");
    }

    @And("The pop-up message that item has been added to basket is displayed")
    public void itemHasBeenAddedToBasketIsDisplayed() {
        Assert.assertEquals(app.getItemListContainerHelper().getItemHasBeenAddedMsg(), "×\n" +
                "The shellcoder's handbook has been added to your basket.", "Item has been added to basket message is present");
    }


    @Then("The pop-up message that basket total has correct price is displayed")
    public void thePopUpMessageThatBasketTotalHasCorrectPriceIsDisplayed() {
        Assert.assertEquals(app.getItemListContainerHelper().getItemHasBeenAddedMsg(), "×\n" +
                "The shellcoder's handbook has been added to your basket.", "The pop-up message that basket total has correct price is displayed");
    }

    @And("Enter {string}, {string}, {string}, {string}, {string} into checkout shipping address fields")
    public void enterIntoCheckoutShippingAddressFields(String name, String lastName, String firstLineAddress, String city, String postcode) {
        app.getBasketHelper().fillShippingAddressFields(name, lastName, firstLineAddress, city, postcode);
        app.getCurrentUser().addShippingAddress(name, lastName, firstLineAddress, city, postcode);
    }


//    @Then("Quick Buttons View basket and Checkout now are displayed and clickable")
//    public void viewBasketAndCheckoutNowBtnAreDisplayed() {
//        Assert.assertTrue(app.getItemListContainerHelper().elementIsPresent(), "", "");
//        Assert.assertTrue(app.getItemListContainerHelper().elementIsPresent(), "", "");
//    }


}
