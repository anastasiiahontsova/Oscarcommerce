package com.oscarcommerce.glue;

import com.oscarcommerce.fw.ApplicationManager;
import com.oscarcommerce.fw.BaseHelper;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
    protected static ApplicationManager app;

    public Hooks(ApplicationManager app) {
        Hooks.app = app;
    }

    @Before(value = "@requiresLogin")
    public void loginUserBeforeScenario(Scenario scenario) {
        app.goToLoginAndRegistrationPage();
        app.getLoginHelper().enterLoginEmail(app.getCurrentUser().getEmail());
        app.getLoginHelper().enterLoginPassword(app.getCurrentUser().getPassword());
        app.getLoginHelper().clickLoginBtn();
    }

    @Before(value = "@requiresRegistrationAndLogin")
    public void registerAndLoginUserBeforeScenario(Scenario scenario) {
        app.goToLoginAndRegistrationPage();
        app.getRegistrationHelper().enterUserRegistrationCredentials(app.getCurrentUser().getEmail(), app.getCurrentUser().getPassword());
        app.getRegistrationHelper().clickRegisterBtn();
        System.out.println("User is logged in");
    }

    @Before(value = "@requiresRegistrationWithoutLogIn")
    public void registerUserBeforeScenario(Scenario scenario) {
        app.goToLoginAndRegistrationPage();
        app.getRegistrationHelper().enterUserRegistrationCredentials(app.getCurrentUser().getEmail(), app.getCurrentUser().getPassword());
        app.getRegistrationHelper().clickRegisterBtn();
        app.getRegistrationHelper().logOutUser();
        System.out.println("User is registered and logged out");
    }


    @After(value = "@loginsAndDeletesUserAccount", order = 5)
    public void loginAndDeleteUserAccount() {
        app.goToLoginAndRegistrationPage();
        app.getLoginHelper().enterLoginEmail(app.getCurrentUser().getEmail());
        app.getLoginHelper().enterLoginPassword(app.getCurrentUser().getPassword());
        app.getLoginHelper().clickLoginBtn();
        app.goToAccountPage();
        app.getAccountHelper().deleteUserAccount();
        System.out.println("Account is deleted");
    }

    @After(value = "@deletesUserAccount", order = 4)
    public void deleteUserAccount() {
        app.goToAccountPage();
        app.getAccountHelper().deleteUserAccount();
        System.out.println("Account is deleted");
    }

    @After(value = "@deletesExistingUserAccount", order = 3)
    public void deleteExistingUserAccount() {
        app.goToLoginAndRegistrationPage();
        app.getLoginHelper().enterLoginEmail(BaseHelper.VALID_EMAIL);
        app.getLoginHelper().enterLoginPassword(BaseHelper.VALID_PASSWORD);
        app.getLoginHelper().clickLoginBtn();
        app.goToAccountPage();
        app.getAccountHelper().deleteUserAccount();
        System.out.println("Account is deleted");
    }

    @After(order = 2)
    public void takeScreenshot() {
        app.takeScreenshotWithScrollDown();
    }

    @After(order = 1)
    public void closeApp() {
        app.stopApp();
        System.out.println("After is called!");
    }
//    @After(value = "@browser and not @headless", order = 2)
//    public void takeScreenshotIfFailed(Scenario scenario){
//        if (scenario.isFailed());
//        app.takeScreenshotWithScrollDown();
//    }


}