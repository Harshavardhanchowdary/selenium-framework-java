package org.hck.utils;

import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * DataProviderUtil class provide a mechanism to supply data to the test methods with the help of TestNg DataProvider.
 * @author Harshavardhan Kavuri
 * @version 1.0
 * @see ExcelUtil#getTestDetails(String) 
 * @see <a href="https://testng.org/doc/documentation-main.html#parameters-dataproviders">doc.testng::dataproviders</a>
 * @since 1.0
 */
public final class DataProviderUtil {

    private static List<Map<String, String>> list = new ArrayList<>();

    /**
     * singleton classes-prevent class instances being created in any place other than this very class.
     */
    private DataProviderUtil() {
    }

    /**
     * Supplies data to the test methods from the test data sheet.
     * @param m  A Method provides information about, and access to, a single method on a class or interface.
     *           The reflected method may be a class method or an instance method (including an abstract method).
     * @return  Object[] test data array.
     * @see <a href="https://testng.org/doc/documentation-main.html#parameters-dataproviders">doc.testng::dataproviders</a>
     */
    @DataProvider(parallel = true)
    public static Object[] getData(Method m) {
        String testName = m.getName();
        if (list.isEmpty()) {
            list = ExcelUtil.getTestDetails("TESTDATA");
        }
        return list.stream()
                .filter(test -> test.get("testname").equalsIgnoreCase(testName))
                .filter(test -> test.get("execute").equalsIgnoreCase("yes"))
                .toArray();

    }
}
