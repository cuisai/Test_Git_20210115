package com.sai.search;

/**
 * @Author sai
 * @Description 顺序查找（线性查找）
 * @Time 2020-07-22 14:48
 */
public class Sequence {
    public static void main(String[] args) {
        int[] arr = {1,5,3,8,-1,12};
        int result = sequenceFind(arr,-1);
        if(result == -1){
            System.out.println("没有找到该数！");
        }else {
            System.out.println("找到了，下标为："+result);
        }
    }

    public static int sequenceFind(int[] arr,int value){
        for(int i=0;i<arr.length;i++){
            if(arr[i] == value){
                return i;
            }
        }
        return -1;
    }
}
