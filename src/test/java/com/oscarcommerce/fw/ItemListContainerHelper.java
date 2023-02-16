package com.oscarcommerce.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.oscarcommerce.fw.ApplicationManager.defaultLanguage;

public class ItemListContainerHelper extends BaseHelper {

    public static final String BOOK_THE_SHELLCODERS_HANDBOOK_XPATH = "//a[@href='" + defaultLanguage + "/catalogue/the-shellcoders-handbook_209/']";

    public ItemListContainerHelper(WebDriver webDriver) {
        super(webDriver);
    }

    public void openItemCard(String bookTitle) {
        click(By.xpath(BOOK_THE_SHELLCODERS_HANDBOOK_XPATH));
    }


    public void clickAddToBasketBtn() {
        click(By.xpath("//form[@action='" + defaultLanguage + "/basket/add/209/']+//"));
    }

    public void scrollToAddToBasketBtn(String bookTitle) {
        scrollToElement(By.xpath("//form[@action='" + defaultLanguage + "/basket/add/209/']"), 400);
    }
}
