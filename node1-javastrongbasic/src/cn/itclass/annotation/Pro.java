package cn.itclass.annotation;

import java.lang.annotation.*;

/**
 * 描述需要执行的类名和方法名
 */

@Target(ElementType.TYPE)
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface Pro {

    String className();
    String methodName();



}
