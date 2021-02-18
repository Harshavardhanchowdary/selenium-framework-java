package org.hck.driver;

import org.hck.constants.FrameworkConstants;
import org.hck.enums.ConfigProperties;
import org.hck.utils.PropertyFileUtil;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Objects;


/**
 * Driver class provides a methods to initialize and terminate WebDriver instances.
 *
 * @see DriverManager
 * @see <a href="https://www.selenium.dev/documentation/en/webdriver/driver_requirements/">docs.Selenium:Driver Requirement</a>
 * @author Harshavardhan Kavuri
 * @version 1.0
 */
public final class Driver {

    /**
     * Singleton classes-prevent class instances being created in any place other than this very class.
     */
    private Driver() {

    }

    /**
     * Launches a browser instance with the specified browser name and application URL.
     */
    public static void initDriver() {
        if (Objects.isNull(DriverManager.getDriver())) {
            System.setProperty("webdriver.chrome.driver", FrameworkConstants.getChromeDriverPath());
            DriverManager.setWebDriver(new ChromeDriver());
            DriverManager.getDriver().manage().window().maximize();
            DriverManager.getDriver().get(PropertyFileUtil.get(ConfigProperties.URL));

        }
    }

    /**
     * Quits the instance of a browser.
     */
    public static void tearDown() {
        if (Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
        }
    }


}
