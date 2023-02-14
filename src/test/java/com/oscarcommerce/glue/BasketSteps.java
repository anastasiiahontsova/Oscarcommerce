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

    @Then("The correct price is shown in basket total")
    public void theCorrectPriceIsShownInBasketTotal() {
        Assert.assertEquals(app.getBasketHelper().getBasketCartTotalPrice(), "£9.99", "The Basket total displays the correct price.");
    }


    @And("Basket cart is opened")
    public void basketCartIsOpened() {
        app.getBasketHelper().openBasketCart();
    }

    @When("Scrolled down to The shellcoder's handbook")
    public void scrolledDownToTheShellcoderSHandbook() {
        app.getItemListContainerHelper().scrollToTheShellcoderSHandbook();
    }
}
