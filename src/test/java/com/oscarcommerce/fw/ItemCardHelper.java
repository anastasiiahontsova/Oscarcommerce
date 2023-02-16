package com.oscarcommerce.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.oscarcommerce.fw.ApplicationManager.defaultLanguage;

public class ItemCardHelper extends BaseHelper {

    public static final String ADD_TO_BASKET_BTN_XPATH = "//button[@value='Add to basket']";
    public static final String CHECKOUT_NOW_QUICK_BTN_XPATH = "//a[contains(text(), 'Checkout now')]";

    public ItemCardHelper(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickAddToBasketBtn() {
        click(By.xpath(ADD_TO_BASKET_BTN_XPATH));
    }

    public void clickCheckOutNowQuickBtn() {
        click(By.xpath(CHECKOUT_NOW_QUICK_BTN_XPATH));
    }
}
