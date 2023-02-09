package com.oscarcommerce.glue;

import com.oscarcommerce.fw.ApplicationManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class ItemListContainerSteps {

    public static ApplicationManager app;

    public ItemListContainerSteps(ApplicationManager app){
        ItemListContainerSteps.app = app;
    }

    @When("The shellcoder's handbook item card is opened")
    public void theShellcoderSHandbookItemCardIsOpened() {
        app.getItemListContainerHelper().openShellcoderSHandbookItemCard();
    }


}
