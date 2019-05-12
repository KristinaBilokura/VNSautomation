package listeners;

import io.qameta.allure.Allure;
import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.Attachments;

public class CustomITestListener implements ITestListener {

    private Logger LOGGER = Logger.getLogger(Logger.class);
    public static ThreadLocal<String> allureTestCaseJsonFilePartialNameThreadLocal = new ThreadLocal<>();

    private void logTestRunStatus(final ITestResult iTestResult, final String runStatus) {
        String testDescription = iTestResult.getMethod().getDescription();
        if (testDescription != null ) {
            LOGGER.info(testDescription + " " + runStatus);
        } else {
            LOGGER.info(iTestResult.getMethod().getMethodName() + " " + runStatus);
        }
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        logTestRunStatus(iTestResult, "PASSED");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        new Attachments().
                attachScreenshot();
        String allureTestCaseJsonFilePartialName;
        logTestRunStatus(iTestResult, "FAILED");
        if (Allure.getLifecycle().getCurrentTestCase().isPresent()) {
            allureTestCaseJsonFilePartialName = Allure.getLifecycle().getCurrentTestCase().get();
            allureTestCaseJsonFilePartialNameThreadLocal.set(allureTestCaseJsonFilePartialName);
        }
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        logTestRunStatus(iTestResult, "SKIPPED");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }


}
