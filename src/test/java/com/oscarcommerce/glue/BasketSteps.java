package com.oscarcommerce.glue;

import com.oscarcommerce.fw.ApplicationManager;
import io.cucumber.java.en.Given;

public class BasketSteps {

    protected static ApplicationManager app;

    public BasketSteps(ApplicationManager app) {
        BasketSteps.app = app;
    }


}
