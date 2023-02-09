package com.oscarcommerce.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ItemListContainerHelper extends BaseHelper {

    public static final String BOOK_THE_SHELLCODERS_HANDBOOK_XPATH = "//a[@href='/en-gb/catalogue/the-shellcoders-handbook_209/']";

    public ItemListContainerHelper(WebDriver webDriver) {
        super(webDriver);
    }

    public void openShellcoderSHandbookItemCard() {
        click(By.xpath(BOOK_THE_SHELLCODERS_HANDBOOK_XPATH));
    }
}
