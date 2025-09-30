package PageEvents;

import Base.BasePage;
import PageObjects.LandingPageElements;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPageEvents extends BasePage {

    public LandingPageEvents(WebDriver driver, ExtentTest logger) {
        super(driver, logger);
    }

    // Verify home page loaded by checking a key element
    public void verifyHomePageLoad() {
        By loginButton = By.xpath(LandingPageElements.loginButton);

        verify(driver.findElements(loginButton).size() > 0, "Verify Login Page Loaded", "Login button not found");
    }

    // Click the login button on the home page
    public void loginButtonClick() {
        click(By.xpath(LandingPageElements.loginButton), "Click Landing Page Login Button");
    }

}
