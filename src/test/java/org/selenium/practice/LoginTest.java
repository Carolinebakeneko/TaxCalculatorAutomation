package org.selenium.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.selenium.practice.controllers.ChromeController;
import org.selenium.practice.pages.LoginPage;
import org.selenium.practice.pages.LoginPageImpl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
    WebDriver driver;
    Wait<WebDriver> wait;
    LoginPage loginPage;
    @BeforeMethod

    public void setUp(){
        // setup web driver
        //WebDriverManager.chromedriver().setup(); // ( web driver = web site)
        // open web driver
        ChromeController driverController = new ChromeController();
        driver = driverController.getDriver();
        // maximize window
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // navigate to amazon.com
        driver.get("https://buggy.justtestit.org");
        this.loginPage=new LoginPageImpl(driverController);
    }
    @AfterMethod
    public void wrapUp(){
        driver.quit();
    }
  @Test
    public void verifyErrorMessageWhenLoginWithInvalidCredencial(){
        this.loginPage.login("usernameABC","123");



      Assert.assertEquals(this.loginPage.readErrorMessage(),"Invalid username/password");
        //Close driver

    }
}
