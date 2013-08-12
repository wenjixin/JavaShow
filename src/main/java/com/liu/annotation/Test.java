package com.liu.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Indicate that the annotated method is test method.
 * Use only on parameterless method
 * @author ÁõÍ©Î°
 * @date 2013Äê8ÔÂ12ÈÕ
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Test {

}
