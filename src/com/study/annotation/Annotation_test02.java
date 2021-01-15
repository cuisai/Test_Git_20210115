package com.study.annotation;

/**
 * @Author sai
 * @Description 反射
 * @Time 2020-12-28 15:40
 */
public class Annotation_test02 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class c1 = Class.forName("com.study.annotation.user");
        Class c2 = User.class;
        Class c3 = new User().getClass();
        System.out.println(c1);
        System.out.println(c1.hashCode());
        System.out.println(c2.hashCode());
        System.out.println(c3.hashCode());

        System.out.println(c1.toString());
        System.out.println(c1.getSuperclass());

    }
}

class User{
    private int id;
    private String name;
    private int age;

    public User() {

    }
    public User(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "user{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}