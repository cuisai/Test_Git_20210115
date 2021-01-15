package com.sai.sort;

import java.util.Arrays;

/**
 * @Author sai
 * @Description 基数排序（桶排序）
 * @Time 2020-07-21 18:15
 */
public class Radix {
    public static void main(String[] args) {
        int arr[] = { 53, 3, 542, 748, 14, 214};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void radixSort(int[] arr){

        //1.获取数组中最大值的位数
        int max = arr[0];
        for(int i = 0;i<arr.length;i++){
            if(max < arr[i]){
                max = arr[i];
            }
        }
        int maxLength = (max+"").length();
        //System.out.println("最大值的位数是："+maxLength);

        //2.创建好桶,以及记录每个桶中有效数值的一维数组
        int[][] bucket = new int[10][arr.length];  //二维数组：十个桶
        int[] bucketCount = new int[10];  //记录每个桶的有效数值

        //3.按照位数排到桶中，并再放入到原来的数组中
        for(int i = 0,n = 1;i<maxLength;i++,n *= 10){  //循环次数按照最大值的位数进行循环

            for (int j = 0;j<arr.length;j++) {
                int s = arr[j] / n % 10;  //获取位数  1.个位  2.十位  3.百位...
                bucket[s][bucketCount[s]++] = arr[j];  //将遍历的数放入到桶中
            }

            int index = 0;
            for(int k = 0;k<bucketCount.length;k++){
                if(bucketCount[k] != 0){
                    for (int l = 0;l<bucketCount[k];l++) {
                        arr[index++] = bucket[k][l];  //将桶中的数放回到原来的数组中
                    }
                }
                bucketCount[k] = 0;  //将桶中的数放回到原来的数组中后，把记录的有效数值清空，不然会影响下次的放入
            }
        }

    }
}
