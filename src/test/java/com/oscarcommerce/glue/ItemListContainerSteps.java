package com.oscarcommerce.glue;

import com.oscarcommerce.fw.ApplicationManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class ItemListContainerSteps {

    public static ApplicationManager app;

    public ItemListContainerSteps(ApplicationManager app){
        ItemListContainerSteps.app = app;
    }


    @When("Item card {string} is opened")
    public void itemCardIsOpened(String bookTitle) {
        app.getItemListContainerHelper().openItemCard(bookTitle);
    }

    @And("Add to basket button is clicked from item list container")
    public void addToBasketButtonIsClicked() {
        app.getItemListContainerHelper().clickAddToBasketBtn();
    }


}
