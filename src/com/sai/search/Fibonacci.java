package com.sai.search;

import java.util.Arrays;

/**
 * @Author sai
 * @Description 斐波那契查找
 * @Time 2020-07-24 11:29
 */
public class Fibonacci {
    public static void main(String[] args) {
        int[] arr = {1,8,10,89,1000,1234};
        int res = fibonacciSearch(arr,1234);
        System.out.println("对应的下标为：" + res);
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

    /**
     *
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

}
