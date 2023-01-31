package com.oscarcommerce.glue;

import com.oscarcommerce.fw.ApplicationManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
    protected static ApplicationManager app;
    String validUserEmail = "testemail@gmail.com";
    String validUserPwd = "validPassword1!";


    public Hooks(ApplicationManager app) {
        Hooks.app = app;
    }

    @Before(value = "@requiresLogin")
    public void loginUserBeforeScenario(Scenario scenario) {
        app.goToLoginAndRegistrationPage();
        app.getLoginHelper().enterLoginEmail(validUserEmail);
        app.getLoginHelper().enterLoginPassword(validUserPwd);
        app.getLoginHelper().clickLoginBtn();
    }

    @Before(value = "@requiresRegistrationAndLogin")
    public void registerAndLoginUserBeforeScenario(Scenario scenario) {
        app.goToLoginAndRegistrationPage();
        app.getRegistrationHelper().enterUserRegistrationCredentials(validUserEmail, validUserPwd);
        app.getRegistrationHelper().clickRegisterBtn();
        System.out.println("User is logged in");
    }

    @Before(value = "@requiresRegistrationWithoutLogIn")
    public void registerUserBeforeScenario(Scenario scenario) {
        app.goToLoginAndRegistrationPage();
        app.getRegistrationHelper().enterUserRegistrationCredentials(validUserEmail, validUserPwd);
        app.getRegistrationHelper().clickRegisterBtn();
        app.getRegistrationHelper().logOutUser();
        System.out.println("User is registered");
    }

    @After(value = "@loginsAndDeletesUserAccount", order = 3)
    public void loginAndDeleteUserAccount() {
        app.goToLoginAndRegistrationPage();
        app.getLoginHelper().enterLoginEmail(validUserEmail);
        app.getLoginHelper().enterLoginPassword(validUserPwd);
        app.getLoginHelper().clickLoginBtn();
        app.goToAccountPage();
        app.getAccountHelper().deleteUserAccount();
        System.out.println("Account is deleted");
    }

    @After(value = "@deletesUserAccount", order = 3)
    public void deleteUserAccount() {
        app.goToAccountPage();
        app.getAccountHelper().deleteUserAccount();
        System.out.println("Account is deleted");
    }

//    @After(order = 2)
//    public void takeScreenshot() {
//        app.takeScreenShot();
//        app.takeScreenshotWithScrollDown();
//    }

    @After(order = 1)
    public void closeApp() {
        app.stopApp();
        System.out.println("After is called!");
    }


//    @After("@browser and not @headless")
//    public void doSomethingAfter(Scenario scenario){
//        scenario.isFailed();
//    }

}