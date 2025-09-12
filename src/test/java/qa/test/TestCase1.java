package qa.test;

import Base.BaseTest;
import PageEvents.HomePageEvents;
import PageEvents.LoginPageEvents;
import org.testng.annotations.Test;
import utils.ElementFetch;

public class TestCase1 extends BaseTest {
    ElementFetch ele = new ElementFetch();
    HomePageEvents homePageEvents = new HomePageEvents();
    LoginPageEvents loginPageEvents = new LoginPageEvents();

    @Test
    public void loginTest(){

        homePageEvents.loginButtonClick();
        loginPageEvents.verifyLoginPageLoad();
        loginPageEvents.enterCredentials();

    }
}
