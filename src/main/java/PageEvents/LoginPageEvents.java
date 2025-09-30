package PageEvents;

import Base.BasePage;
import PageObjects.LoginPageElements;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageEvents extends BasePage {

    public LoginPageEvents(WebDriver driver, ExtentTest logger) {
        super(driver, logger);
    }

    public void verifyLoginPageLoad() {
        // Check if login button exists
        By loginButton = By.xpath(LoginPageElements.loginButton);

        verify(driver.findElements(loginButton).size() > 0, "Verify Login Page Loaded", "Login button not found");
    }

    // Enter credentials for login
    public void enterCredentials(String email, String password) {
        type(By.xpath(LoginPageElements.emailTextField), email, "Enter Email");
        type(By.xpath(LoginPageElements.passwordTextField), password, "Enter Password");
    }

    //Click the login button
    public void clickLoginButton() {
        click(By.xpath(LoginPageElements.loginButton), "Click Login Button");
    }
}
