package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import utils.ConfigReader;
import utils.ExtentManager;
import utils.TestListener;

import java.lang.reflect.Method;

@Listeners(TestListener.class)
public class BaseTest {

    protected WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeMethod
    public void setUp(Method method) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(ConfigReader.getProperty("url"));
        ExtentManager.createTest(method.getName());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
        ExtentManager.flush();
    }
}
