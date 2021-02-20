package org.hck.factories;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.hck.constants.FrameworkConstants;
import org.hck.driver.Driver;
import org.hck.driver.DriverManager;
import org.hck.enums.ConfigProperties;
import org.hck.utils.PropertyFileUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Driver factory produces browser instances based on supplied browser name and execution mode(remote or local).
 *
 * @author Harshavardhan Kavuri
 * @version 1.0
 * @see DriverManager
 * @see Driver
 * @see <a href="https://www.selenium.dev/documentation/en/webdriver/driver_requirements/">docs.Selenium:Driver Requirement</a>
 */
public final class DriverFactory {

    /**
     * Singleton classes-prevent class instances being created in any place other than this very class.
     */
    private DriverFactory() {
    }

    /**
     * Returns the browser instance based on provided browser name.
     * Browser instance returned based on {@link org.hck.enums.ConfigProperties#RUNMODE}
     * 
     * @param browser name of the browser
     * @return browser instance
     * @throws MalformedURLException Thrown to indicate that a malformed URL has occurred. Either no legal protocol could be found in a specification string or the string could not be parsed.
     * @see ConfigProperties
     * @see RemoteWebDriver
     * @see DesiredCapabilities
     * @see PropertyFileUtil#get(ConfigProperties)
     */
    public static WebDriver getDriver(String browser) throws MalformedURLException {
        WebDriver driver = null;
        String runMode = PropertyFileUtil.getProp(ConfigProperties.RUNMODE);
        if (browser.equalsIgnoreCase("chrome")) {
            if (runMode.equalsIgnoreCase("remote")) {
                DesiredCapabilities cap = new DesiredCapabilities();
                cap.setBrowserName(BrowserType.CHROME);

                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);

            } else {

                driver = getChromeDriver();
            }
        } else if (browser.equalsIgnoreCase("firefox")) {
            if (runMode.equalsIgnoreCase("remote")) {
                DesiredCapabilities cap = new DesiredCapabilities();
                cap.setBrowserName(BrowserType.FIREFOX);
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);

            } else {
                driver=getFirefoxDriver();
            }
        }

        return driver;
    }


    /**
     * Returns Chrome driver instance.
     * if {@link org.hck.enums.ConfigProperties#USEWEBDRIVERMANAGER}='yes', then the driver instance is crated
     * using {@link WebDriverManager}, else local chrome executable is used.
     *
     * @return chrome driver instance
     */
    private static WebDriver getChromeDriver(){
        if (PropertyFileUtil.get(ConfigProperties.USEWEBDRIVERMANAGER).equalsIgnoreCase("yes")) {
            WebDriverManager.chromedriver().setup();
        } else {
            System.setProperty("webdriver.chrome.driver", FrameworkConstants.getChromeDriverPath());
        }
        return new ChromeDriver();
    }


    /**
     * Returns firefox driver instance.
     * if {@link org.hck.enums.ConfigProperties#USEWEBDRIVERMANAGER}='yes', then the driver instance is crated
     * using {@link WebDriverManager}, else local firefox executable is used.
     * @return Firefox driver instance.
     */

    private static WebDriver getFirefoxDriver(){
        if (PropertyFileUtil.get(ConfigProperties.USEWEBDRIVERMANAGER).equalsIgnoreCase("yes")) {
            WebDriverManager.firefoxdriver().setup();
        } else {
            System.setProperty("webdriver.gecko.driver", FrameworkConstants.getGeckoDriverPath());
        }
        return new FirefoxDriver();
    }


}
