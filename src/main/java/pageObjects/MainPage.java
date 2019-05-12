package pageObjects;

import consts.Constants;
import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import static consts.Constants.Application.BASE_URL;
import static consts.Constants.Application.LOGIN_PAGE_URL;
import static utils.WaitConditions.PageElement.CLICKABLE;
import static utils.WaitConditions.PageElement.PRESENT;
import static utils.WaitConditions.PageElement.VISIBLE;

public class MainPage extends AbstractPage {
    private By userMenuDropdown = By.id("action-menu-toggle-0");
    private By more = By.xpath("//b[@class='caret']");
    private By logOut = By.id("actionmenuaction-6");
    private By сonfirmationWindow = By.id("notice");
    private By exitButton = By.xpath("//div[@class='singlebutton']//input");
    private By cancelButton = By.xpath("//div[@class='singlebutton'][2]//input");
    private By mainPageIcon = By.xpath("//a[@id='label_2_2']//span");
    private By VNSIcon = By.xpath("//span[@id='label_2_3']");
    private By blogIcon = By.xpath("//a[@id='label_3_5']//span");
    private By searchIcon = By.xpath("//*[@class='form-control border-left-0 searchinput']");
    private By searchIconOK = By.xpath("//*[@class='btn m-0']");
    private By messagedrawertoggle = By.xpath("//*[@alt='Toggle messaging drawer']");
    private By medalsIcon = By.xpath("//a[@id='label_3_6']//span");
    private By hideBlock = By.xpath("//img[@class='block-hider-hide']");
    private By showBlock = By.xpath("//img[@class='block-hider-show']");
    private By addbloglink = By.xpath("//div[@class='addbloglink']//a");

    private By subject = By.id("id_subject");
    private By summary_editoreditable = By.id("id_summary_editoreditable");
    private By publishstate = By.id("id_publishstate");
    private By submitbutton = By.id("id_submitbutton");
    private By verifySubject = By.xpath("//div[@class='subject']//a");

    public static String nameRandom = RandomStringUtils.randomAlphabetic(Constants.Number.NEW_NAME_RANDOM_LENGTH);

    private By calendarIcon = By.xpath("//*[@class='current']//a");
    private By calendar = By.xpath("//h2[@id='instance-3-header']");
    private By courses = By.xpath("//h2[@class='sectionname']");
    private By messages = By.xpath("//h2[@id='instance-280-header']");
    private By bunner = By.xpath("//h2[@id='instance-59004-header']");

    @Step("Verify user is logged in")
    public void verifyUserLoggedIn() {
        Assert.assertTrue(isElementDisplayed(userMenuDropdown), "Verify user menu is displayed");
    }

    @Step("Log out")
    public LoginPage logOut() {
        getElement(more, CLICKABLE).click();
        getElement(logOut, CLICKABLE).click();
        return new LoginPage();
    }

    @Step("Verify сonfirmation is displayed")
    public void verifyConfirmationDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(isElementDisplayed(сonfirmationWindow), "Verify сonfirmation window displayed");
        softAssert.assertTrue(isElementDisplayed(exitButton), "Verify exit button displayed");
        softAssert.assertTrue(isElementDisplayed(cancelButton), "Verify cancel button displayed");
        softAssert.assertAll();
    }

    @Step("Click on MainPageIcon")
    public MainPage clickOnMainPageIcon() {
        getElement(mainPageIcon, CLICKABLE).click();
        return this;
    }

    @Step("Verify main page components is displayed")
    public void verifyMainPageComponentsDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(isElementDisplayed(calendar), "Verify calendar displayed");
        softAssert.assertTrue(isElementDisplayed(courses), "Verify courses displayed");
        softAssert.assertTrue(isElementDisplayed(bunner), "Verify bunner displayed");
        softAssert.assertAll();
    }

    @Step("Click on VNS label")
    public MainPage clickOnVNSLabel() {
        getElement(VNSIcon, CLICKABLE).click();
        return this;
    }

    @Step("Click on VNS blog")
    public MainPage clickOnBlog() {
        getElement(blogIcon, CLICKABLE).click();
        return this;
    }

    @Step("Click on VNS medals")
    public MainPage clickOnMedals() {
        getElement(medalsIcon, CLICKABLE).click();
        return this;
    }

    @Step("Click on VNS search")
    public MainPage clickOnSearch() {
        getElement(messagedrawertoggle, VISIBLE).click();
        getElement(searchIcon, VISIBLE).sendKeys("lol");
        getElement(searchIconOK, VISIBLE).click();
        return this;
    }

    @Step("Click on VNS calendar")
    public MainPage clickOnCalendar() {
        getElement(calendarIcon, CLICKABLE).click();
        return this;
    }

    @Step("Create blog item")
    public MainPage createBlogItem() {
        getElement(addbloglink, CLICKABLE).click();
        return this;
    }

    @Step("Fill in blog item input fieald")
    public MainPage fillInfields() {
        getElement(subject, VISIBLE).sendKeys(nameRandom);
        getElement(summary_editoreditable, VISIBLE).sendKeys(nameRandom);
        Select select = new Select(getElement(publishstate, PRESENT));
        select.getOptions().get(0).click();
        getElement(submitbutton, CLICKABLE).click();
        return this;
    }

    @Step("Verify blog item is displayed")
    public void verifyBlogItemDisplayed() {
        Assert.assertEquals(getElement(verifySubject, VISIBLE).getText(), nameRandom, "Verify blog item is displayed");
    }

    @Step("Verify medals displayed")
    public void verifyMedalsDisplayed() {
        By medalsWindow = By.xpath("//section[@id='region-main']//h2");
        Assert.assertTrue(getElement(medalsWindow, VISIBLE).isDisplayed(), "Verify medals displayed");
    }


    @Step("Verify user can search")
    public void verifysearchIsAvailable() {
        By search = By.xpath("//*[@data-region='no-results-container']");
        Assert.assertTrue(getElement(search, VISIBLE).isDisplayed(), "Verify user can search");
    }

    @Step("Verify calendar is dispayed")
    public void verifyCalendarDisplayed() {
        By calendar = By.xpath("//div[@class='heightcontainer']//h2");
        Assert.assertTrue(getElement(calendar, VISIBLE).isDisplayed(), "Verify calendar is dispayed");
    }

    @Step("Hide window")
    public MainPage hideWindow() {
        getElement(hideBlock, CLICKABLE).click();
        return this;
    }

    @Step("Show window")
    public MainPage showWindow() {
        getElement(showBlock, CLICKABLE).click();
        return this;
    }

    @Step("Verify window is hired")
    public void verifyWindowIsHiden() {
        Assert.assertTrue(isElementDisplayed(showBlock), "Verify window is hired");

    }
}
