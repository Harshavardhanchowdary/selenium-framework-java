package org.hck.reports;

import com.aventstack.extentreports.ExtentTest;

/**
 * ExtentManager class provides a thread-safe ExtentTest instance to work with.
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
public final class ExtentManager {

    private static final ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    /**
     * singleton classes-prevent class instances being created in any place other than this very class.
     */
    private ExtentManager() {
    }

    /**
     * Returns the ExtentTest value in the current thread's copy of this thread-local variable.
     * @return ExtentTest instance.
     */
    static ExtentTest getExtentTest() {
        return extentTest.get();
    }

    /**
     * Sets the current thread's copy of this thread-local variable to the specified value.
     * @param test ExtentTest object.
     */
    static void setExtentTest(ExtentTest test) {
        extentTest.set(test);
    }

    /**
     * Removes the current thread's value for this thread-local variable. In this case ExtentTest object.
     */
    public static void unload() {
        extentTest.remove();
    }
}