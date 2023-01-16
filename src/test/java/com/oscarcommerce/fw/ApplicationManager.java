package com.oscarcommerce.fw;

import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    protected EventFiringWebDriver webDriver;
    protected String browser;
    BaseHelper baseHelper;
    Recorder recorder;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public BaseHelper getBaseHelper() {
        return baseHelper;
    }

    public void initApp() {

        webDriver = new EventFiringWebDriver(new ChromeDriver());

        if (browser.equals(BrowserType.CHROME))
            webDriver = new EventFiringWebDriver(new ChromeDriver());
        else if (browser.equals(BrowserType.FIREFOX))
            webDriver = new EventFiringWebDriver(new FirefoxDriver());
        else if (browser.equals(BrowserType.SAFARI))
            webDriver = new EventFiringWebDriver(new SafariDriver());

        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        goToMainPage();

        webDriver.register(new MyListener());
    }

    public void stopApp() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        webDriver.quit();
    }

    public void goToMainPage() {
        webDriver.navigate().to("https://latest.oscarcommerce.com/en-gb/catalogue/");
    }

    public void goToRegistrationAndLoginPage() {
        webDriver.navigate().to("https://latest.oscarcommerce.com/en-gb/accounts/login/");
    }

    public String takeScreenShot() {
        String pathName = "screenshots/" + System.currentTimeMillis() + "png";
        File tmpScreenshotFile = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
        File screenShotFile = new File(pathName);
        try {
            Files.copy(tmpScreenshotFile, screenShotFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pathName;
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
