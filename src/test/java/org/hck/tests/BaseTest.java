package org.hck.tests;

import org.hck.driver.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.Map;

/**
 * BaseTest class provides an implementation of actions to be performed before and after test methods. .
 *
 * @author Harshavardhan Kavuri
 * @version 1.0
 * @see Driver
 * @see <a href="https://testng.org/doc/documentation-main.html#annotations">docs.testNg:annotations</a>
 */
public class BaseTest {

    protected BaseTest() {
    }


    /**
     * Initializes the webdriver before every test.
     *
     * @param data Object[] passed by testNg if the dataprovider is used.
     *             In this case it is used to launch the browser based on type defined in test data along with each testcase.
     * @see org.hck.utils.DataProviderUtil
     * @see org.hck.driver.Driver
     */
    @SuppressWarnings("unchecked")
    @BeforeMethod
    public void setUp(Object[] data) {
        Map<String, String> map = (Map<String, String>) data[0];
        Driver.initDriver(map.get("browser"));
    }

    /**
     * Terminates the webdriver instance after every test.
     */
    @AfterMethod
    public void tearDown() {
        Driver.tearDown();
    }
}
