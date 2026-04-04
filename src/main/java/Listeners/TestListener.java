package Listeners;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
public class TestListener implements ITestListener {
    private static final Logger log = LogManager.getLogger(TestListener.class);
    @Override
    public void onTestStart(ITestResult result) {
        log.info(result.getMethod().getMethodName());
    }
    @Override
    public void onTestSuccess(ITestResult result) {
        log.info("TEST PASSED: {}", result.getMethod().getMethodName());
    }
    @Override
    public void onTestFailure(ITestResult result) {
        log.error("TEST FAILED: {}", result.getMethod().getMethodName());
        if (result.getThrowable() != null) {
            log.error("Error: ", result.getThrowable());
        }
    }
    @Override
    public void onTestSkipped(ITestResult result) {
        log.warn("TEST SKIPPED: {}", result.getMethod().getMethodName());
    }
    @Override
    public void onStart(ITestContext context) {
        log.info("STARTING TEST SUITE: {}", context.getName());
    }
    @Override
    public void onFinish(ITestContext context) {
        log.info("FINISHING TEST SUITE: {}", context.getName());
    }
}