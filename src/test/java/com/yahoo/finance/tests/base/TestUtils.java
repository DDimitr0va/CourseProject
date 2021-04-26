package com.yahoo.finance.tests.base;

import com.yahoo.finance.driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestUtils {
    public WebDriver driver;
    private String browser;
    private String url;
    private int implicitWait;

    @BeforeMethod
    public void setUp() {
        readConfigProperties();
        setUpBrowserDriver();
        loadUrl();
    }

    private void loadUrl() {
        driver.get(url);
    }

    private void readConfigProperties() {
        try (FileInputStream configFile =
                     new FileInputStream("src/test/resources/config.properties")) {
            Properties config = new Properties();
            config.load(configFile);
            url = config.getProperty("urlAddress");
            implicitWait = Integer.parseInt(config.getProperty("implicitWait"));
            browser = config.getProperty("browser");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setUpBrowserDriver() {
        switch (browser) {
            case "chrome":
                driver = DriverFactory.getChromeDriver(implicitWait);
                break;
            case "firefox":
                driver = DriverFactory.getFirefoxDriver(implicitWait);
                break;
            default:
                throw new IllegalStateException("Unsupported browser type");
        }
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}