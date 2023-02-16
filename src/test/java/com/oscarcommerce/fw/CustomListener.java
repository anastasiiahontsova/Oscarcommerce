package com.oscarcommerce.fw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomListener implements WebDriverListener {
    protected Logger logger = LoggerFactory.getLogger(CustomListener.class);

    public CustomListener() {
        super();
    }

    @Override
    public void beforeQuit(WebDriver driver) {
        logger.info("Closing/quitting the browser!");
    }
}
