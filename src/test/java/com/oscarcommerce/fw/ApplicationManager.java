package com.oscarcommerce.fw;

import com.google.common.io.Files;
import com.oscarcommerce.utils.PropertiesLoader;
import com.oscarcommerce.utils.User;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class ApplicationManager {

    public static final String BASKET_PAGE_PATH = "/basket/";
    public static final String ITEM_CONTAINER_PAGE_PATH = "/catalogue/";
    public static final String LOGIN_AND_REGISTRATION_PAGE_PATH = "/accounts/login";
    public static final String PWD_RESET_PAGE_PATH = "/password-reset/";
    private static final String SCREENSHOT_FILE_NAME = "target/screenshots/$timestamp_screenshot.png";
    private static final String ACCOUNT_PAGE_PATH = "/accounts/profile/";
    public static String defaultBaseURL = PropertiesLoader.loadProperty("defaultBaseURL");
    public static String defaultBrowser = PropertiesLoader.loadProperty("defaultBrowser");
    public static String defaultLanguage = PropertiesLoader.loadProperty("defaultLanguage");
    private static String validUserPwd = PropertiesLoader.loadProperty("validUserPwd");
    public String localizedBaseUrl;
    //protected EventFiringWebDriver webDriver;
    protected WebDriver webDriver;
    protected String baseUrl;
    protected String browser;
    protected String language;
    User currentUser;
    Recorder recorder;
    AccountHelper accountHelper;
    BasketHelper basketHelper;
    BrowseStoreMenuHelper browseStoreMenuHelper;
    ItemCardHelper itemCardHelper;
    ItemContainerHelper itemContainerHelper;
    ItemListContainerHelper itemListContainerHelper;
    LocalizationHelper localizationHelper;
    LoginHelper loginHelper;
    MainMenuHelper mainMenuHelper;
    RegistrationHelper registrationHelper;
    SearchFunctionHelper searchFunctionHelper;
    StoreMenuHelper storeMenuHelper;
    TopPanelHelper topPanelHelper;

    public ApplicationManager() {
        baseUrl = System.getProperty("baseUrl", defaultBaseURL);
        browser = System.getProperty("browser", defaultBrowser);
        language = System.getProperty("language", defaultLanguage);
        localizedBaseUrl = baseUrl + defaultLanguage;
        initApp();
    }

    //public ApplicationManager(String browser) {
    //    this.browser = browser;
    //}

    public User getCurrentUser() {
        return currentUser;
    }

    public AccountHelper getAccountHelper() {
        return accountHelper;
    }

    public BasketHelper getBasketHelper() {
        return basketHelper;
    }

    public BrowseStoreMenuHelper getBrowseStoreMenuHelper() {
        return browseStoreMenuHelper;
    }

    public ItemCardHelper getItemCardHelper() {
        return itemCardHelper;
    }

    public ItemContainerHelper getItemContainerHelper() {
        return itemContainerHelper;
    }

    public ItemListContainerHelper getItemListContainerHelper() {
        return itemListContainerHelper;
    }

    public LocalizationHelper getLocalizationHelper() {
        return localizationHelper;
    }

    public LoginHelper getLoginHelper() {
        return loginHelper;
    }

    public MainMenuHelper getMainMenuHelper() {
        return mainMenuHelper;
    }

    public RegistrationHelper getRegistrationHelper() {
        return registrationHelper;
    }

    public SearchFunctionHelper getSearchFunctionHelper() {
        return searchFunctionHelper;
    }

    public StoreMenuHelper getStoreMenuHelper() {
        return storeMenuHelper;
    }

    public TopPanelHelper getTopPanelHelper() {
        return topPanelHelper;
    }

    public void initApp() {
        WebDriverListener customListener = new CustomListener();

        switch (browser) {
            case "CHROME":
//                webDriver = new EventFiringWebDriver(new ChromeDriver());
                webDriver = new ChromeDriver();
                break;
            case "FIREFOX":
//                webDriver = new EventFiringWebDriver(new FirefoxDriver());
                webDriver = new FirefoxDriver();
                break;
            case "SAFARI":
//                webDriver = new EventFiringWebDriver(new SafariDriver());
                webDriver = new SafariDriver();
                break;
        }

        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        webDriver = new EventFiringDecorator(customListener).decorate(webDriver);

        accountHelper = new AccountHelper(webDriver);
        basketHelper = new BasketHelper(webDriver);
        browseStoreMenuHelper = new BrowseStoreMenuHelper(webDriver);
        itemCardHelper = new ItemCardHelper(webDriver);
        itemContainerHelper = new ItemContainerHelper(webDriver);
        itemListContainerHelper = new ItemListContainerHelper(webDriver);
        localizationHelper = new LocalizationHelper(webDriver);
        loginHelper = new LoginHelper(webDriver);
        mainMenuHelper = new MainMenuHelper(webDriver);
        registrationHelper = new RegistrationHelper(webDriver);
        searchFunctionHelper = new SearchFunctionHelper(webDriver);
        storeMenuHelper = new StoreMenuHelper(webDriver);
        topPanelHelper = new TopPanelHelper(webDriver);
        currentUser = new User(validUserPwd);

        //        webDriver.register(new MyListener());

        goToMainPage();
    }

    public void stopApp() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        webDriver.quit();
    }

    public void goToMainPage() {
        webDriver.get(baseUrl);
    }

    public void goToLoginAndRegistrationPage() {
        webDriver.get(baseUrl + defaultLanguage + LOGIN_AND_REGISTRATION_PAGE_PATH);
    }

    public void goToPasswordResetPage() {

        webDriver.get(localizedBaseUrl + PWD_RESET_PAGE_PATH);
    }

    public void goToAccountPage() {
        webDriver.get(baseUrl + defaultLanguage + ACCOUNT_PAGE_PATH);
    }

    public void goToBasketPage() {
        webDriver.get(baseUrl + defaultLanguage + BASKET_PAGE_PATH);
    }

    public void goToItemContainerPage() {
        webDriver.get(baseUrl + defaultLanguage + ITEM_CONTAINER_PAGE_PATH);
    }

    public Screenshot takeScreenshotWithScrollDown() {

        Screenshot screenshot = new AShot()
                .shootingStrategy(
                        ShootingStrategies
                                .viewportPasting(ShootingStrategies
                                        .scaling(2.0f), 1000))
                .takeScreenshot(webDriver);

        try {
            ImageIO.write(screenshot.getImage(), "png",
                    new File(SCREENSHOT_FILE_NAME.replace("$timestamp", "" + System.currentTimeMillis())));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return screenshot;
    }

    public void startRecording() throws IOException, AWTException {
        String pathName = "records/recording";

        GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
        recorder = new Recorder(gc, pathName);
        recorder.start();

    }

    public void stopRecording() throws IOException {
        recorder.stop();
    }

}