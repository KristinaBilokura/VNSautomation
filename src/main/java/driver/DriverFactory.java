package driver;

import consts.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public abstract class DriverFactory {

    private static ThreadLocal<WebDriver> threadLocalWebDriver = new ThreadLocal<>();
    private WebDriver webDriver;

    protected void initDriver(final String browserName) {
        if (Constants.Configuration.CHROME_NAME.equalsIgnoreCase(browserName)) {
            System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
            webDriver = new ChromeDriver();
        } else if (Constants.Configuration.FIREFOX_NAME.equalsIgnoreCase(browserName)) {
            WebDriverManager.firefoxdriver().setup();
            webDriver = new FirefoxDriver();
        } else if (Constants.Configuration.EDGE_NAME.equalsIgnoreCase(browserName)) {
            WebDriverManager.edgedriver().setup();
            webDriver = new EdgeDriver();
        }
        if (webDriver instanceof ChromeDriver) {
            webDriver.manage().window().maximize();
        }
        threadLocalWebDriver.set(webDriver);
    }

    public static WebDriver getDriver() {
        return threadLocalWebDriver.get();
    }

    protected void quitDriver() {
        if (webDriver != null) {
            threadLocalWebDriver.get().quit();
            threadLocalWebDriver.remove();
        }
    }
}
