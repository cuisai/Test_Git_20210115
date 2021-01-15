package com.sai.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author sai
 * @Description 集合转数组
 * @Time 2020-11-26 15:48
 */
public class Demo6 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(2);
        list.add("guan");
        list.add("bao");
        String[] array = list.toArray(new String[0]);

        String[] newArray = {"1","2"};
        List<String> strings = Arrays.asList(newArray);
        System.out.println(strings.toString());

    }
}
