package com.oscarcommerce.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class BasketHelper extends BaseHelper {

    public static final String VIEW_BASKET_BTN_XPATH = "//button[@class='btn btn-outline-secondary']";
    public static final String BASKET_TOTAL_PRICE_XPATH = "//div[@class='col-md-2'][2]";
    public static final String ITEM_QUANTITY_FIELD_ID = "id_form-0-quantity";
    public static final String UPDATE_QUANTITY_BTN_XPATH = "//button[contains(text(), 'Update')]";
    public static final String PLACE_ORDER_BTN_ID = "place-order";
    public static final String VIEW_ORDER_STATUS_BTN_XPATH = "//a[contains(text(), 'View order status')])";

    public BasketHelper(WebDriver webDriver) {
        super(webDriver);
    }

    public String getBasketTotalPrice() {
        return getText(By.xpath(BASKET_TOTAL_PRICE_XPATH));
    }

    public void viewBasketBtnIsClicked() {
        click(By.xpath(VIEW_BASKET_BTN_XPATH));
    }

    public void enterItemQuantity(String itemNumber) {
        clearAndType(By.id(ITEM_QUANTITY_FIELD_ID), itemNumber);
    }

    public void clickUpdateBtn() {
        click(By.xpath(UPDATE_QUANTITY_BTN_XPATH));
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void enterEmail() {
        clearAndType(By.id("id_username"), "useremail@gmail.com");
    }

    public void clickContinueBtn() {
        click(By.xpath("//button[@class='btn btn-lg btn-block btn-primary']"));
    }

    public void clickPlaceOrderBtn() {
        click(By.id(PLACE_ORDER_BTN_ID));
    }

    public boolean verifyPreviewOrderPageIsOpened() {
        return elementIsPresent(By.id(PLACE_ORDER_BTN_ID));
    }

    public boolean verifyConfirmationPageAppears() {
        return elementIsPresent(By.xpath(VIEW_ORDER_STATUS_BTN_XPATH));
    }
}


