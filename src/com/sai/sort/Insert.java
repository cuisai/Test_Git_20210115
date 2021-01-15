package com.sai.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @Author sai
 * @Description 插入排序
 * @Time 2020-07-15 17:24
 */
public class Insert {
    public static void main(String[] args) {

        int[] arr = {6,1,3,7,-2};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));

        /*
        int[] arr = new int[80000];
        for(int i=0;i<80000;i++){
            arr[i] = (int)(Math.random()*80000);
        }

        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s1 = simpleDateFormat.format(date1);
        System.out.println(s1);

        insertSort(arr);  //执行插入排序

        Date date2 = new Date();
        String s2 = simpleDateFormat.format(date2);
        System.out.println(s2);
        */

    }

    //插入排序的方法
    public static void insertSort(int[] arr){

        int index = 0;  //待插入排序数值的前一个的下标
        int indexValue = 0;  //待插入排序的数值
        for (int i = 1;i<arr.length;i++){

            index = i-1;
            indexValue = arr[i];
            while (index >= 0 && indexValue < arr[index]){  //如果下标不小于0，待插入的值 < 前面的值
                arr[index+1] = arr[index];  //把前面的值移动到后面  {6,1,3,7,-2}  --->  {6,6,3,7,-2}
                index--;  //下标后移
            }
            arr[index+1] = indexValue;  //插入 {6,6,3,7,-2}  ---> {1,6,3,7,-2}
        }
    }
}
