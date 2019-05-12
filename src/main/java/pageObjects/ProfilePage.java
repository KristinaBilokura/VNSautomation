package pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import utils.WaitConditions;

import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;

import static consts.Constants.Application.PROFILE_PAGE_URL;

public class ProfilePage extends AbstractPage {

    private By customisePageButton = By.xpath("//div[@class='singlebutton'][2]//input[@type='submit']");
    private By navigationEditIcon = By.xpath("//div[@id='action-menu-1']//ul");
    private By extraSybjectEditIcon = By.xpath("//div[@id='action-menu-2']//ul");
    private By administrationEditIcon = By.xpath("//div[@id='action-menu-3']//ul");
    private By calendarEditIcon = By.xpath("//div[@id='action-menu-4']//ul");
    private By extraBlockMessage = By.xpath("//div[@class='block block_adminblock yui3-dd-drop']/div");
    private By courseProfiles = By.xpath("//li[@class='contentnode']//dl//dd//ul//a");

    public static Set<String> listOfCourses = new TreeSet<>();

    @Step("Get Profile page")
    public ProfilePage getProfilePage() {
        getPage(PROFILE_PAGE_URL);
        return this;
    }

    @Step("Click on customise button")
    public ProfilePage clickOnCustomisePageButton() {
        getElement(customisePageButton, WaitConditions.PageElement.VISIBLE).click();
        return this;
    }

    @Step("Verify edit-buttons on fields are displayed")
    public void verifyEditButtonsOnFieldsDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(isElementDisplayed(navigationEditIcon));
        softAssert.assertTrue(isElementDisplayed(extraSybjectEditIcon));
        softAssert.assertTrue(isElementDisplayed(administrationEditIcon));
        softAssert.assertTrue(isElementDisplayed(calendarEditIcon));

    }

    @Step("Verify user can add extra block")
    public void verifyUserCanAddExtraBlock() {
        Assert.assertFalse(isElementDisplayed(extraBlockMessage), "Verify user can add extra block");

    }

    @Step("Course profiles")
    public void getCourseProfiles() {
        for (int i = 0; i < getElements(courseProfiles, WaitConditions.PageElements.VISIBLE_S).size(); i++) {
            listOfCourses.add(getElements(courseProfiles, WaitConditions.PageElements.VISIBLE_S).get(i).getText());
        }
    }


}
