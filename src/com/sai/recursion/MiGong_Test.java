package com.sai.recursion;

/**
 * @Author sai
 * @Description 迷宫回溯问题的测试类
 * @Time 2020-07-10 14:47
 */
public class MiGong_Test {
    public static void main(String[] args) {
        MiGong mg = new MiGong();

        //创建一个二维数组
        int[][] arr = new int[8][7];

        //创建墙壁
        mg.createWall(arr);

        //遍历数组
        System.out.println("原始的迷宫：");
        mg.getArr(arr);

        //出迷宫
        mg.getLabyrinthMethod(arr,1,1);

        //遍历数组
        System.out.println("运行后的迷宫：");
        mg.getArr(arr);

    }
}
