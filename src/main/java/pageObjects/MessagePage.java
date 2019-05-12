package pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;
import utils.WaitConditions;

import static consts.Constants.Application.MESSAGE_PAGE_URL;

public class MessagePage extends AbstractPage {
    By messageBox = By.xpath("//*[@id='region-main']");

    @Step("Get Message page")
    public MessagePage getMessagePagee() {
        getPage(MESSAGE_PAGE_URL);
        return this;
    }

    @Step("Verify message field displayed")
    public void verifyMessageFieldDisplayed() {
        Assert.assertTrue(getElement(messageBox, WaitConditions.PageElement.PRESENT).isDisplayed(),
                "Verify message field displayed");
    }
}
