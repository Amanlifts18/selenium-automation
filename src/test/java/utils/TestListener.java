package utils;

import base.BaseTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        ExtentManager.createTest(result.getMethod().getMethodName());
        ExtentManager.getTest().info("Test Started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentManager.getTest().pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentManager.getTest().fail(result.getThrowable());

        try {
            BaseTest base = (BaseTest) result.getInstance();
            File src = ((TakesScreenshot) base.getDriver()).getScreenshotAs(OutputType.FILE);

            String path = "screenshots/" + result.getMethod().getMethodName() + ".png";
            File dest = new File(path);
            FileUtils.copyFile(src, dest);

            ExtentManager.getTest().addScreenCaptureFromPath(path, "Failed Test Screenshot");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentManager.getTest().skip("Test Skipped");
    }

    @Override
    public void onStart(ITestContext context) {
        // Optional: code to run before all tests
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentManager.flush();
    }
}
