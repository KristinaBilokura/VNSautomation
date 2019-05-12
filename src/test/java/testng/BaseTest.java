package testng;

import driver.DriverFactory;
import listeners.CustomITestListener;
import org.testng.annotations.*;
import java.lang.reflect.Method;

import static pageObjects.AbstractPage.setWebDriverWaitTime;

@Listeners(CustomITestListener.class)
public abstract class BaseTest extends DriverFactory {

    @Parameters({"browserName", "webDriverWaitTime"})
    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(@Optional(value = "Chrome") final String browserName,
                             @Optional(value = "15") int webDriverWaitTime) {
        initDriver(browserName);
        setWebDriverWaitTime(webDriverWaitTime);
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(final Method method) {
        quitDriver();
    }

}
