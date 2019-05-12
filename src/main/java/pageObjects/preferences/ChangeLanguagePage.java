package pageObjects.preferences;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pageObjects.AbstractPage;

import static consts.Constants.Application.CHANGE_LANGUAGE_PAGE_URL;
import static utils.WaitConditions.PageElement.CLICKABLE;
import static utils.WaitConditions.PageElement.PRESENT;
import static utils.WaitConditions.PageElement.VISIBLE;

public class ChangeLanguagePage extends AbstractPage {
    private By languageDropdown = By.id("id_lang");
    private By submitbutton = By.id("id_submitbutton");
    private By languageDropdownMain = By.xpath("//a[@class='dropdown-toggle']");

    public static String currentLanguage;

    @Step("Get ChangeLanguage page")
    public ChangeLanguagePage getChangeLanguagePage() {
        getPage(CHANGE_LANGUAGE_PAGE_URL);
        return this;
    }

    @Step("Change language")
    public ChangeLanguagePage changeLanguage() {
        Select select = new Select(getElement(languageDropdown, PRESENT));
        if (select.getOptions().get(0).isSelected()) {
            currentLanguage = select.getOptions().get(0).getText();
            select.getOptions().get(1).click();
        } else {
            currentLanguage = select.getOptions().get(1).getText();
            select.getOptions().get(0).click();
        }
        getElement(submitbutton, CLICKABLE).click();
        return this;
    }


    @Step("Verify language is changed")
    public void verifyLanguageChanged() {
        Assert.assertNotEquals(getElement(languageDropdownMain, PRESENT).getText(), currentLanguage,
                "Verify language is changed");
    }
}
