package com.sai.stack;

import java.util.Scanner;

/**
 * @Author sai
 * @Description 用数组模拟栈的测试类
 * @Time 2020-07-06 17:35
 */
public class ArrayStack_Test {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(3);
        Scanner sc = new Scanner(System.in);
        Boolean falg = true;
        String key = "";

        System.out.println("欢迎来到本系统！");
        while (falg){

            System.out.println("请输入您的选择：");
            System.out.println("入栈请输入 ： push");
            System.out.println("出栈请输入 ： pop");
            System.out.println("显示栈请输入：show");
            System.out.println("退出请输入 ： exit");

            key = sc.next();
            switch (key){
                case "show" :
                    stack.show();
                    break;

                case "push" :
                    System.out.println("请输入要添加的数值！");
                    int value = sc.nextInt();
                    stack.push(value);
                    break;

                case "pop" :
                    stack.pop();
                    break;

                case "exit" :
                    falg = false;
                    sc.close();
                    break;

            }

        }
        System.out.println("已退出本系统！");
    }
}
