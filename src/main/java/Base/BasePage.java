package Base;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected ExtentTest logger;
    private final int TIMEOUT = 20; // default wait time in seconds

    public BasePage(WebDriver driver, ExtentTest logger) {
        this.driver = driver;
        this.logger = logger;
    }

    // ------------------------------
    // Wait Methods
    // ------------------------------

    protected WebElement waitForVisibility(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected WebElement waitForClickable(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    // ------------------------------
    // Action Methods with Wait + Logging + Screenshot
    // ------------------------------

    protected void click(By locator, String stepName) {
        waitForClickable(locator).click();
        logStep(stepName);
    }

    protected void type(By locator, String text, String stepName) {
        WebElement element = waitForVisibility(locator);
        element.clear();
        element.sendKeys(text);
        logStep(stepName);
    }

    protected void verify(boolean condition, String stepName, String failMessage) {
        if (condition) {
            logStep(stepName);
        } else {
            logStep(failMessage + " ❌");
            throw new AssertionError(failMessage);
        }
    }

    // Optional: simple pause between steps (seconds)
    protected void pause(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // ------------------------------
    // Logging + Screenshot
    // ------------------------------

    private void logStep(String stepName) {
        // Capture screenshot as Base64 for ExtentReports
        String base64 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
        logger.info(stepName, MediaEntityBuilder.createScreenCaptureFromBase64String(base64).build());

    }
}
