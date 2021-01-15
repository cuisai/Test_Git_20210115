package com.sai.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author sai
 * @Description Test_Lambda表达式 / 正则验证邮箱格式
 * @Time 2020-10-21 11:11
 */
public class Demo2 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("第一个");
        list.add("第二个");
        list.add("第三个");

        list.forEach(
                l->System.out.println(l.length() + l)
        );

        String email = "2451104995@163.com";
        String res = "^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.[a-zA-Z0-9]{2,6}$";
        boolean matches = email.matches(res);
        System.out.println("matches: " + matches);
    }
}
