package com.study.annotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author sai
 * @Description 通过反射动态获取对象
 * @Time 2020-12-29 16:51
 */
public class Test04 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
        Class c1 = Class.forName("com.study.annotation.User");

        //无参构造
        User user = (User) c1.newInstance();
        //System.out.println(user);

        //有参构造
        /*Constructor constructor = c1.getDeclaredConstructor(int.class, String.class, int.class);
        User sai = (User) constructor.newInstance(1, "sai", 18);
        System.out.println(sai);*/

        Method getName = c1.getDeclaredMethod("getName",null);
        getName.setAccessible(true);
        String name = (String) getName.invoke(user, null);
        System.out.println(name);


    }
}
