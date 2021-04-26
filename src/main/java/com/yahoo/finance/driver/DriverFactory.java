package com.yahoo.finance.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class DriverFactory {

    private static final String START_MAXIMIZED = "--start-maximized";

    public static WebDriver getChromeDriver(int wait) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments(START_MAXIMIZED);

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(wait, TimeUnit.SECONDS);
        return driver;
    }

    public static WebDriver getFirefoxDriver(int wait) {

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(wait, TimeUnit.SECONDS);
        return driver;
    }
}
