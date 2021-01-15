package com.sai.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @Author sai
 * @Description 选择排序
 * @Time 2020-07-15 11:50
 */
public class Select {
    public static void main(String[] args) {

        int[] arr = {5, 1, 2, 9, -1};
        SelectSort(arr);
        System.out.println(Arrays.toString(arr));

        //测试算法速度
        /*int[] arr = new int[80000];
        for(int i = 0;i<80000;i++){
            arr[i] = (int)(Math.random()*80000);
        }

        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-dd-mm HH:mm:ss");
        String s1 = simpleDateFormat.format(date1);
        System.out.println("运行前的时间："+s1);

        SelectSort(arr);

        Date date2 = new Date();
        String s2 = simpleDateFormat.format(date2);
        System.out.println("运行后的时间："+s2);*/

    }

    //选择排序的方法
    public static void SelectSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {

            int minIndex = i;  //预定最小值的下标
            int min = arr[i];  //预定最小值
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {  //如果预定最小值 > 遍历的值， 说明预定的最小值，并不是最小
                    minIndex = j;  //重置minIndex
                    min = arr[j];  //重置min
                }
            }
            if (minIndex != i) {  //如果最小值的下标发生改变，就把预定的最小值 和 真正的最小值交换位置
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
    }
}
