package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.TestListener;

@Listeners(TestListener.class)
public class LoginTest extends BaseTest {

    @Test(priority = 1)
    public void positiveLoginTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("student", "Password123");

        // Verify URL contains "logged-in-successfully"
        Assert.assertTrue(driver.getCurrentUrl().contains("logged-in-successfully"),
                "Expected URL to contain 'logged-in-successfully'");

        // Verify logout button is displayed
        Assert.assertTrue(loginPage.isLogoutDisplayed(), "Logout button should be displayed");
    }

    @Test(priority = 2)
    public void negativeUsernameTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("incorrectUser", "Password123");

        // Validate error message
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message should be displayed");
        Assert.assertEquals(loginPage.getErrorMessageText(), "Your username is invalid!");
    }

    @Test(priority = 3)
    public void negativePasswordTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("student", "incorrectPassword");

        // Validate error message
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message should be displayed");
        Assert.assertEquals(loginPage.getErrorMessageText(), "Your password is invalid!");
    }
}
