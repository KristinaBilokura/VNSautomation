package testng;

import data.UserDataProvider;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.MainPage;

@Feature("LoginPage")
public class LoginPageTests extends BaseTest {

    @Story("WHEN user inputs correct credentials at login page THEN user is redirected to main page")
    @Test(dataProviderClass = UserDataProvider.class, dataProvider = "Credentials", description = "Verify if user can login with valid credentials",
            groups = {"regression"})
    public void verifyUserCanLoginWithValidCredentialsTest(final String username, final String password) {
        new LoginPage().
                getLoginPage().
                login(username, password).
                verifyUserLoggedIn();
    }

    @Story("WHEN user inputs incorrect credentials at login page THEN user is redirected back to login page")
    @Test(dataProviderClass = UserDataProvider.class, dataProvider = "InvalidCredentials", description = "Verify that user is redirected back to login page " +
            "when user inputs incorrect credentials at login page", groups = {"regression"})
    @Issue("Login is not sensitive to case.")
    public void verifyUserCantLoginWithInvalidCredentialsTest(final String username, final String password) {
        LoginPage loginPage = new LoginPage();
        loginPage.
                getLoginPage().
                login(username, password);
        loginPage.
                verifyInvalidCredentialsMessageDisplayed();

    }

    @Story("WHEN user logs out THEN user is redirected to login page")
    @Test(dataProviderClass = UserDataProvider.class, dataProvider = "Credentials", description = "Verify that user " +
            "is redirected to login page when user logs out", groups = {"regression"})
    public void verifyUserRedirectedToLoginPageWhenUserLogsOut(final String username, final String password) {
        new LoginPage().
                getLoginPage().
                login(username, password).
                logOut().
                verifyUserRedirectedToLoginPage();
    }

    @Story("WHEN user is logged in THEN user cannot visit login page")
    @Test(dataProviderClass = UserDataProvider.class, dataProvider = "Credentials",
            description = "Verify that user cannot visit login page when user is logged in", groups = {"regression"})
    public void verifyLoggedUserCannotVisitLoginPage(final String username, final String password) {
        LoginPage loginPage = new LoginPage();
        loginPage.
                getLoginPage().
                login(username, password).
                // Check out user is logged in before moving to login page
                        verifyUserLoggedIn();
        loginPage.
                getLoginPage();
        new MainPage().
                verifyConfirmationDisplayed();
    }

    @Story("WHEN user is not logged in AND call any application page THEN user is redirected to login page")
    @Test(dataProviderClass = UserDataProvider.class, dataProvider = "PagesURLs", description = "Verify that user is redirected to login page when user is not " +
            "logged in and call any application page ",
            groups = {"regression"})
    public void verifyUserIsRedirectedToLoginPageWhenUserIsNotLoggedInAndCallAnyApplicationPage(final String pageUrl) {
        new LoginPage().
                getPageByUrl(pageUrl);
        new LoginPage().
                verifyUserRedirectedToLoginPage();
    }

    @Story("WHEN user click on remember me THEN user login stay in system")
    @Test(dataProviderClass = UserDataProvider.class, dataProvider = "Credentials", description = "Verify that user " +
            "login stay in form when user click on remember me button",
            groups = {"regression"})
    public void verifyUserLoginStayInFormWhemUserClickOnRememberMeButton(final String username, final String password) {
        new LoginPage().
                getLoginPage().
                loginAndRememberMe(username, password).
                logOut().
                verifyUserLoginIsDisplayed(username);
    }

    @Story("WHEN user want to check its surname in transliteration THEN user get to transliteration page")
    @Test(description = "Verify transliteration works properly",
            groups = {"regression"})
    public void verifyTransliterationWorksProperly() {
        new LoginPage().
                getLoginPage().
                clickOnTransliteration().
                verifyItsTransliterationSite();

    }
    @Story("WHEN user clicks on official site link THEN user redirect to main website of NULP")
    @Test(description = "Verify user redirected t0 main website of NULP when user click on official site link",
            groups = {"regression"})
    @Issue("User can not visit official site.")
    public void verifyUserRediarectedToMainSiteWhenUserClickOnSiteLink() {
        new LoginPage().
                getLoginPage().
                clickOnOfficialWebSitelink().
                verifyUserCanVisitLpSite();
    }

    @Story("WHEN user clicks on link for administrator THEN user redirect to login page")
    @Test(description = "Verify user redirect to login pagewhen user clicks on link for administrator",
            groups = {"regression"})
    @Issue("User get broken page")
    public void verifyUserRedirectToLoginPageWhenUserClickOnLinkForAdministrator() {
        new LoginPage().
                getLoginPage().
                clickOnAdministatorlink().
                verifyUserRedirectedToLoginPage();
    }
}