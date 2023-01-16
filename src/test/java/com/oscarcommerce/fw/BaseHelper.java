package com.oscarcommerce.fw;

import org.openqa.selenium.WebDriver;

public class BaseHelper {
    protected WebDriver webDriver;

    public BaseHelper(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
}
