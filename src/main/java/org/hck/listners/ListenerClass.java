package org.hck.listners;

import org.hck.annotations.FrameworkAnnotation;
import org.hck.reports.ExtentLogger;
import org.hck.reports.ExtentReport;
import org.testng.*;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

public class ListenerClass implements ITestListener, ISuiteListener {


    @Override
    public void onStart(ISuite suite) {
        ExtentReport.initReports();
    }


    @Override
    public void onFinish(ISuite suite) {
        ExtentReport.flushReports();
    }


    @Override
    public void onTestStart(ITestResult result) {
        if (Objects.isNull(result.getMethod().getDescription()) || result.getMethod().getDescription().equals("")) {
            ExtentReport.createTest(result.getMethod().getMethodName());
        } else {
            ExtentReport.createTest(result.getMethod().getDescription());
        }

        ExtentReport.addAuthors(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class).author());
        ExtentReport.addCategories(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class).category());
        gerDevice(result.getParameters());
        ExtentReport.addBrowser(gerDevice(result.getParameters()).toUpperCase());

    }

    private String gerDevice(Object[] obj){
        Map<String, String> map = (Map<String, String>)obj[0];
        return map.get("browser");
    }


    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentLogger.pass("<h3 style=\"color:green;\">'" + result.getMethod().getMethodName().toUpperCase() + "' is Passed.</h3>");

    }


    @Override
    public void onTestFailure(ITestResult result) {
        ExtentLogger.fail("<h3 style=\"color:red;\"}>'" + result.getMethod().getMethodName().toUpperCase() + "' is Failed.</h3>");
        ExtentLogger.fail(result.getThrowable().getMessage());
        ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));
    }


    @Override
    public void onTestSkipped(ITestResult result) {

        ExtentLogger.skip("<h3 style=\"color:yellow;\">'" + result.getMethod().getMethodName().toLowerCase() + "' is Skipped.</h3>");

    }


    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        /*
         * No Implementations yet
         */
    }


    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        /*
         * No Implementations yet
         */
    }

    @Override
    public void onStart(ITestContext context) {
        /*
         * No Implementations yet
         */
    }

    @Override
    public void onFinish(ITestContext context) {
        /*
         * No Implementations yet
         */
    }
}
