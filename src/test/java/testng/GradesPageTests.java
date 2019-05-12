package testng;

import consts.Constants;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import pageObjects.GradesPage;
import pageObjects.LoginPage;
import pageObjects.ProfilePage;

@Feature("GradesPage")
public class GradesPageTests extends BaseTest {
    @Story("WHEN user go to grade page THEN user see its course profiles")
    @Test(description = "Verify if user see its course profiles when user go to grade page.",
            groups = {"regression"})
    public void verifyOnGradePageAreUsersCourseProfilesTest() {
        new LoginPage().
                getLoginPage().
                login(Constants.Application.USER_USERNAME, Constants.Application.USER_PASSWORD).
                verifyUserLoggedIn();
        new ProfilePage().
                getProfilePage().
                getCourseProfiles();
        new GradesPage().
                getGradesPage().
                verifyUserCourseProfiles();
    }
}
