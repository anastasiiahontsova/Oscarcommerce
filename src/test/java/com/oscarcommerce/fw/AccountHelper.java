package com.oscarcommerce.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AccountHelper extends BaseHelper {

    public static final String VALID_PASSWORD = "validPassword1!";

    public AccountHelper(WebDriver webDriver) {
        super(webDriver);
    }

    public void enterUserRegistrationCredentials(String email, String pwd) {
        type(By.id("id_registration-email"), email);
        type(By.id("id_registration-password1"), pwd);
        type(By.id("id_registration-password2"), pwd);
    }

    public void clickRegisterBtn() {
        click(By.cssSelector("button[name='registration_submit']"));
    }

    public void checkProfilePageIsVisible() {
        waitForElementToBeVisible(By.id("delete_profile"));
    }

    public boolean verifyProfileNameIsBlank() throws Exception {
        if (webDriver.findElement(By.xpath("//table[@class='table table-striped table-bordered']/tbody[1]/tr[1]/td[1]")).getText() == "-") {
            return true;
        }
        return false;
    }

    public void clickAccountBtn() {
        click(By.xpath("//*[@id='top_page']/div/div/ul/li[1]/a"));

    }

    public void clickLoginBtn() {
        click(By.cssSelector("button[name='login_submit']"));
    }

    public void verifyUserEmailIsCorrectInProfile() {
        String actualEmail = webDriver.findElement(By.xpath("//*[@id='default']/div/div/div/div/table/tbody/tr[2]/td")).getText();
        Assert.assertEquals(actualEmail, "email@gmail.com", "The email coincides with the one in the profile");
    }

  //  public String verifyDateRegistredIsCorrect() {
//        String actualDate = webDriver.findElement(By.xpath("//*[@id='default']/div/div/div/div/table/tbody/tr[3]/td")).getText();
//        Assert.assertEquals(actualDate, "21 Jan 2023, 9:27 p.m.", "Registered date in Profile is correct");
//    }

    public void deleteUserProfile() {
        click(By.id("delete_profile"));
        type(By.id("id_password"), VALID_PASSWORD);
        click(By.xpath("//button[contains(text(),'Delete')]"));

    }

    public void verifyLoginAndRegistrationBtnIsPresent() {
        Assert.assertTrue(elementIsPresent(By.id("login_link")));
    }


}