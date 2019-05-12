package testng;

import consts.Constants;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import pageObjects.CoursePage;
import pageObjects.LoginPage;

@Feature("CoursePage")
public class CoursePageTests extends BaseTest {

    @Story("WHEN user goes registed course THEN user can see all the information about this course")
    @Test(description = "Verify user can see all the information about this course when user goes registed course .",
            groups = {"regression"})
    public void verifyAllInformationAboutCourseIsAvailableTest() {
        new LoginPage().
                getLoginPage().
                login(Constants.Application.USER_USERNAME, Constants.Application.USER_PASSWORD).
                verifyUserLoggedIn();
        new CoursePage().
                getCoursePage().
                moveToMyCourse().
                verifyCourseInformationIsAvailable();
    }

    @Story("WHEN user goes to not registed course THEN user can not see all the information about this course")
    @Test(description = "Verify user can not see all the information about this course when user goes to not registed course.",
            groups = {"regression"})
    public void verifyAllInformationAboutCourseIsNotAvailableTest() {
        new LoginPage().
                getLoginPage().
                login(Constants.Application.USER_USERNAME, Constants.Application.USER_PASSWORD).
                verifyUserLoggedIn();
        new CoursePage().
                getCoursePage().
                moveToAnyCourse().
                verifyCourseInformationIsNotAvailable();
    }
}
