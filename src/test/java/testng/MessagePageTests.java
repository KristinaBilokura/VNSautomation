package testng;

import consts.Constants;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.MessagePage;

@Feature("MessagePage")
public class MessagePageTests extends BaseTest {

    @Story("WHEN user go to message page THEN user can see notification fiels with messages")
    @Test(description = "Verify if user can see notification fiels with messages when user go to message page.",
            groups = {"regression"})
    public void verifyUuserCanSeeNotificationFielsWithMessagesTest() {
        new LoginPage().
                getLoginPage().
                login(Constants.Application.USER_USERNAME, Constants.Application.USER_PASSWORD).
                verifyUserLoggedIn();
        new MessagePage().
                getMessagePagee().
                verifyMessageFieldDisplayed();

    }
}
