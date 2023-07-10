package org.selenium.practice.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.selenium.practice.controllers.WebDriverController;
import org.selenium.practice.pages.LoginPage;
import org.selenium.practice.pages.LoginPageImpl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LoginStepdefs {
    WebDriver driver;
    LoginPage loginPage;
    public LoginStepdefs(WebDriverController driverController, LoginPage loginPage ){
        this.driver=driverController.getDriver();
        this.loginPage=loginPage;
    }
    @Given("a user is at the login page")
    public void aUserIsAtTheLoginPage() {
        driver.get("https://buggy.justtestit.org");

    }

    @When("the user enters incorrect username or password")
    public void theUserEntersIncorrectUsernameOrPassword() {
        this.loginPage.login("usernameABC","123");

    }

    @Then("the system should show an error message saying {string}")
    public void theSystemShouldShowAnErrorMessageSaying(String expectedErrorMessage) {
        Assert.assertEquals(this.loginPage.readErrorMessage(),expectedErrorMessage);
    }

}



