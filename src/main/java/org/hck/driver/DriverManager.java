package org.hck.driver;

import org.openqa.selenium.WebDriver;

/**
 * DriverManager class provides a thread-safe WebDriver instance to work with.
 * <hr>
 * <p>
 * ThreadLocal instances are typically private static fields in classes that wish to associate state with a thread.
 * Each thread holds an implicit reference to its copy of a thread-local variable as long as the thread is alive and
 * the ThreadLocal instance is accessible; after a thread goes away, all of its copies of thread-local
 * instances are subject to garbage collection.
 *
 * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/lang/ThreadLocal.html">docs.oracle:ThreadLocal</a>
 * @author Harshavardhan Kavuri
 * @version 1.0
 *
 */
public final class DriverManager {


    /**
     * singleton classes-prevent class instances being created in any place other than this very class.
     */
    private DriverManager(){}

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    /**
     * Returns the value in the current thread's copy of this thread-local variable.
     * @return WebDriver instance.
     */
    public static WebDriver getDriver() {
        return driver.get();
    }


    /**
     * Sets the current thread's copy of this thread-local variable to the specified value.
     * @param dvr WebDriver object.
     */
    public static void setWebDriver(WebDriver dvr) {
        driver.set(dvr);
    }


    /**
     * Removes the current thread's value for this thread-local variable. In this case WebDriver object.
     */
    public static void unload() {
        driver.remove();
    }

}