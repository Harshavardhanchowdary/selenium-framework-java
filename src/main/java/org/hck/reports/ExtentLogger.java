package org.hck.reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.Markup;
import org.hck.enums.ConfigProperties;
import org.hck.utils.PropertyFileUtil;
import org.hck.utils.ScreenShotUtil;


/**
 * ExtentLogger class exposes methods to log during test execution.
 *
 * @author Harshavardhan Kavuri
 * @version 1.0
 * @see ExtentManager#getExtentTest()
 * @see ConfigProperties
 * @see ScreenShotUtil#getBase64Image()
 * @since 1.0
 */
public final class ExtentLogger {

    /**
     * singleton classes-prevent class instances being created in any place other than this very class.
     */
    private ExtentLogger() {
    }

    /**
     * Logs message to extent with PASS Status.
     *
     * @param message message to be logged.
     */
    public static void pass(String message) {
        ExtentManager.getExtentTest().pass(message);
    }

    /**
     * Logs Markup to extent with PASS Status.
     *
     * @param markup Markup message to be logged.
     */
    public static void pass(Markup markup) {
        ExtentManager.getExtentTest().pass(markup);
    }

    /**
     * Logs message to extent with PASS Status along with the base64 image. <br>If <code>captureScreenShot==true</code> and <code>ConfigProperties.PASSEDSTEPSSCREENSHOTS == true</code>.
     *
     * @param message           Message to be logged.
     * @param captureScreenShot if <code>true</code> base64 image will be captured. else no image will be captured.
     * @see ScreenShotUtil#getBase64Image()
     * @see ConfigProperties
     */
    public static void pass(String message, boolean captureScreenShot) {
        if (captureScreenShot &&
                PropertyFileUtil.getProp(ConfigProperties.PASSEDSTEPSSCREENSHOTS).equalsIgnoreCase("yes")) {
            ExtentManager.getExtentTest().pass(message,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenShotUtil.getBase64Image()).build());
        } else {
            pass(message);
        }

    }

    /**
     * Logs message to extent with FAIL Status.
     *
     * @param message message to be logged.
     */
    public static void fail(String message) {
        ExtentManager.getExtentTest().fail(message);
    }

    /**
     * Logs Markup to extent with FAIL Status.
     *
     * @param markup Markup message to be logged.
     */
    public static void fail(Markup markup) {
        ExtentManager.getExtentTest().fail(markup);
    }

    /**
     * Logs message to extent with FAIL Status along with the base64 image. <br>If <code>captureScreenShot==true</code> and <code>ConfigProperties.FAILEDSTEPSSCREENSHOTS == true</code>.
     *
     * @param message           Message to be logged.
     * @param captureScreenShot if <code>true</code> base64 image will be captured. else no image will be captured.
     * @see ScreenShotUtil#getBase64Image()
     * @see ConfigProperties
     */
    public static void fail(String message, boolean captureScreenShot) {
        if (captureScreenShot &&
                PropertyFileUtil.getProp(ConfigProperties.FAILEDSTEPSSCREENSHOTS).equalsIgnoreCase("yes")) {
            ExtentManager.getExtentTest().fail(message,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenShotUtil.getBase64Image()).build());
        } else {
            fail(message);
        }

    }

    /**
     * Logs message to extent with SKIP Status.
     *
     * @param message message to be logged.
     */
    public static void skip(String message) {
        ExtentManager.getExtentTest().skip(message);
    }

    /**
     * Logs Markup to extent with SKIP Status.
     *
     * @param markup Markup message to be logged.
     */
    public static void skip(Markup markup) {
        ExtentManager.getExtentTest().skip(markup);
    }

    /**
     * Logs message to extent with SKIP Status along with the base64 image. <br>If <code>captureScreenShot==true</code> and <code>ConfigProperties.SKIPPEDSTEPSSCREENSHOTS == true</code>.
     *
     * @param message           Message to be logged.
     * @param captureScreenShot if <code>true</code> base64 image will be captured. else no image will be captured.
     * @see ScreenShotUtil#getBase64Image()
     * @see ConfigProperties
     */
    public static void skip(String message, boolean captureScreenShot) {
        if (captureScreenShot &&
                PropertyFileUtil.getProp(ConfigProperties.SKIPPEDSTEPSSCREENSHOTS).equalsIgnoreCase("yes")) {
            ExtentManager.getExtentTest().skip(message,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenShotUtil.getBase64Image()).build());
        } else {
            skip(message);
        }

    }

    /**
     * Logs message to extent with INFO Status.
     *
     * @param message message to be logged.
     */
    public static void info(String message) {
        ExtentManager.getExtentTest().info(message);
    }

    /**
     * Logs message to extent with WARNING Status.
     *
     * @param message message to be logged.
     */
    public static void warning(String message) {
        ExtentManager.getExtentTest().warning(message);
    }


}

