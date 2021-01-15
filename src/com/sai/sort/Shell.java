package com.sai.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @Author sai
 * @Description 希尔排序
 * @Time 2020-07-16 15:11
 */
public class Shell {
    public static void main(String[] args) {

        int[] arr = {8,9,1,7,2,3,5,4,6,0};
        shellSort1(arr);  //交换法
        //shellSort2(arr);  //移位法

        /*
        int[] arr1 = new int[80000];
        for(int i=0;i<80000;i++){
            arr1[i] = (int)(Math.random()*80000);
        }

        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s1 = simpleDateFormat.format(date1);
        System.out.println(s1);

        //shellSort1(arr1);  //交换法
        //shellSort2(arr1);  //移位法

        Date date2 = new Date();
        String s2 = simpleDateFormat.format(date2);
        System.out.println(s2);

         */
    }

    //移位法
    public static void shellSort2(int[] arr) {

        int count = 0;
        for (int step = arr.length / 2; step > 0; step /= 2) {  //进行除二分组

            for (int i = step; i < arr.length; i++) {  //遍历每组，并进行移位

                int j = i;
                int temp = arr[i];
                if (arr[j] < arr[j - step]) {  //如果同一组中后面的数小于前面的数，进行后移，最后插入
                    while (j - step >= 0 && temp < arr[j - step]) {
                        arr[j] = arr[j - step];
                        j -= step;
                    }
                    arr[j] = temp;  //插入到正确位置
                }

            }
            //System.out.println("第" + (++count) + "次排序：" + Arrays.toString(arr));
        }
    }


    //交换法
    public static void shellSort1(int[] arr) {

        int count = 0;
        for (int step = arr.length / 2; step > 0; step /= 2) {  //进行除二分组
            for (int i = step; i < arr.length; i++) {  //遍历每组，并进行交换

                for (int j = i - step; j >= 0; j -= step) {
                    if (arr[j + step] < arr[j]) {  //如果同一组中后面的数小于前面的数，进行交换
                        int temp = arr[j];
                        arr[j] = arr[j + step];
                        arr[j + step] = temp;
                    }
                }
            }
            //System.out.println("第"+(++count)+"次排序：" + Arrays.toString(arr));
        }

    }
}
