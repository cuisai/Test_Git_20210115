package com.study.hashMap;

import javax.xml.soap.Node;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author sai
 * @Description 测试hashmap
 * @Time 2021-01-04 14:10
 */
public class HashMap_test {
    public static void main(String[] args) {
        /*Map<String, Object> map = new HashMap<String, Object>();

        map.put("001", "第一个");
        System.out.println(map.get("001").hashCode());

        Node node;*/

        /**正则表达式*/
        String content = "/";

        String pattern = "[^/*~`!@#$%^&*()_+=-\\{\\}\\[\\].\\,\\|\\;\\']{1,50}";

        boolean isMatch = Pattern.matches(pattern, content);
        System.out.println(isMatch);

    }
}
