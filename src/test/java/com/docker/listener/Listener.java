package com.docker.listener;

import com.docker.base.BasePage;
import com.docker.report.ExtentLogger;
import com.docker.report.ExtentReport;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * Created by Fatih Can Oklay
 * Date: 23.04.2023
 */

public class Listener extends BasePage implements ITestListener, ISuiteListener {

    @Override //before method
    public void onTestStart(ITestResult result) {
        ExtentReport.createTest(result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentLogger.pass(result.getName() + " is passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        screenShot("failScreenShot");
        ExtentLogger.fail(result.getName() + " is failed");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentLogger.skip(result.getName() + " is skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
    }

    @Override //before suite
    public void onStart(ITestContext context) {
        ExtentReport.initReports();
    }

    @Override //after suite
    public void onFinish(ITestContext context) {
        ExtentReport.tearDownReports();
    }
}
