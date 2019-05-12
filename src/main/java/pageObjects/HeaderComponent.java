package pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;
import utils.WaitConditions;

import static consts.Constants.Application.BASE_URL;
import static utils.WaitConditions.PageElement.CLICKABLE;
import static utils.WaitConditions.PageElement.PRESENT;
import static utils.WaitConditions.PageElement.VISIBLE;


public class HeaderComponent extends AbstractPage {

    private By searchLabel = By.xpath("//*[@class='form-control border-left-0 searchinput']");
    private By mainLogo = By.xpath("//a[@class='brand']");
    private By languageDropdownMain = By.xpath("//a[@class='dropdown-toggle']");
    private By iconNotification = By.xpath("//div[@class='popover-region-toggle nav-link']");
    private By iconMessage = By.xpath("//img[@title='Toggle messages menu']");
    private By messagedrawertoggle = By.xpath("//*[@alt='Toggle messaging drawer']");
    private By userLogo = By.xpath("//img[@class='userpicture defaultuserpic']");


    @Step("Click on mainLogo")
    public void clickOnMainLogo() {
        getElement(mainLogo, VISIBLE).click();
    }

    @Step("Verify page is reloaded")
    public void verifyPageIsReloaded() {
        executeJS().executeScript("arguments[0].setAttribute('class', 'null')", getElement(userLogo, VISIBLE));
        clickOnMainLogo();
        Assert.assertFalse(getElement(userLogo, VISIBLE).getAttribute("class").contains("null"),
                "Verify page is reloaded");
    }

    @Step("Click on searchLabel")
    public HeaderComponent clickOnSearchLabel() {
        getElement(messagedrawertoggle, VISIBLE).click();
        return this;
    }

    @Step("Click on searchLabel when window is minimized")
    public HeaderComponent clickOnSearchLabelWithMinimizedWindow() {
        minimizeWindow();
        getElement(messagedrawertoggle, VISIBLE).click();
        return this;
    }

    @Step("Verify search panel is displayed")
    public void verifySearchPanelDisplayed() {
        By searchPanel = By.xpath("//*[@class='form-control border-left-0 searchinput']");
        Assert.assertTrue(isElementDisplayed(searchPanel),"Verify search panel is displayed");
    }

    @Step("Click on languageDropdown")
    public HeaderComponent clickOnLanguageDropdown() {
        getElement(languageDropdownMain, CLICKABLE).click();
        return this;
    }

    @Step("Change language")
    public String changeLanguage(String lang) {
        By languageEng=By.xpath("//ul[@class='dropdown-menu']//a");;
        if(lang !="English (en)"){
            getElements(languageEng, WaitConditions.PageElements.PRESENT).get(0).click();
            return getElements(languageEng, WaitConditions.PageElements.PRESENT).get(0).getText();
        }
        else{
            getElements(languageEng, WaitConditions.PageElements.PRESENT).get(1).click();
            return getElements(languageEng, WaitConditions.PageElements.PRESENT).get(1).getText();
        }
    }

    @Step("Verify user change language")
    public void verifyUserchangeLanguage(String lang) {
        By languageCheckOut = By.xpath("//li[@class='dropdown langmenu']//a");
        if(lang =="English (en)"){
            Assert.assertEquals(getElement(languageCheckOut,VISIBLE).getText(),"Українська (uk)" ,
                    "Verify user change language");
        }
        else{
            Assert.assertEquals(getElement(languageCheckOut, VISIBLE).getText(),"English (en)",
                    "Verify user change language" );
        }
    }

    @Step("Verify language")
    public String verifyLanguage() {
        By languageCheckOut = By.xpath("//li[@class='dropdown langmenu']//a");
        return getElement(languageCheckOut, VISIBLE).getText();
    }


    @Step("Click on iconNotification")
    public HeaderComponent clickOnIconNotification() {
        getElement(iconNotification, CLICKABLE).click();
        return this;
    }

    @Step("Verify Notification wingow is displayed")
    public void verifyNotificationWingowDisplayed() {
        By notificationWingow = By.xpath("//div[@class='popover-region-header-actions']");
        Assert.assertTrue(isElementDisplayed(notificationWingow),"Verify Notification wingow is displayed");
    }

    @Step("Click on iconMessage")
    public HeaderComponent clickOnIconMessage() {
        getElement(messagedrawertoggle, VISIBLE).click();
        return this;
    }

    @Step("Verify Message wingow is displayed")
    public void verifyMessageWingowDisplayed() {
        By messageWingow = By.xpath("//*[@class='message-drawer bg-light']");
        Assert.assertTrue(isElementDisplayed(messageWingow));
    }

    @Step("Click on userLogo")
    public HeaderComponent clickOnUserLogo() {
        getElement(userLogo, VISIBLE).click();
        return this;
    }

    @Step("Verify action-menu wingow is displayed")
    public void verifyActionMenuWingowDisplayed() {
        By actionMenuWingow = By.xpath("//ul[@id='action-menu-0-menu']");
        Assert.assertTrue(isElementDisplayed(actionMenuWingow),"Verify action-menu wingow is displayed");
    }


}
