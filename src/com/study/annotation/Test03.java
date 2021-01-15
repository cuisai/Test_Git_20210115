package com.study.annotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Author sai
 * @Description 通过反射获取类的全部
 * @Time 2020-12-29 14:04
 */
public class Test03 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class c1 = Class.forName("com.study.annotation.User");

        //获取包名+类名
        String name = c1.getName();
        System.out.println(name);
        //获取类名
        name = c1.getSimpleName();
        System.out.println(name);
        System.out.println("=========================");

        //获取public类型的属性
        Field[] fields = c1.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        //获取该类的全部属性
        fields = c1.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println("=========================");

        //获取本类和父类的所有的public方法
        Method[] methods = c1.getMethods();
        System.out.println("获取本类和父类的所有的public方法");
        for (Method method : methods) {
            System.out.println(method);
        }
        //获取本类全部的方法
        System.out.println("获取本类全部的方法");
        methods = c1.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
        System.out.println("=========================");

        //获取构造器
        Constructor[] constructors = c1.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }
        //获取全部构造器
        constructors = c1.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }
        System.out.println("=========================");

        //获取父类
        Class superclass = c1.getSuperclass();
        System.out.println(superclass);

    }
}
