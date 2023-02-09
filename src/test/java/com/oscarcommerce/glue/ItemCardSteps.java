package com.oscarcommerce.glue;

import com.oscarcommerce.fw.ApplicationManager;
import io.cucumber.java.en.And;

public class ItemCardSteps {

    public static ApplicationManager app;

    public ItemCardSteps(ApplicationManager app){
        ItemCardSteps.app = app;
    }

    @And("Add The shellcoder's handbook to basket button is clicked")
    public void addTheShellcoderSHandbookToBasketButtonIsClicked() {
        app.getItemCardHelper().clickAddToBasketBtn();
    }

    @And("Checkout now quick button is clicked")
    public void checkoutNowButtonIsClicked() {
        app.getItemCardHelper().clickCheckOutNowQuickBtn();
    }
}

