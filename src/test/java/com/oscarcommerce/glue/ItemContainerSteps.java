package com.oscarcommerce.glue;

import com.oscarcommerce.fw.ApplicationManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class ItemContainerSteps {

    protected static ApplicationManager app;

    public ItemContainerSteps(ApplicationManager app){
        ItemContainerSteps.app = app;
    }

    @Given("Item container page is opened")
    public void itemContainerPageIsOpened() {
        app.getItemContainerHelper().goToItemContainerPage();
    }



}
