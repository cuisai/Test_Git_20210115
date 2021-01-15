package com.sai.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @Author sai
 * @Description 快速排序
 * @Time 2020-07-17 16:35
 */
public class Quick {
    public static void main(String[] args) {
        int[] arr = {8,1,9,7,2,3,5,4,6,0};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));

        /*
        //测试算法速度
        int[] arr1 = new int[80000];
        for(int i=0;i<80000;i++){
            arr1[i] = (int)(Math.random()*80000);
        }

        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s1 = simpleDateFormat.format(date1);
        System.out.println(s1);

        quickSort(arr1,0,arr1.length-1);

        Date date2 = new Date();
        String s2 = simpleDateFormat.format(date2);
        System.out.println(s2);

         */
    }

    public static void quickSort(int[] arr,int left,int right){

        int l = left;
        int r = right;
        int p = arr[(left+right)/2];

        int temp = 0;
        while (l < r){
            while (arr[l] < p){  //遍历到左侧比中间值大的数
                l += 1;
            }
            while (arr[r] > p){  //遍历到右侧比中间值小的数
                r -= 1;
            }

            if(l >= r){  //
                break;
            }

            //交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            if(p == arr[l]){  //表示：左侧的全部是比中间值小的了，交换的话无意义，就让右侧的前移一位
                r -= 1;
            }
            if(p == arr[r]){  //表示：右侧的全部是比中间值大的了，交换的话无意义，就让左侧的后移一位
                l += 1;
            }

        }

        //退出循环
        if(r == l){
            l += 1;
            r -= 1;
        }

        //向左递归
        if(left < r){
            quickSort(arr, left,r);
        }

        //向右递归
        if(right > l){
            quickSort(arr, l, right);
        }
    }
}
