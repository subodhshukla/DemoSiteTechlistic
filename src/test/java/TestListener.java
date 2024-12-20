import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    // This will be used to mark the test suite as failed if any test fails
    private boolean isFailureDetected = false;

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test "+result.getName()+" started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // Not needed for this example
        System.out.println("Test "+result.getName()+" Pass");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // Set failure flag to true if any test fails
        if (isFailureDetected = true) {
            System.out.println("Test " + result.getName() + " started");
        }
    }
    @Override
    public void onTestSkipped(ITestResult result) {
        // Not needed for this example
            System.out.println("Test "+result.getName()+" Skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // Not needed for this example
    }

    @Override
    public void onStart(ITestContext context) {
        // Not needed for this example
    }

    @Override
    public void onFinish(ITestContext context) {
        // If there was a failure, mark the overall build as failed
        if (isFailureDetected) {
            System.out.println("Test Execution failed due to one or more failed tests.");
        } else {
            System.out.println("All tests passed.");
        }
    }
}