package com.sai.stack;

/**
 * @Author sai
 * @Description Calculator的测试类
 * @Time 2020-07-07 18:04
 */
public class Calculator_Test {
    public static void main(String[] args) {
        String expression = "2+5*2-10/5";

        Calculator calculator = new Calculator();
        calculator.expression(expression);
    }
}
