package testng;

import consts.Constants;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.MainPage;


@Feature("MainPage")
public class MainPageTests extends BaseTest {

    @Story("WHEN user click on mainpageIcon THEN all components are displayed")
    @Test(description = "Verify all components are displayed when user click on mainpageIcon.",
            groups = {"regression"})
    public void verifyAllComponentsOfMainPageDisplayedTest() {
        new LoginPage().
                getLoginPage().
                login(Constants.Application.USER_USERNAME, Constants.Application.USER_PASSWORD).
                verifyUserLoggedIn();
        new MainPage().
                clickOnMainPageIcon().
                verifyMainPageComponentsDisplayed();
    }

    @Story("WHEN user want to add blog item on VNSBlog page THEN item is added")
    @Test(description = "Verify blog item is added when user want to add blog item on VNSBlog page",
            groups = {"regression"})
    public void verifyUserCanAddBlogItemTest() {
        new LoginPage().
                getLoginPage().
                login(Constants.Application.USER_USERNAME, Constants.Application.USER_PASSWORD).
                verifyUserLoggedIn();
        new MainPage().
                clickOnVNSLabel().
                clickOnBlog().
                createBlogItem().
                fillInfields().
                verifyBlogItemDisplayed();

    }

    @Story("WHEN user click on search of VNS field THEN search is available")
    @Test(description = "Verify search is available when user click on search of VNSSearch field ",
            groups = {"regression"})
    @Issue("Searching is available")
    public void verifySearchIsAvailableTest() {
        new LoginPage().
                getLoginPage().
                login(Constants.Application.USER_USERNAME, Constants.Application.USER_PASSWORD).
                verifyUserLoggedIn();
        new MainPage().
                clickOnVNSLabel().
                clickOnSearch().
                verifysearchIsAvailable();
    }


    @Story("WHEN user click on calendar of VNS field THEN calendar is displayed")
    @Test(description = "Verify calendar is displayed when user click on calendar of VNS field ",
            groups = {"regression"},enabled = false)
    public void verifyCalendarIsDisplayedTest() {
        new LoginPage().
                getLoginPage().
                login(Constants.Application.USER_USERNAME, Constants.Application.USER_PASSWORD).
                verifyUserLoggedIn();
        new MainPage().
                clickOnVNSLabel().
                clickOnCalendar().
                verifyCalendarDisplayed();
    }

    @Story("WHEN user click on medals of VNS field THEN medals is displayed")
    @Test(description = "Verify medals is displayed when user click on medals of VNS field ",
            groups = {"regression"})
    public void verifyMedalsDisplayedTest() {
        new LoginPage().
                getLoginPage().
                login(Constants.Application.USER_USERNAME, Constants.Application.USER_PASSWORD).
                verifyUserLoggedIn();
        new MainPage().
                clickOnVNSLabel().
                clickOnMedals().
                verifyMedalsDisplayed();
    }

    @Story("WHEN user click on hide window THEN window is hiden")
    @Test(description = "Verify window is hiden when user click on hide window",
            groups = {"regression"})
    public void verifyWindowCanByHidenTest() {
        MainPage mainPage = new MainPage();
        new LoginPage().
                getLoginPage().
                login(Constants.Application.USER_USERNAME, Constants.Application.USER_PASSWORD).
                verifyUserLoggedIn();
        mainPage.
                hideWindow().
                verifyWindowIsHiden();
        mainPage.
                showWindow();
    }
}
