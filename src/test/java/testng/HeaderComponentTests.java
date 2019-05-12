package testng;

import consts.Constants;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import pageObjects.HeaderComponent;
import pageObjects.LoginPage;

@Feature("HeaderComponent")
public class HeaderComponentTests extends BaseTest {

    @Story("WHEN user click on Main Logo THEN user is redirected to main page")
    @Test(description = "Verify user redirected to main page after click on main logo",
            groups = {"regression"})
    public void verifyUserRedirectedToDashboardAfterClickOnMainLogo() {
        new LoginPage().
                getLoginPage().
                login(Constants.Application.USER_USERNAME, Constants.Application.USER_PASSWORD).
                verifyUserLoggedIn();
        new HeaderComponent().
                verifyPageIsReloaded();
    }

    @Story("WHEN user change language THEN click on change language button")
    @Test(description = "Verify user can change language",
            groups = {"regression"})
    public void verifyUserCanChangeLanguage() {
        new LoginPage().
                getLoginPage().
                login(Constants.Application.USER_USERNAME, Constants.Application.USER_PASSWORD).
                verifyUserLoggedIn();
        HeaderComponent headerComponent = new HeaderComponent();
        String currentLang = headerComponent.verifyLanguage();
        headerComponent.
                clickOnLanguageDropdown().
                verifyUserchangeLanguage(headerComponent.changeLanguage(currentLang));

    }

    @Story("WHEN user click on search Icon THEN search Line is displayed")
    @Test(description = "Verify searchLine is displayed when user click on searchIcon",
            groups = {"regression"})
    public void verifySearchLineIsDisplayed() {
        new LoginPage().
                getLoginPage().
                login(Constants.Application.USER_USERNAME, Constants.Application.USER_PASSWORD).
                verifyUserLoggedIn();
        new HeaderComponent().
                clickOnSearchLabel().
                verifySearchPanelDisplayed();
    }

    @Story("WHEN user click on search Icon with minimized window THEN searching proceed is available")
    @Test(description = "Verify searching proceed is available when user click on searchIcon with minimized window",
            groups = {"regression"})
    @Issue("Searching is not available.")
    public void verifySearchLineIsDisplayedWithMinimizedWindow() {
        new LoginPage().
                getLoginPage().
                login(Constants.Application.USER_USERNAME, Constants.Application.USER_PASSWORD).
                verifyUserLoggedIn();
        new HeaderComponent().
                clickOnSearchLabelWithMinimizedWindow().
                verifySearchPanelDisplayed();
    }

    @Story("WHEN user click on notification Icon THEN notification Window is displayed")
    @Test(description = "Verify notificationWindow is displayed when user click on notificationIcon",
            groups = {"regression"})
    public void verifyNotificationWindowIsDisplayed() {
        new LoginPage().
                getLoginPage().
                login(Constants.Application.USER_USERNAME, Constants.Application.USER_PASSWORD).
                verifyUserLoggedIn();
        new HeaderComponent().
                clickOnIconNotification().
                verifyNotificationWingowDisplayed();
    }

    @Story("WHEN user click on message Icon THEN message Window is displayed")
    @Test(description = "Verify messageWindow is displayed when user click on messageIcon",
            groups = {"regression"})
    public void verifyMessageWindowIsDisplayed() {
        new LoginPage().
                getLoginPage().
                login(Constants.Application.USER_USERNAME, Constants.Application.USER_PASSWORD).
                verifyUserLoggedIn();
        new HeaderComponent().
                clickOnIconMessage().
                verifyMessageWingowDisplayed();
    }

    @Story("WHEN user click on user Logo THEN Action-Menu is displayed")
    @Test(description = "Verify Action-Menu is displayed when user click on userlogo",
            groups = {"regression"})
    public void verifyActionMenuIsDisplayed() {
        new LoginPage().
                getLoginPage().
                login(Constants.Application.USER_USERNAME, Constants.Application.USER_PASSWORD).
                verifyUserLoggedIn();
        new HeaderComponent().
                clickOnUserLogo().
                verifyActionMenuWingowDisplayed();
    }
}
