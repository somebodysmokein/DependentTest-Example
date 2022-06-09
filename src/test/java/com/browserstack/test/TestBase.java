package com.browserstack.test;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.net.URL;
import java.util.Date;
import java.util.HashMap;

@SuppressWarnings("unchecked")
public class TestBase {
    public static final String PATH_TO_TEST_CAPS_JSON = "src/test/resources/conf/capabilities/test_caps.json";
    // ThreadLocal gives the ability to store data individually for the current thread
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static final String DOCKER_SELENIUM_HUB_URL = "http://localhost:4444/wd/hub";
    private static String username=System.getenv("BROWSERSTACK_USERNAME");
    private static String accessKey=System.getenv("BROWSERSTACK_ACCESS_KEY");
    private static final String BROWSERSTACK_HUB_URL = "https://"+username+":"+accessKey+"@hub.browserstack.com/wd/hub";
    private static final long TIMESTAMP = new Date().getTime();
    protected WebDriverWait wait;
    private String environment;

    public WebDriver getDriver() {
        return driver.get();
    }

    @BeforeMethod
    public void setUp() throws Exception {
            DesiredCapabilities capabilities = new DesiredCapabilities();

            // Setting the browser capability
            capabilities.setCapability("browserName", "chrome");

            HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();

            // Setting the OS or device version capabilities
            browserstackOptions.put("os", "Windows");
            browserstackOptions.put("osVersion", "10");

            // Setting a build name for the test
            browserstackOptions.put("buildName", "Dependent Test");

            // Setting a session name for the test
            browserstackOptions.put("sessionName", "Dependent test");
            //browserstackOptions.put("user",System.getenv("BROWSERSTACK_USERNAME"));
            //browserstackOptions.put("key","BROWSERSTACK_ACCESS_KEY");
            // Setting the Selenium version
            browserstackOptions.put("seleniumVersion", "4.0.0");
            browserstackOptions.put("seleniumCdp", true);
            browserstackOptions.put("networkLogs", "true");
            capabilities.setCapability("bstack:options", browserstackOptions);
            driver.set(new RemoteWebDriver(new URL(BROWSERSTACK_HUB_URL), capabilities));

    }

    @AfterMethod
    public void tearDown() throws Exception {
        if (getDriver() != null) {
            getDriver().quit();
        }

    }



}