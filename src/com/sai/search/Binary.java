package com.sai.search;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author sai
 * @Description 二分查找（折半查找）
 * @Time 2020-07-22 15:27
 */
public class Binary {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9,9};
        int res = binarySearch(arr, 0, arr.length - 1, 9);
        if (res == -1) {
            System.out.println("没有找到目标值！");
        } else {
            System.out.println("找到目标值 = " + res);
        }

        List<Integer> res2 = binarySearch2(arr, 0, arr.length - 1, 9);
        System.out.println(res2);

    }

    /**
     * 二分查找
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
     * 二分查找 可查找多个相同的值
     * @param arr  数组
     * @param left  左侧下标
     * @param right  右侧下标
     * @param findVal  待查找的值
     * @return  包含数值下标的集合
     */
    public static List<Integer> binarySearch2(int[] arr, int left, int right, int findVal) {

        if (left > right) {  //没有找到,直接返回
            return new ArrayList<Integer>();
        }

        int mid = (left + right) / 2;  //中间基准值下标
        int midVal = arr[mid];  //中间基准值

        if (findVal < midVal) {
            return binarySearch2(arr, left, mid - 1, findVal);  //向左递归，继续查找
        } else if (findVal > midVal) {
            return binarySearch2(arr, mid + 1, right, findVal);   //向右递归，继续查找
        } else {
            List<Integer> resIndexlist = new ArrayList<Integer>();

            //向mid 索引值的左边扫描，将所有满足 1000， 的元素的下标，加入到集合ArrayList
            int temp = mid - 1;
            while(true) {
                if (temp < 0 || arr[temp] != findVal) {//退出
                    break;
                }
                //否则，就temp 放入到 resIndexlist
                resIndexlist.add(temp);
                temp -= 1; //temp左移
            }
            resIndexlist.add(mid);  //

            //向mid 索引值的右边扫描，将所有满足 1000， 的元素的下标，加入到集合ArrayList
            temp = mid + 1;
            while(true) {
                if (temp > arr.length - 1 || arr[temp] != findVal) {//退出
                    break;
                }
                //否则，就temp 放入到 resIndexlist
                resIndexlist.add(temp);
                temp += 1; //temp右移
            }

            return resIndexlist;
        }

    }

}
