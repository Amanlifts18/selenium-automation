package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.function.Function;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By username = By.id("username");
    private By password = By.id("password");
    private By submitBtn = By.id("submit");
    private By errorMsg = By.id("error");
    private By logoutBtn = By.xpath("//a[text()='Log out']");

    // FluentWait helper
    private WebElement waitForElement(By locator) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);

        return wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                WebElement element = driver.findElement(locator);
                if (element.isDisplayed()) {
                    return element;
                } else {
                    return null;
                }
            }
        });
    }

    // Actions
    public void login(String user, String pass) {
        waitForElement(username).clear();
        waitForElement(username).sendKeys(user);

        waitForElement(password).clear();
        waitForElement(password).sendKeys(pass);

        waitForElement(submitBtn).click();
    }

    // Error handling
    public boolean isErrorMessageDisplayed() {
        return waitForElement(errorMsg).isDisplayed();
    }

    public String getErrorMessageText() {
        return waitForElement(errorMsg).getText();
    }

    // Success validation
    public boolean isLogoutDisplayed() {
        return waitForElement(logoutBtn).isDisplayed();
    }
}
