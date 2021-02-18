package org.hck.utils;


import org.hck.driver.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

/**
 * ExcelUtil class is responsible for taking screenshot of an web page..
 * @author Harshavardhan Kavuri
 * @version 1.0
 * @see DriverManager#getDriver()
 * @since 1.0
 */
public final class ScreenShotUtil {

    /**
     * Singleton classes-prevent class instances being created in any place other than this very class.
     */
    private ScreenShotUtil() {
    }


    /**
     * Gets the base64 encoded screenshot of the web page.
     * @return Base64Image
     */
    public static String getBase64Image() {
        return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
    }
}