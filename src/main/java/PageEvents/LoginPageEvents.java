package PageEvents;


import PageObjects.LoginPageElements;
import org.testng.Assert;
import utils.ElementFetch;

public class LoginPageEvents {

    ElementFetch ele = new ElementFetch();

    public void  verifyLoginPageLoad(){

        Assert.assertTrue(ele.getWebElements("XPATH", LoginPageElements.loginButtonText).size()>0, "Login button not found");

    }

    public void  enterCredentials(){

        ele.getWebElement("XPATH", LoginPageElements.emailTextField).sendKeys("Keagansmith04@gmail.com");
        ele.getWebElement("XPATH", LoginPageElements.passwordTextField).sendKeys("12345");

    }

    public void  clickLoginButton(){

        ele.getWebElement("XPATH", LoginPageElements.loginButtonText).click();


    }
}
