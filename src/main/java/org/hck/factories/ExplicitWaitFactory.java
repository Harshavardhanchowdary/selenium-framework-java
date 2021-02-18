package org.hck.factories;

import org.hck.constants.FrameworkConstants;
import org.hck.driver.DriverManager;
import org.hck.enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * ExplicitWaitFactory class provides a waiting mechanism before throwing an exception while finding an element ina a web page.
 * @author Harshavardhan Kavuri
 * @version 1.0
 * @see FrameworkConstants
 * @see DriverManager#getDriver()
 * @see org.openqa.selenium.support.ui.ExpectedConditions
 * @since 1.0
 */
public final class ExplicitWaitFactory {

    private ExplicitWaitFactory() {

    }

    /**
     * Finds and returns a <code>WebElement</code> based on the <code>ExpectedCondition</code>, else throws an exception.
     *
     * @param by Mechanism used to locate elements within a document
     * @param waitStrategy <code>ExpectedCondition</code> to be checked before throwing an exception.<br>
     *                     Available strategies: WaitStrategy.PRESENCE, WaitStrategy.CLICKABLE, WaitStrategy.VISIBLE, WaitStrategy.NONE
     * @return <code>WebElement</code>
     * @see <a href="https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/support/ui/ExpectedConditions.html">doc.selenium:ExpectedCondition</a>
     * @see FrameworkConstants
     * @see DriverManager#getDriver()
     *
     */
    public static WebElement performExplicitWait(By by, WaitStrategy waitStrategy) {
        WebElement element = null;
        if (waitStrategy == WaitStrategy.PRESENCE) {
            element = new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitWaitTimeout())
                    .until(ExpectedConditions.presenceOfElementLocated(by));
        } else if (waitStrategy == WaitStrategy.CLICKABLE) {
            element = new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitWaitTimeout())
                    .until(ExpectedConditions.elementToBeClickable(by));
        } else if (waitStrategy == WaitStrategy.VISIBLE) {
            element = new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitWaitTimeout())
                    .until(ExpectedConditions.visibilityOfElementLocated(by));
        } else if (waitStrategy == WaitStrategy.NONE) {
            element = DriverManager.getDriver().findElement(by);
        }
        return element;
    }


    /**
     * Finds and returns a list of <code>WebElements</code> based on the <code>ExpectedCondition</code>, else throws an exception.
     *
     * @param by Mechanism used to locate elements within a document
     * @param waitStrategy <code>ExpectedCondition</code> to be checked before throwing an exception.<br>
     *                     Available strategies: WaitStrategy.PRESENCE, WaitStrategy.VISIBLE, WaitStrategy.NONE
     * @return List of WebElements
     * @see FrameworkConstants
     * @see DriverManager#getDriver()
     */
    public static List<WebElement> performExplicitWaitMultiple(By by, WaitStrategy waitStrategy) {
        List<WebElement> elements = null;
        if (waitStrategy == WaitStrategy.PRESENCE) {
            elements = new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitWaitTimeout())
                    .until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        }  else if (waitStrategy == WaitStrategy.VISIBLE) {
            elements = new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitWaitTimeout())
                    .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
        } else if (waitStrategy == WaitStrategy.NONE) {
            elements = DriverManager.getDriver().findElements(by);

        }
        return elements;
    }

}
