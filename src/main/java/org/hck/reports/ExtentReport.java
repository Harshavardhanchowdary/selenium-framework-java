package org.hck.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.hck.constants.FrameworkConstants;
import org.hck.enums.TestCategoryType;


import java.util.Objects;

/**
 * ExtentReport Class is responsible for initializing the ExtentReports and Flushing reports to reports folder.
 * It also provides ways to create ExtentTest.
 * @see ExtentManager
 * @see FrameworkConstants
 * @see <a href="https://www.extentreports.com/docs/versions/5/java/index.html">docs.ExtentReports:Java</a>
 * @author Harshavardhan Kavuri
 * @version 1.0
 * @since 1.0
 */
public final class ExtentReport {

    private static ExtentReports extent;

    /**
     * Singleton classes-prevent class instances being created in any place other than this very class.
     */
    private ExtentReport() {

    }

    /**
     * Initializes the ExtentReport.
     * A HTML report is created with file name obtained from FrameworkConstants.getExtentReportsPath()
     *
     */
    public static void initReports() {
        if (Objects.isNull(extent)) {
            extent = new ExtentReports();
            ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getExtentReportsPath());
            extent.attachReporter(spark);
            spark.config().setTheme(Theme.STANDARD);
            spark.config().setReportName("UI AUTOMATION HK");
            spark.config().setDocumentTitle("HK REPORT");
        }
    }

    /**
     * Flushes the extent report.
     */
    public static void flushReports() {
        if (Objects.nonNull(extent)) {
            extent.flush();
        }
        ExtentManager.unload();
    }

    /**
     * Create the ExtentTest and sets the ExtentTest ThreadLocal variable.
     * @param testCaseName TestCase name
     */
    public static void createTest(String testCaseName) {
        ExtentManager.setExtentTest(extent.createTest(testCaseName));
    }

    /**
     * Adds author to extent test.
     * @param authors list of authors.
     */
    public static void addAuthors(String[] authors){
        for(String author: authors){
            ExtentManager.getExtentTest().assignAuthor(author);
        }
    }


    public static void addCategories(TestCategoryType[] categories){
        for(TestCategoryType cat: categories){
            ExtentManager.getExtentTest().assignCategory(cat.toString());
        }
    }

    public static void addBrowser(String browser){
            ExtentManager.getExtentTest().assignDevice(browser);

    }




}