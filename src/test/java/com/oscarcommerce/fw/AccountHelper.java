package com.oscarcommerce.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AccountHelper extends BaseHelper {


    public static final String DELETE_PROFILE_BTN_ID = "delete_profile";
    public static final String PROFILE_NAME_TABLE_FIELD_XPATH = "//table[@class='table table-striped table-bordered']/tbody[1]/tr[1]/td[1]";
    public static final String PROFILE_EMAIL_TABLE_FIELD_XPATH = "//*[@id='default']/div/div/div/div/table/tbody/tr[2]/td";
    public static final String EXPECTED_USER_EMAIL_STR = "testemail@gmail.com";
    public static final String PROFILE_DELETE_PROFILE_BTN_ID = "delete_profile";
    public static final String PROFILE_PASSWORD_FIELD_ID = "id_password";
    public static final String PROFILE_FINAL_DELETE_PROFILE_BTN_XPATH = "//button[contains(text(),'Delete')]";
    public static final String PROFILE_DELETED_MSG_ID = "messages";
    public static final String LOGIN_BTN_ID = "login_link";
    public static final String EDIT_PROFILE_BTN_XPATH = "//a[@href='/en-gb/accounts/profile/edit/']";
    public static final String PROFILE_EDIT_FIRST_NAME_FIELD_ID = "id_first_name";
    public static final String PROFILE_EDIT_LAST_NAME_FIELD_ID = "id_last_name";
    public static final String NAME_TO_UPDATE_USER_NAME_STR = "TestName";
    public static final String LAST_NAME_TO_UPDATE_USER_LAST_NAME_STR = "TestLastName";
    public static final String PROFILE_EDIT_EMAIL_FIELD_ID = "id_email";
    public static final String EMAIL_TO_UPDATE_USER_EMAIL_STR = "testemail.edited@gmail.com";
    public static final String SAVE_BTN_TO_UPDATE_PROFILE_INFO_XPATH = "//button[contains(text(), 'Save')]";
    public static final String PROFILE_UPDATED_MSG_FIELD_XPATH = "//div[@class='alertinner wicon']";
    public static final String CANCEL_BTN_TO_UPDATE_USER_PROFILE_INFO_XPATH = "//a[@href='#'][contains(text(), 'cancel')]";
    public static final String ORDER_HISTORY_BTN_XPATH = "//a[@href='/en-gb/accounts/orders/']";
    public static final String ORDER_HISTORY_MSG_ID = "messages";
    public static final String ADDRESS_BOOK_BTN_XPATH = "//a[@href='/en-gb/accounts/addresses/']";
    public static final String ADDRESS_BOOK_MSG_ID = "messages";
    public static final String EMAIL_HISTORY_BTN_XPATH = "//a[@href='/en-gb/accounts/emails/']";
    public static final String EMAIL_HISTORY_MSG_XPATH = "//a[@href='/en-gb/accounts/emails/2/']";
    public static final String PRODUCT_ALERT_BTN_XPATH = "//a[@href='/en-gb/accounts/alerts/']";
    public static final String PRODUCTS_ALERT_MSG_ID = "messages";
    public static final String NOTIFICATIONS_BTN_XPATH = "//a[@href='/en-gb/accounts/notifications/inbox/']";
    public static final String NOTIFICATIONS_MSG_ID = "messages";
    public static final String WISH_LIST_BTN_XPATH = "//a[@href='/en-gb/accounts/wishlists/']";
    public static final String WISH_LIST_MSG_ID = "messages";
    public static final String ADD_A_NEW_ADDRESS_BTN_XPATH = "//a[@href='/en-gb/accounts/addresses/add/']";

    public AccountHelper(WebDriver webDriver) {
        super(webDriver);
    }


    public void checkProfilePageIsVisible() {
        waitForElementToBeVisible(By.id(DELETE_PROFILE_BTN_ID));
    }

    public boolean verifyProfileNameIsBlank() throws Exception {
        if (webDriver.findElement(By.xpath(PROFILE_NAME_TABLE_FIELD_XPATH)).getText() == "-") {
            return true;
        }
        return false;
    }

    public void goToAccountPage() {
        goToAccountPage();

    }

    public void verifyUserEmailIsCorrectInProfile() {
        String actualEmail = webDriver.findElement(By.xpath(PROFILE_EMAIL_TABLE_FIELD_XPATH)).getText();
        Assert.assertEquals(actualEmail, EXPECTED_USER_EMAIL_STR, "The email coincides with the one in the profile");
    }

    public void deleteUserAccount() {
        click(By.id(PROFILE_DELETE_PROFILE_BTN_ID));
        type(By.id(PROFILE_PASSWORD_FIELD_ID), VALID_PASSWORD);
        click(By.xpath(PROFILE_FINAL_DELETE_PROFILE_BTN_XPATH));
        waitForElementToBeVisible(By.id(PROFILE_DELETED_MSG_ID));
    }

    public boolean verifyLoginAndRegistrationBtnIsPresent() {
        return elementIsPresent(By.id(LOGIN_BTN_ID));
    }

    public void clickEditProfileBtn() {
        click(By.xpath(EDIT_PROFILE_BTN_XPATH));
    }

    public void editFirstName() {
        clearAndType(By.id(PROFILE_EDIT_FIRST_NAME_FIELD_ID), NAME_TO_UPDATE_USER_NAME_STR);
    }

    public void editLastName() {
        clearAndType(By.id(PROFILE_EDIT_LAST_NAME_FIELD_ID), LAST_NAME_TO_UPDATE_USER_LAST_NAME_STR);
    }

    public void editEmail() {
        clearAndType(By.id(PROFILE_EDIT_EMAIL_FIELD_ID), EMAIL_TO_UPDATE_USER_EMAIL_STR);
    }

    public void clickSaveUpdateProfileBtn() {
        click(By.xpath(SAVE_BTN_TO_UPDATE_PROFILE_INFO_XPATH));
    }

    public String verifyProfileUpdatedTextIsPresent() {
        return hasText(By.xpath(PROFILE_UPDATED_MSG_FIELD_XPATH));
    }

    public String verifyProfileNameIsCorrect() {
        return hasText(By.xpath(PROFILE_NAME_TABLE_FIELD_XPATH));
    }

    public String verifyProfileEmailIsCorrect() {
        return hasText(By.xpath(PROFILE_EMAIL_TABLE_FIELD_XPATH));
    }

    public void clickCancelUpdateProfileBtn() {
        click(By.xpath(CANCEL_BTN_TO_UPDATE_USER_PROFILE_INFO_XPATH));
    }

    public void clickOrderHistoryBtn() {
        click(By.xpath(ORDER_HISTORY_BTN_XPATH));
    }

    public String verifyOrderHistoryMsgIsCorrect() {
        return hasText(By.id(ORDER_HISTORY_MSG_ID));
    }

    public void clickAddressBookBtn() {
        click(By.xpath(ADDRESS_BOOK_BTN_XPATH));
    }

    public String verifyAddressBookMsgIsCorrect() {
        return hasText(By.id(ADDRESS_BOOK_MSG_ID));
    }

    public void clickEmailHistoryBtn() {
        click(By.xpath(EMAIL_HISTORY_BTN_XPATH));
    }

    public String verifyEmailHistoryMsgIsCorrect() {
        return hasText(By.xpath(EMAIL_HISTORY_MSG_XPATH));
    }

    public void clickProductAlertsBtn() {
        click(By.xpath(PRODUCT_ALERT_BTN_XPATH));
    }

    public String verifyProductAlertsMsgIsCorrect() {
        return hasText(By.id(PRODUCTS_ALERT_MSG_ID));
    }

    public void clickNotificationsBtn() {
        click(By.xpath(NOTIFICATIONS_BTN_XPATH));
    }

    public String verifyNotificationsMsgIsCorrect() {
        return hasText(By.id(NOTIFICATIONS_MSG_ID));
    }

    public void clickWishListBtn() {
        click(By.xpath(WISH_LIST_BTN_XPATH));
    }

    public String verifyWishListMsgIsCorrect() {
        return hasText(By.id(WISH_LIST_MSG_ID));
    }

    public void clickAddANewAddressBtn() {
        click(By.xpath(ADD_A_NEW_ADDRESS_BTN_XPATH));
    }

    public void fillUserFieldsToAddNewAddress(String firstName, String lastName, String firstAddress, String city, String postcode) {
        clearAndType(By.id("id_first_name"), firstName);
        clearAndType(By.id("id_last_name"), lastName);
        clearAndType(By.id("id_line1"), firstAddress);
        clearAndType(By.id("id_line4"), city);
        clearAndType(By.id("id_postcode"), postcode);
        click(By.id("id_country"));
        click((By.cssSelector("value='DE'")));

    }

    public void clickSaveNewAddressBtn() {
        click(By.xpath("//button[contains(text(), 'Save')]"));
    }


    public String verifyNewAddressIsDisplayed() {
        return hasText(By.cssSelector("[class='alertinner wicon']"));
    }

    public void clickCancelAddingNewAddressBtn() {
        click(By.xpath("//a[contains(text(),'cancel')]"));
    }
}