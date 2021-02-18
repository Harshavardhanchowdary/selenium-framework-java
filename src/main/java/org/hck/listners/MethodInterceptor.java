package org.hck.listners;

import org.hck.utils.ExcelUtil;
import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * This class is used to alter the list of test methods that TestNG is about to run.
 * An instance of this class will be invoked right before TestNG starts invoking test methods.
 * @author Harshavardhan Kavuri
 * @version 1.0
 * @see IMethodInterceptor
 * @see <a href="https://testng.org/doc/documentation-main.html#methodinterceptors">doc.testng::methodinterceptors</a>
 * @since 1.0
 */
public class MethodInterceptor implements IMethodInterceptor {
    /**
     * Returns a list of test methods to run, based on the execution status for each test defined in RUNMANGER data sheet..
     * @param methods List of test methods to intercept.
     * @param iTestContext This class defines a test context which contains all the information for a given test run. An instance of this context is passed to the test listeners so they can query information about their environment.
     * @return list of test methods to be executed.
     * @see "org.hck.test.resources"
     * @see ExcelUtil#getTestDetails(String) 
     */
    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext iTestContext) {

        List<IMethodInstance> result = new ArrayList<>();
        List<Map<String, String>> list = ExcelUtil.getTestDetails("RUNMANAGER");

        for (IMethodInstance method : methods) {
            for (Map<String, String> testData : list) {
                if (testData.get("execute").equalsIgnoreCase("yes") &&
                        method.getMethod().getMethodName().equalsIgnoreCase(testData.get("testname"))) {
                    method.getMethod().setInvocationCount((int)Double.parseDouble(testData.get("count")));
                    method.getMethod().setPriority((int)Double.parseDouble(testData.get("priority")));
                    method.getMethod().setDescription(testData.get("testdescription"));
                    result.add(method);
                }
            }
        }
        return result;
    }


}
