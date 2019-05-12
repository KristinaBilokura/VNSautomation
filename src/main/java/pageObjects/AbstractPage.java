package pageObjects;

import driver.DriverFactory;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WaitConditions;

import java.util.ArrayList;
import java.util.List;

import static consts.Constants.Number.WEB_DRIVER_SLEEP_TIME;
import static utils.WaitConditions.PageElement.VISIBLE;

public abstract class AbstractPage extends DriverFactory {

    private static int webDriverWaitTime;

    private int getWebDriverWaitTime() {
        return webDriverWaitTime;
    }

    public static void setWebDriverWaitTime(int waitTime) {
        webDriverWaitTime = waitTime;
    }

    private Actions getActions() {
        return new Actions(DriverFactory.getDriver());
    }

    private WebDriverWait getWait() {
        return new WebDriverWait(DriverFactory.getDriver(), getWebDriverWaitTime(), WEB_DRIVER_SLEEP_TIME);
    }

    protected WebElement getElement(final By locator, final WaitConditions.PageElement condition) {
        WebElement webElement = getWait().until(condition.getType().apply(locator));
        getActions().moveToElement(webElement).build().perform();
        return webElement;
    }

    List<WebElement> getElements(final By locator, final WaitConditions.PageElements condition) {
        return getWait().until(condition.getType().apply(locator));
    }

    protected boolean isElementDisplayed(final By locator) {
        try {
            return getElement(locator, VISIBLE).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    @Step("Get page")
    protected void getPage(final String url) {
        DriverFactory.getDriver().get(url);
    }

    @Step("Get to tab")
    public boolean switchToTab(String tabName) {
        ArrayList<String> tab = new ArrayList<>(DriverFactory.getDriver().getWindowHandles());
        ArrayList<String> tabList = new ArrayList<>();
        for (int i = 0; i < tab.size(); i++) {
            tabList.add(i, DriverFactory.getDriver().switchTo().window(tab.get(i)).getTitle());
            DriverFactory.getDriver().switchTo().window(tab.get(0));
            if (tabList.get(i).equals(tabName)) {
                DriverFactory.getDriver().switchTo().window(tab.get(i));
                return true;
            }
        }
        return false;
    }


    public JavascriptExecutor executeJS() {
        JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
        return js;
    }

    public Actions executeActions() {
        return new Actions(DriverFactory.getDriver());
    }

    public void minimizeWindow() {
        Dimension n = new Dimension(600,592);
        DriverFactory.getDriver().manage().window().setSize(n);
    }

}
