package qa.test;

import Base.BaseTest;
import org.testng.annotations.Test;

public class TestCase1 extends BaseTest {

    @Test
    public void loginTest(){
        landingPageEvents.verifyHomePageLoad();
        landingPageEvents.loginButtonClick();

        loginPageEvents.verifyLoginPageLoad();
        loginPageEvents.enterCredentials("ksmith2@inspiredtesting.co.za", "P@55wordsm1Smith");
        loginPageEvents.clickLoginButton();
    }
}
