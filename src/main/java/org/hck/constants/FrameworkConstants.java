package org.hck.constants;

import org.hck.enums.ConfigProperties;
import org.hck.utils.PropertyFileUtil;

/**
 * FrameworkConstants class holds all the contents required to for the framework.
 * Ex: Test Resources path, PropertyFiles, Drivers, Timeouts
 *
 * @author Harshavardhan Kavuri
 * @version 1.0
 * @since 1.0
 */
public final class FrameworkConstants {


    /**
     * Holds path to test resources folder.
     */
    private static final String TEST_RESOURCES_ROOT_PATH = System.getProperty("user.dir") + "/src/test/resources";
    /**
     * Holds path to ChromeDriver executable.
     */
    private static final String CHROME_DRIVER_PATH = TEST_RESOURCES_ROOT_PATH + "/executables/chromedriver";
    /**
     * Holds path to ChromeDriver executable.
     */
    private static final String GECKO_DRIVER_PATH = TEST_RESOURCES_ROOT_PATH + "/executables/geckodriver";

    /**
     * Holds path to testing properties file.
     */
    private static final String PROPERTY_FILE_PATH = TEST_RESOURCES_ROOT_PATH + "/config/testconfig.properties";
    /**
     * Holds explicit wait time in seconds.
     */
    private static final int EXPLICIT_WAIT_TIMEOUT = Integer.parseInt(PropertyFileUtil.getProp(ConfigProperties.EXPLICITWAITTIMEOUT));

    /**
     * Holds path to Test Data.
     */
    private static final String TEST_DATA_FILE_PATH = TEST_RESOURCES_ROOT_PATH + "/data/TestData.xlsx";

    /**
     * Holds path to extent reports folder.
     */
    private static final String EXTENT_REPORTS_PATH = System.getProperty("user.dir") + "/extent-test-output";

    private static String EXTENT_REPORT_FILE_PATH = "";

    /**
     * Singleton classes-prevent class instances being created in any place other than this very class.
     */
    private FrameworkConstants() {
    }

    /**
     * Returns Extent Report file path.
     * If 'OVERRIDEREPORTS' property is set to 'Yes' then HTML file name with currentTimeMillis+index.html is generated
     * else index.html file is generated.
     *
     * @return Extent Report file path
     */
    public static String getExtentReportsPath() {
        if (EXTENT_REPORT_FILE_PATH.isEmpty()
                && PropertyFileUtil.getProp(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("no")) {
            EXTENT_REPORT_FILE_PATH = EXTENT_REPORTS_PATH + "/" + System.currentTimeMillis() + "index.htm";
        } else {
            EXTENT_REPORT_FILE_PATH = EXTENT_REPORTS_PATH + "/index.html";
        }
        return EXTENT_REPORT_FILE_PATH;
    }

    /**
     * Returns the test data file path.
     *
     * @return Test Data file path.
     */
    public static String getTestDataFilePath() {
        return TEST_DATA_FILE_PATH;
    }

    /**
     * Returns explicit wait time in seconds.
     *
     * @return explicit wait time in seconds.
     */
    public static int getExplicitWaitTimeout() {
        return EXPLICIT_WAIT_TIMEOUT;
    }

    /**
     * Returns the chrome driver executable path.
     *
     * @return chromeDriver executable path.
     */
    public static String getChromeDriverPath() {
        return CHROME_DRIVER_PATH;
    }

    /**
     * Returns the firefox driver executable path.
     *
     * @return firefox executable path.
     */
    public static String getGeckoDriverPath() {
        return GECKO_DRIVER_PATH;
    }

    /**
     * Returns the properties file path.
     *
     * @return properties file path.
     */
    public static String getPropertyFilePath() {
        return PROPERTY_FILE_PATH;
    }


}
