package org.selenium.practice.controllers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class SauceLabsController implements WebDriverController{
    private WebDriver driver;
    public SauceLabsController(){
      setupController();
    }

    @Override
    public WebDriver getDriver() {
        return driver;
    }

    @Override
    public void setDriver(WebDriver driver) {
this.driver=driver;
    }

    @Override
    public void setupController() {
        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("Windows 11");
        browserOptions.setBrowserVersion("latest");
        Map<String, Object> sauceOptions = new HashMap<>();
        sauceOptions.put("username", "oauth-rateau.caroline-58f39");
        sauceOptions.put("accessKey", "beedba75-8111-44e0-891f-22ff6b57b980");
        sauceOptions.put("build", "selenium-build-0IXYQ");
        sauceOptions.put("name", "<your test name>");
        browserOptions.setCapability("sauce:options", sauceOptions);
        URL url = null;
        try {
            url = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        driver = new RemoteWebDriver(url, browserOptions);
    }
}
