package com.sai.Test;

/**
 * @Author sai
 * @Description intValue() / Integer.ValueOf( )
 * @Time 2020-10-27 10:54
 */
public class Demo3 {
    public static void main(String[] args) {
        String a = "2";
        String b = "3.6";

        Integer intValue = Integer.valueOf(a);
        int i = Integer.valueOf(a).intValue();

        System.out.println("Integer.ValueOf（）: " + intValue);
        System.out.println("intValue（） : " + i);
    }
}
