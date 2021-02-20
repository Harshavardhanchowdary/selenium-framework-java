package org.hck.listners;

import org.hck.enums.ConfigProperties;
import org.hck.utils.PropertyFileUtil;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * RetryFailedTests class automatically invokes the retry analyzer to determine if TestNG can retry a test
 *  case again in an attempt to see if the test that just fails now passes.
 * @author Harshavardhan Kavuri
 * @version 1.0
 * @see PropertyFileUtil#get(ConfigProperties)
 * @see <a href="https://testng.org/doc/documentation-main.html#rerunning">doc.testng::retryAnalyzer</a>
 * @since 1.0
 */
public class RetryFailedTests implements IRetryAnalyzer {

    private int count = 0;

    /**
     * Automatically retries a test for a set number of times before failing a test if <code>ConfigProperties.RETRYFAILEDTESTS</code> is set to "yes".
     * @param result Result of a test.
     * @return <code>true</code> if retry count is less than the specified value, else <code>false</code>.
     * @see ConfigProperties#RETRYFAILEDTESTS
     * @see ConfigProperties#FAILEDTESTRETRYCOUNT
     * @see PropertyFileUtil#get(ConfigProperties)
     */
    @Override
    public boolean retry(ITestResult result) {
        boolean value =false;
        if(PropertyFileUtil.get(ConfigProperties.RETRYFAILEDTESTS).equalsIgnoreCase("yes")) {
            value = count < Integer.parseInt(PropertyFileUtil.get(ConfigProperties.RETRYFAILEDTESTS));
            count++;
        }
        return value;
    }
}
