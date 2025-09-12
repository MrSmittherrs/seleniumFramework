package PageEvents;

import PageObjects.HomePageElements;
import utils.ElementFetch;

public class HomePageEvents {
    ElementFetch ele = new ElementFetch();

    public void loginButtonClick(){

        ele.getWebElement("XPATH", HomePageElements.loginButton).click();

    }
}
