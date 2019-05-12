package testng;

import consts.Constants;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.ProfilePage;


@Feature("ProfilePage")
public class ProfilePageTests extends BaseTest {

    @Story("WHEN user click to edit fields THEN user get edit-button on the windows")
    @Test(description = "Verify if user get edit-button on the windows when user click to edit fields.",
            groups = {"regression"})
    public void verifyUserCanGetEditBottonOnWidowsWithInformationTest() {
        new LoginPage().
                getLoginPage().
                login(Constants.Application.USER_USERNAME, Constants.Application.USER_PASSWORD).
                verifyUserLoggedIn();
        new ProfilePage().
                getProfilePage().
                clickOnCustomisePageButton().
                verifyEditButtonsOnFieldsDisplayed();

    }

    @Story("WHEN user click to add extra block THEN block is added")
    @Test(description = "Verify if user can add extra block of data.",
            groups = {"regression"})
    @Issue("User can not add extra block while editing page")
    public void verifyUserCanAdExtraBlockOfDataTest() {
        new LoginPage().
                getLoginPage().
                login(Constants.Application.USER_USERNAME, Constants.Application.USER_PASSWORD).
                verifyUserLoggedIn();
        new ProfilePage().
                getProfilePage().
                clickOnCustomisePageButton().
                verifyUserCanAddExtraBlock();

    }
}
