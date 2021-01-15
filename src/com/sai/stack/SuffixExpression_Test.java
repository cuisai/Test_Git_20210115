package com.sai.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author sai
 * @Description SuffixExpression的测试类
 * @Time 2020-07-08 11:21
 */
public class SuffixExpression_Test {
    public static void main(String[] args) {
        SuffixExpression suffixExpression = new SuffixExpression();



        //将中缀表达式转换ArrayList
        List<String> list = suffixExpression.getListString("1+((2+3)*4)-5");
        System.out.println(list);

        //将ArrayList类型的中缀表达式 转换为 ArrayList类型的后缀表达式
        List<String> ls = suffixExpression.getPostfixExpression(list);
        System.out.println(ls);

        //将集合遍历运算，得到结果
        int sum = suffixExpression.get(ls);
        System.out.println("运算结果为："+sum);


    }
}
