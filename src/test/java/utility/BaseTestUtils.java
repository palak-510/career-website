package utility;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

@CucumberOptions(
        features = "classpath:features/",
        glue = {"stepDefinitions", "utility", "hooks"},
        plugin = {"pretty","html:target/cucumber-html-report.html", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm", "rerun:build/FailedTestcase.txt",}
)

public class BaseTestUtils extends AbstractTestNGCucumberTests {

    protected static WebDriver driver;
    private static Map<String, Object> scenarioContext = new HashMap<>();

    @Parameters("browser")
    @BeforeClass
    public void setup(String browser) {
        switch (browser) {
            case Constants.CHROME:
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--disable-notifications");
                driver = new ChromeDriver(options);
                driver.manage().window().maximize();
                break;
            case Constants.EDGE:
                driver = new EdgeDriver();
                driver.manage().window().maximize();
                break;
        }
    }

    public void setContext(Context key, Object value) {
        scenarioContext.put(key.toString(), value);
    }

    public Object getContext(Context key) {
        return scenarioContext.get(key.toString());
    }

    @AfterTest
    public void closeDriver() {
        waitInSeconds(2);
        driver.close();
    }

    public void waitInSeconds(int seconds) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
    }

    public void waitUntilVisibilityOf(By element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public void waitUntilPresenceOf(By element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
    }

    public void mouseHover(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }

    public String getCurrentPageURL() {
        String currentUrl = driver.getCurrentUrl();
        return currentUrl;
    }

    public boolean elementExists(By element) {
        boolean elementExists = false;
        int size = driver.findElements(element).size();
        if (size > 0) {
            elementExists = true;
        }
        return elementExists;
    }
}
