package com.sai.search;

/**
 * @Author sai
 * @Description 插值查找
 * @Time 2020-07-23 10:37
 */
public class InsertValue {
    public static void main(String[] args) {
        int[] arr = new int[100];
        for(int i = 0;i<100;i++){
            arr[i] = i+1;
        }
        int res = insertValueSearch(arr,0,arr.length-1,4);
        System.out.println("查找的值下标为：" + res);
    }

    /**
     * 插值查找
     * @param arr  数组
     * @param left  左边索引
     * @param right  右边索引
     * @param findVal  要查找的值
     * @return  找到返回下标索引，没有找到返回 -1
     */
    public static int insertValueSearch(int[] arr,int left,int right,int findVal){
        System.out.println("helloworld1");
        if(left > right || findVal > arr[right] || findVal < arr[left]){  //没有找到
            return -1;
        }

        //  插值查找的公式
        int mid = (right-left) * (findVal-arr[left]) / (arr[right]-arr[left]) ;
        int midVal = arr[mid];

        if(findVal < midVal){
            return insertValueSearch(arr, left, mid-1, findVal);  //向左递归，继续查找
        }else if(findVal > midVal){
            return insertValueSearch(arr, mid+1, right, findVal);  //向右递归，继续查找
        }else {
            return mid;  //找到，直接返回下标索引
        }

    }
}
