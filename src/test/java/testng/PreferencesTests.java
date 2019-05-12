package testng;

import consts.Constants;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;
import pageObjects.preferences.ChangeLanguagePage;
import pageObjects.preferences.ChangePasswordPage;
import pageObjects.LoginPage;

import static pageObjects.preferences.ChangePasswordPage.passwordRandom;
;

@Feature("Preferences")
public class PreferencesTests extends BaseTest {

    @Story("WHEN user changes valid password THEN password is changed")
    @Test(description = "Verify user can change valid password",
            groups = {"regression"})
    public void verifyUserCanChangeValidPassword() {
        new LoginPage().
                getLoginPage().
                login(Constants.Application.USER_USERNAME, Constants.Application.USER_PASSWORD).
                verifyUserLoggedIn();
        new ChangePasswordPage().
                getChangePasswordPage().
                changePassword(Constants.Application.USER_PASSWORD, passwordRandom, passwordRandom).
                verifyAcceptionMessageDisplayed();

    }

    @Story("WHEN user changes password not passing fields of password THEN required message dispayed")
    @Test(description = "Verify user can not change password not passing current password",
            groups = {"regression"})
    public void verifyUserCanNotChangePasswordNotPassingCurrentPassword() {
        new LoginPage().
                getLoginPage().
                login(Constants.Application.USER_USERNAME, Constants.Application.USER_PASSWORD).
                verifyUserLoggedIn();
        new ChangePasswordPage().
                getChangePasswordPage().
                changePassword("", passwordRandom, passwordRandom).
                verifyRequireMessageDisplayed();

    }

    @Story("WHEN user changes password where new password different to newpassword confirmation THEN required message displayed")
    @Test(description = "Verify user can not change password where new password different to newpassword confirmation",
            groups = {"regression"})
    public void verifyUserCanNotChangePasswordWhereNewPasswordDifferentToNewpasswordConfirmation() {
        new LoginPage().
                getLoginPage().
                login(Constants.Application.USER_USERNAME, Constants.Application.USER_PASSWORD).
                verifyUserLoggedIn();
        new ChangePasswordPage().
                getChangePasswordPage().
                changePassword(Constants.Application.USER_PASSWORD, passwordRandom," ").
                verifyBadRequestMessageDisplayed();

    }

    @Story("WHEN user change language THEN click on change language button")
    @Test(description = "Verify user can change language",
            groups = {"regression"})
    @Issue("User can not change language")
    public void verifyUserCanChangeLanguage() {
        new LoginPage().
                getLoginPage().
                login(Constants.Application.USER_USERNAME, Constants.Application.USER_PASSWORD).
                verifyUserLoggedIn();
        ChangeLanguagePage changeLanguagePage= new ChangeLanguagePage();
        changeLanguagePage.
                getChangeLanguagePage().
                changeLanguage().
                verifyLanguageChanged();
    }
}
