package com.oscarcommerce.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasketHelper extends BaseHelper {
    public BasketHelper(WebDriver webDriver) {
        super(webDriver);
    }

    public String getBasketCartTotalPrice() {
        return getText(By.xpath("//span[contains(text(), 'Total:')]"));
    }

    public void openBasketCart() {
        click(By.xpath("//button[@class='btn btn-outline-secondary']"));
    }

}


