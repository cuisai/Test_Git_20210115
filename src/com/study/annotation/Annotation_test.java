package com.study.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author sai
 * @Description 自定义注解
 * @Time 2020-12-28 15:36
 */
@MyAnnotation()
class Annotation_test01 {
    @MyAnnotation()
    public static void test01(){
        System.out.println("MyAnnotation");
    }

    public static void main(String[] args) {
        test01();
    }
}

//自定义注解
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation{

    String value() default "";
    String name() default "";
    int age() default 0;
    int id() default -1;
    String[] schools() default {"清华大学", "北京大学"};
}
