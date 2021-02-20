package org.hck.driver;

import org.hck.enums.ConfigProperties;
import org.hck.exceptions.BrowserInvocationFailedException;
import org.hck.factories.DriverFactory;
import org.hck.utils.PropertyFileUtil;

import java.net.MalformedURLException;
import java.util.Objects;


/**
 * Driver class provides a methods to initialize and terminate WebDriver instances.
 *
 * @author Harshavardhan Kavuri
 * @version 1.0
 * @see DriverManager
 * @see <a href="https://www.selenium.dev/documentation/en/webdriver/driver_requirements/">docs.Selenium:Driver Requirement</a>
 */
public final class Driver {

    /**
     * Singleton classes-prevent class instances being created in any place other than this very class.
     */
    private Driver() {

    }


    /**
     * Launches a browser instance with the specified browser name and application URL.
     * @param browser browser name
     * @throws BrowserInvocationFailedException Thrown when a browser invocation failed.
     */
    public static void initDriver(String browser) {

        if (Objects.isNull(DriverManager.getDriver())) {
            try {
                DriverManager.setWebDriver(DriverFactory.getDriver(browser));
            } catch (MalformedURLException e) {
                throw new BrowserInvocationFailedException("Browser Invocation failed. Please check the capabilities.");
            }
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
            DriverManager.unload();
        }
    }


}
