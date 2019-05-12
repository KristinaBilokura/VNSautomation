package pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;

import static consts.Constants.Application.*;
import static utils.WaitConditions.PageElement.CLICKABLE;
import static utils.WaitConditions.PageElement.PRESENT;
import static utils.WaitConditions.PageElement.VISIBLE;

public class LoginPage extends AbstractPage {

    private By emailInputField = By.id("username");
    private By passwordInputField = By.id("password");
    private By loginButton = By.id("loginbtn");
    private By loginLabel = By.xpath("//span[@class='login']");
    private By rememberMeButton = By.id("rememberusername");
    private By transliteration = By.xpath("//*[@id='region-main']//div[@class='subcontent']//b/a");
    private By mainSite = By.xpath("//*[@id='region-main']//div[@class='subcontent']//a");
    private By administratorLink = By.xpath("//*[@id='region-main']//div[@class='subcontent']//p[10]/a");

    @Step("Get Login page")
    public LoginPage getLoginPage() {
        getPage(LOGIN_PAGE_URL);
        return this;
    }

    @Step("Login to application")
    public MainPage login(final String email, final String password) {
        getElement(emailInputField, VISIBLE).sendKeys(email);
        getElement(passwordInputField, VISIBLE).sendKeys(password);
        getElement(loginButton, CLICKABLE).click();
        return new MainPage();
    }

    @Step("Login to application")
    public MainPage loginAndRememberMe(final String email, final String password) {
        getElement(emailInputField, VISIBLE).sendKeys(email);
        getElement(passwordInputField, VISIBLE).sendKeys(password);
        getElement(rememberMeButton, CLICKABLE).click();
        getElement(loginButton, CLICKABLE).click();
        return new MainPage();
    }

    @Step("Verify invalid credentials message displayed")
    public void verifyInvalidCredentialsMessageDisplayed() {
        By invalidCredentialsMessage = By.xpath("//span[@class='error']");
        Assert.assertTrue(isElementDisplayed(invalidCredentialsMessage),
                "Verify invalid credentials message displayed");
    }

    @Step("Verify user is redirected to Login page")
    public void verifyUserRedirectedToLoginPage() {
        Assert.assertTrue(isElementDisplayed(loginLabel),
                "Verify Login button Displayed");
    }

    @Step("Get page by url: {pageURL}")
    public void getPageByUrl(String pageURL) {
        getPage(pageURL);
    }

    @Step("Verify user login displayed")
    public void verifyUserLoginIsDisplayed(final String email) {
        Assert.assertEquals(getElement(emailInputField, VISIBLE).getAttribute("value"), email);
    }

    @Step("Click on transliteration Login page")
    public LoginPage clickOnTransliteration() {
        getElement(transliteration, CLICKABLE).click();
        return this;
    }

    @Step("Verify user can try transliteration")
    public LoginPage verifyItsTransliterationSite() {
        By transliteration = By.xpath("//h1[@class='logo logo_translit']");
        Assert.assertTrue(isElementDisplayed(transliteration));
        return this;
    }

    @Step("Click on link of official WebSite")
    public LoginPage clickOnOfficialWebSitelink() {
        getElement(mainSite, CLICKABLE).click();
        return this;
    }

    @Step("Verify user can visit official NULP web-site")
    public LoginPage verifyUserCanVisitLpSite() {
        Assert.assertFalse(switchToTab("404 Not Found"),"Verify user can visit official NULP web-site");
        return this;
    }

    @Step("Click on administrator link")
    public LoginPage clickOnAdministatorlink() {
        getElement(administratorLink, CLICKABLE).click();
        return this;
    }


}
