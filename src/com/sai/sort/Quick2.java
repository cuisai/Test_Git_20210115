package com.sai.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @Author sai
 * @Description 快速排序
 * @Time 2020-07-17 16:35
 */
public class Quick2 {
    public static void main(String[] args) {
        int[] arr = {8,1,9,7,2,3,5,4,6,0};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));

    }

    public static void quickSort(int[] arr,int left,int right) {

        int l = left;
        int r = right;
        int p = arr[(left+right)/2];
        int temp = 0;
        while (l < r) {
            while (arr[l] < p){
                l++;
            }
            while (arr[r] > p){
                r--;
            }
            if(l >=  r){
                break;
            }
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            if(l == r){
                ++l;
                --r;
            }
            if(arr[l] == p){
                r--;
            }
            if(arr[r] == p){
                l++;
            }
        }
        if(left < l){
            quickSort(arr, l, right);
        }
        if(right > r){
            quickSort(arr, left, r);
        }
    }
}
