package org.selenium.practice.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.selenium.practice.controllers.WebDriverController;
import org.selenium.practice.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;

public class Hooks {
    WebDriver driver;
    Wait<WebDriver> wait;
    LoginPage loginPage;

    public Hooks(WebDriverController driverController){
this.driver=driverController.getDriver();
    }
    @Before

    public void setUp(){
       // WebDriverManager.chromedriver().setup(); // ( web driver = web site)
        // open web driver
        //driver = new ChromeDriver();
        // maximize window
        driver.manage().window().maximize();
    }
    @After
    public void wrapUp(){
        driver.quit();
    }
}
