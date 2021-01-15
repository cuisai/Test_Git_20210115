package com.sai.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @Author sai
 * @Description 冒泡排序
 * @Time 2020-07-14 15:29
 */
public class Bubble {
    public static void main(String[] args) {

        /*int[] arr = {5, 1, 2, 9, -1};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));*/



        //测试时间复杂度

        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s1 = simpleDateFormat.format(date1);
        System.out.println("排序前的时间："+s1);

        int[] arr = new int[80000];
        for(int i = 0;i<80000;i++){
            arr[i] = (int)(Math.random()*80000);
        }
        //int[] arr = {5,1,2,9,-1};
        bubbleSort(arr);
        //System.out.println(Arrays.toString(arr));

        Date date2 = new Date();
        String s2 = simpleDateFormat.format(date2);
        System.out.println("排序后的时间："+s2);



    }


    //進行冒泡排序的方法
    public static void bubbleSort(int[] arr) {

        int temp = 0;  //定义一个变量，用于数据交换位置
        Boolean falg = false;  //用于判断是否排序完成
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {

                if (arr[j] > arr[j + 1]) {  //如果前面的数 大于 后面的数  就进行交换位置
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    falg = true;  //表示还未排序完成
                }
            }
            if (!falg) {  //排序完成，退出循环
                break;
            } else {  //排序未完成，重置falg，用于以后的判断
                falg = false;
            }
        }

    }
}
