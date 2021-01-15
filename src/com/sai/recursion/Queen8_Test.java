package com.sai.recursion;

/**
 * @Author sai
 * @Description 八皇后问题的测试类
 * @Time 2020-07-13 16:39
 */
public class Queen8_Test {
    public static void main(String[] args) {
        Queen8 queen = new Queen8();

        //依次摆放八皇后
        queen.push(0);

        System.out.println("一共有" + queen.getCount() + "中方法");
    }
}
