package com.sai.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;

/**
 * @Author sai
 * @Description 基数排序（桶排序）
 * @Time 2020-07-21 18:15
 */
public class Radix2 {
    public static void main(String[] args) {
        int arr[] = {53, 3, 542, 748, 14, 214};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));


        /*
        //测试算法速度
        int[] arr1 = new int[8000000];
        for(int i= 0;i<8000000;i++){
            arr1[i] = (int)(Math.random()*80000);
        }

        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s1 = simpleDateFormat.format(date1);
        System.out.println("排序前："+s1);

        radixSort(arr1);  //调用基数排序

        Date date2 = new Date();
        String s2 = simpleDateFormat.format(date2);
        System.out.println("排序前："+s2);

         */

    }

    public static void radixSort(int[] arr) {

        //1.找到最大值的位数
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        int maxLength = (max + "").length();
        //System.out.println("最大值的位数为："+maxLength);

        //2.创建好桶，以及记录桶的有效值的一维数组
        int[][] bucket = new int[10][arr.length];
        int[] bucketCount = new int[10];

        //3.  ①按照位数值的大小，放入到对应的桶中  ②将放好的值取出并放入到原来的数组中
        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {  //按照最大值的位数进行循环
            for (int j = 0; j < arr.length; j++) {  //遍历待循环的数组

                int s = arr[j] / n % 10;  //获取位数  1次.个位  2次.十位  3次.百位...
                bucket[s][bucketCount[s]++] = arr[j];  //把数值放入想对应的桶中

            }

            int index = 0;
            for (int k = 0; k < bucketCount.length; k++) {
                if (bucketCount[k] != 0) {  //如果记录的不为空，证明对应的桶中有数据
                    for (int l = 0; l < bucketCount[k]; l++) {
                        arr[index++] = bucket[k][l];  //将放好的值取出并放入到原来的数组中
                    }
                }
                bucketCount[k] = 0;  //将桶中的数放回到原来的数组中后，把记录的有效数值清空，不然会影响下次的放入

            }
        }

    }
}
