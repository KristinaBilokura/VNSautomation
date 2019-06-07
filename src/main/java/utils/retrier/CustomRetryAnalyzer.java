package utils.retrier;

import org.apache.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class CustomRetryAnalyzer implements IRetryAnalyzer {
    private int count = 0;
    private static final Logger log = Logger.getLogger(CustomRetryAnalyzer.class);

    @Override
    public boolean retry(ITestResult iTestResult) {
        String testFailureMessage = iTestResult.getThrowable().toString();
        int maxTry = 3;

        if (testFailureMessage.contains("UnsupportedCommandException")
                || testFailureMessage.contains("Gateway Time-out")
                || testFailureMessage.contains("ERROR The test with session id")
                || testFailureMessage.contains("Invalid message")
                || testFailureMessage.contains("Due to a previous error")
                || testFailureMessage.contains("503 Service Unavailable")
                || testFailureMessage.contains("Bad Gateway")
                || testFailureMessage.contains("Invalid message")
                || testFailureMessage.contains("Proxy element for: DefaultElementLocator 'By.name: j_username'")
                || testFailureMessage.contains("An unknown server-side error")
                || testFailureMessage.contains("Internal Server Error")
                || testFailureMessage.contains("Invalid credentials")
                || testFailureMessage.contains("unique constraint")) {
            log.info("Sauce failure detected: Exception caught with message: " + testFailureMessage);
            if (count < maxTry) {
                count++;
                return true;
            }
        }
        return false;
    }

}