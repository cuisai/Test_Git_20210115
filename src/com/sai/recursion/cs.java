package com.sai.recursion;

/**
 * @Author sai
 * @Description 测试
 * @Time 2020-07-09 17:27
 */
public class cs {
    public static void main(String[] args) {
//        int s = factorial(3);
//        System.out.println("s = "+s);

        test(3);
    }


    public static void test(int n) {
        if (n > 2) {
            test(n - 1);
        }
        System.out.println("n=" + n);
    }

    //阶乘
    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            return factorial(n - 1) * n;  //1.
     }}

}
