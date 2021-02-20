package org.hck.annotations;


import org.hck.enums.TestCategoryType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Framework Annotation is user built annotation which is annotated on top of test methods to log the author details and
 * category details to the extent report.<p>
 *
 * Runtime retention value indicate that this annotation will be available at run time for reflection operations.
 * @author Harshavardhan Kavuri
 * @version 1.0
 * @see TestCategoryType
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface FrameworkAnnotation {

    /**
     * Store the authors who created the tests in String[]
     * Mandatory to enter at least one value
     * @return list of authors.
     */
    String[] author() default "";

    /**
     * Stores the category in form of Enum Array. Include the possible values in {@link org.hck.enums.TestCategoryType}
     * @return list of possible values in {@link org.hck.enums.TestCategoryType}
     */
    TestCategoryType[] category();


}
