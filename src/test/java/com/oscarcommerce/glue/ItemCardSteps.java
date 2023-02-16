package com.oscarcommerce.glue;

import com.oscarcommerce.fw.ApplicationManager;
import io.cucumber.java.en.And;

public class ItemCardSteps {

    public static ApplicationManager app;

    public ItemCardSteps(ApplicationManager app){
        ItemCardSteps.app = app;
    }

    @And("Add to basket button is clicked from item card")
    public void addTheShellcoderSHandbookToBasketButtonIsClicked() {
        app.getItemCardHelper().clickAddToBasketBtn();
    }

    @And("Checkout now quick button is clicked")
    public void checkoutNowButtonIsClicked() {
        app.getItemCardHelper().clickCheckOutNowQuickBtn();
    }
}

