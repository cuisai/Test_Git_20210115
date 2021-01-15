package com.sai.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @Author sai
 * @Description 归并排序（分治）
 * @Time 2020-07-20 15:24
 */
public class Merget {
    public static void main(String[] args) {
        int arr[] = {8,4,5,7,1,3,6,2};
        int[] temp = new int[arr.length];
        merget(arr,0,arr.length-1,temp);
        System.out.println(Arrays.toString(arr));

        /*
        //测试算法速度
        int[] arr1 = new int[80000];
        for (int i=0;i<80000;i++){
            arr1[i] = (int)(Math.random()*80000);
        }

        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s1 = simpleDateFormat.format(date1);
        System.out.println("排序前："+s1);

        int[] temp = new int[arr1.length];
        merget(arr1,0,arr1.length-1,temp);

        Date date2 = new Date();
        String s2 = simpleDateFormat.format(date2);
        System.out.println("排序后："+s2);

         */
    }

    /**
     * @Author 分+和
     * @param arr  带排序的数组
     * @param left  最左边的索引
     * @param right  最右边的索引
     * @param temp  用来拷贝的临时数组
     */
    public static void merget(int[] arr,int left,int right,int[] temp){
        if(left<right){
            //中间索引
            int mid = (left+right)/2;

            //向左拆分
            merget(arr, left, mid, temp);
            //向右拆分
            merget(arr, mid+1, right, temp);
            //合并
            mergetSort(arr,left,right,mid,temp);
        }
    }

    /**
     * @Author 合并的方法
     * @param arr  要合并的数组
     * @param left  最左边的索引
     * @param right  最右边的索引
     * @param mid  中间值
     * @param temp  用来拷贝的临时数组
     */
    public static void mergetSort(int[] arr,int left,int right,int mid,int[] temp){

        int i = left;
        int j = mid + 1;
        int t = 0;

        //1.将数组中的元素按照从大到小的顺序排入到temp临时数组中，直到一侧完全排入
        while (i<=mid  &&  j<=right){
            if(arr[i] <= arr[j]){
                temp[t] = arr[i];
                t++;
                i++;
            }else {
                temp[t] = arr[j];
                t++;
                j++;
            }
        }

        //2.将剩下一侧依次排入temp中
        while (i<=mid){
            temp[t] = arr[i];
            t++;
            i++;
        }
        while (j<=right){
            temp[t] = arr[j];
            t++;
            j++;
        }

        //3.将排好序的temp（临时数组）拷贝到arr数组中
        t = 0;
        int tempLeft = left;
        while (tempLeft <= right){
            arr[tempLeft] = temp[t];
            t++;
            tempLeft++;
        }

    }
}
