package pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

import static consts.Constants.Application.COURSES_PAGE_URL;
import static consts.Constants.Application.NOT_REGISTED_COURSE;
import static consts.Constants.Application.REGISTED_COURSE;
import static utils.WaitConditions.PageElement.VISIBLE;

public class CoursePage extends AbstractPage {

    @Step("Get Course Page")
    public CoursePage getCoursePage() {
        getPage(COURSES_PAGE_URL);
        return this;
    }

    @Step("Move to registed course")
    public CoursePage moveToMyCourse() {
        getPage(REGISTED_COURSE);
        return this;
    }

    @Step("Move to not registed course")
    public CoursePage moveToAnyCourse() {
        getPage(NOT_REGISTED_COURSE);
        return this;
    }

    @Step("Verify course information is available")
    public void verifyCourseInformationIsAvailable() {
        By info = By.className("instancename");
        Assert.assertTrue(getElement(info,VISIBLE).isDisplayed(),"Verify course information is available");
    }

    @Step("Verify course information is not available")
    public void verifyCourseInformationIsNotAvailable() {
        By message = By.id("notice");
        Assert.assertTrue(getElement(message,VISIBLE).isDisplayed(),"Verify course information is not available");
    }
}
