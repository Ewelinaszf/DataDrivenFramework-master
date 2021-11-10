package base.listeners;

import base.TestBase;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.*;
import utilities.TestUtil;

import java.io.IOException;
import java.util.Locale;

public class CustomListeners extends TestBase implements ITestListener {
    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.log(LogStatus.PASS, result.getName().toUpperCase(Locale.ROOT)+" PASS");
        extent.endTest(extentTest);
        extent.flush();
    }
    @Override
    public void onTestStart(ITestResult result) {
        extentTest = extent.startTest(result.getName().toUpperCase(Locale.ROOT));

    }


    @Override
    public void onTestFailure(ITestResult result) {
        System.setProperty("org.uncommons.reportng.escape-output","false");
        try {
            TestUtil.captureScreenshot();
        } catch (IOException e) {
            e.printStackTrace();
        }

        extentTest.log(LogStatus.FAIL, result.getName().toUpperCase(Locale.ROOT)+" FAILED with exception: "+ result.getThrowable());
        extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(TestUtil.screenshotName));

        Reporter.log("<a target=\"_blank\" href="+ TestUtil.screenshotName+">Screenshot</a>");
        Reporter.log("<br>");
        Reporter.log("<a target=\"_blank\" href="+ TestUtil.screenshotName+"><img src="+ TestUtil.screenshotName+" height=200 width=200></img></a>");
        extent.endTest(extentTest);
        extent.flush();

    }



    @Override
    public void onTestSkipped(ITestResult result) {
        extentTest.log(LogStatus.SKIP, result.getName().toUpperCase(Locale.ROOT)+" Skipped with exception: "+ result.getThrowable());
        extent.endTest(extentTest);
        extent.flush();
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {
      
    }
}
