package pageObjects.preferences;

import consts.Constants;
import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import pageObjects.AbstractPage;

import static consts.Constants.Application.CHANGE_PASSWORD_PAGE_URL;

import static utils.WaitConditions.PageElement.CLICKABLE;
import static utils.WaitConditions.PageElement.VISIBLE;

public class ChangePasswordPage extends AbstractPage {
    private By currentPassword = By.id("id_password");
    private By newPassword = By.id("id_newpassword1");
    private By newPasswordConfirm = By.id("id_newpassword2");
    private By submitbutton = By.id("id_submitbutton");
    private static final Logger LOGGER = Logger.getLogger(ChangePasswordPage.class);
    public static String passwordRandom = RandomStringUtils.randomAlphabetic(Constants.Number.NEW_PASSWORD_RANDOM_LENGTH);

    @Step("Get ChangePasswordPage page")
    public ChangePasswordPage getChangePasswordPage() {
        getPage(CHANGE_PASSWORD_PAGE_URL);
        return this;
    }

    @Step("Change password")
    public ChangePasswordPage changePassword(final String studPassword, final String newStudPassword,
                                             final String newStudPassword2) {
        getElement(currentPassword, VISIBLE).sendKeys(studPassword);
        LOGGER.info("New password "+ newStudPassword);
        getElement(newPassword, VISIBLE).sendKeys(newStudPassword);
        LOGGER.info("New password2 "+ newStudPassword2);
        getElement(newPasswordConfirm, VISIBLE).sendKeys(newStudPassword2);
        getElement(submitbutton, CLICKABLE).click();
        return this;
    }

    @Step("Verify acception message displayed")
    public void verifyAcceptionMessageDisplayed() {
        By invalidCredentialsMessage = By.xpath("//div[@class='box errorbox']");
        Assert.assertFalse(isElementDisplayed(invalidCredentialsMessage),
                "Verify decline message is not displayed");
    }

    @Step("Verify require message displayed")
    public void verifyRequireMessageDisplayed() {
        By requireMessage = By.id("id_error_password");
        Assert.assertTrue(isElementDisplayed(requireMessage),
                "Verify require message is displayed");
    }

    @Step("Verify badRequest message displayed")
    public void verifyBadRequestMessageDisplayed() {
        By badRequestMessage = By.xpath("//span[@class='error']");
        Assert.assertTrue(isElementDisplayed(badRequestMessage),
                "Verify badRequest message is displayed");
    }
}
