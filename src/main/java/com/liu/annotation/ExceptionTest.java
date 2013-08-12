package com.liu.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Indicate that the annotated method is test method that must throw the
 * designed exception to sucess.
 * @author ��ͩΰ
 * @date 2013��8��12��
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ExceptionTest {
	/**
	 * The exception array that method should be throw
	 */
	Class<? extends Exception>[] value() default{};
}
