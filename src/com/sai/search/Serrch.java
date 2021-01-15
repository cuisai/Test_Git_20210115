package com.sai.search;

import java.util.Arrays;
import java.util.Collections;

/**
 * @Author sai
 * @Description 常见的四种查找算法
 * @Time 2020-07-23 15:57
 */
public class Serrch {
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        int val = 9 ;
        int res1 = sequenceFind(arr,val);  //顺序查找（线性查找）
        int res2 = binarySearch(arr, 0, arr.length - 1, val);  //二分查找
        int res3 = insertValueSearch(arr,0,arr.length-1,val);  //插值查找
        int res4 = fibonacciSearch(arr,val);  //斐波那契查找

        System.out.println("顺序查找："+res1);
        System.out.println("二分查找："+res2);
        System.out.println("插值查找："+res3);
        System.out.println("斐波那契："+res4);

    }

    /**
     * 1.顺序查找（线性查找）
     * @param arr  数组
     * @param value  要查找的数
     * @return
     */
    public static int sequenceFind(int[] arr,int value){
        for(int i=0;i<arr.length;i++){
            if(arr[i] == value){
                return i;
            }
        }
        return -1;
    }

    /**
     * 2.二分查找
     * @param arr  数组
     * @param left  左侧下标
     * @param right  右侧下标
     * @param findVal  待查找的值
     * @return  找到的值的下标
     */
    public static int binarySearch(int[] arr, int left, int right, int findVal) {

        if (left > right) {  //没有找到,直接返回
            return -1;
        }

        int mid = (left + right) / 2;  //中间基准值下标
        int midVal = arr[mid];  //中间基准值

        if (findVal < midVal) {
            return binarySearch(arr, left, mid - 1, findVal);  //向左递归，继续查找
        } else if (findVal > midVal) {
            return binarySearch(arr, mid + 1, right, findVal);   //向右递归，继续查找
        } else {
            return mid;   //找到了，返回下标
        }

    }

    /**
     * 3.插值查找
     * @param arr  数组
     * @param left  左边索引
     * @param right  右边索引
     * @param findVal  要查找的值
     * @return  找到返回下标索引，没有找到返回 -1
     */
    public static int insertValueSearch(int[] arr,int left,int right,int findVal){

        if(left > right || findVal > arr[right] || findVal < arr[left]){  //没有找到
            return -1;
        }

        //  插值查找的公式
        int mid = left + (right-left) * (findVal-arr[left]) / (arr[right]-arr[left]) ;
        int midVal = arr[mid];

        if(findVal < midVal){
            return insertValueSearch(arr, left, mid-1, findVal);  //向左递归，继续查找
        }else if(findVal > midVal){
            return insertValueSearch(arr, mid+1, right, findVal);  //向右递归，继续查找
        }else {
            return mid;  //找到，直接返回下标索引
        }

    }

    /**
     *4.斐波那契查找
     * @param arr  数组
     * @param key  要查找的值
     * @return  找到，返回下标  未找到，返回-1
     */
    public static int fibonacciSearch(int[] arr,int key){

        int low = 0;
        int high = arr.length-1;
        int k = 0;  //表示斐波那契分割数值的下标
        int mid = 0;  //存放mid值
        int f[] = f();  //获取斐波那契数组

        while (high > f[k]-1){  //获取到斐波那契分割数值的下标
            k++;
        }

        int[] temp = Arrays.copyOf(arr,f[k]);  //扩容并拷贝数组到一个临时数组
        for (int i=high+1;i<temp.length;i++){  //填充为0的部分
            temp[i] = arr[high];
        }

        //查找key
        while (low <= high){
            mid = low + f[k-1] - 1;
            if(key < temp[mid]){  //向左查找
                high = mid - 1;
                k--;
            }else if(key > temp[mid]){  //向右查找
                low = mid + 1;
                k -= 2;
            }else {  //找到了
                if(mid <= high){
                    return mid;
                }else {
                    return high;
                }
            }
        }

        return -1;  //没有找到
    }

    //获取斐波那契数组
    public static int[] f(){
        int[] f = new int[20];
        f[0] = 1;
        f[1] = 1;
        for(int i=2;i<f.length;i++){
            f[i] = f[i-1] + f[i-2];
        }
        return f;
    }
}
