package com.study.annotation;

import java.lang.annotation.*;
import java.lang.reflect.Field;

/**
 * @Author sai
 * @Description 通过反射获取注解
 * @Time 2020-12-30 10:10
 */
@Sai("通过反射获取注解")
public class Test05 {
    @Sai2(type = "int", name = "db_id", length = 8)
    private int id;
    @Sai2(type = "string", name = "db_name", length = 8)
    private String name;
    @Sai2(type = "int", name = "db_length", length = 8)
    private int age;

    public Test05() {
    }

    public Test05(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Test05{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Sai{
    String value();
}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface Sai2{
    String name();
    String type();
    int length();
}

class test{
    public static void main(String[] args) throws Exception {
        Class c = Class.forName("com.study.annotation.Test05");

        Annotation[] annotations = c.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }

        Sai annotation = (Sai)c.getAnnotation(Sai.class);
        String value = annotation.value();
        System.out.println(value);

        Field name = c.getDeclaredField("name");
        Sai2 annotation1 = name.getAnnotation(Sai2.class);
        System.out.println(annotation1.type());
        System.out.println(annotation1.name());
        System.out.println(annotation1.length());

    }
}
