package com.sai.recursion;

/**
 * @Author sai
 * @Description 八皇后问题
 * @Time 2020-07-13 16:39
 */
public class Queen8 {

    //创建一个变量，表示共有多少个皇后
    int max = 8;
    //创建一维数组，存放皇后放置位置的结果    {0,4,7,5,2,6,1,3}
    int[] arr = new int[max];
    //查看一个都多少种方法
    static int count = 0;

    public static int getCount() {
        return count;
    }

    //依次放入皇后
    //每一次递归时，进入到push中都有  for(int i = 0; i < max; i++)，因此会有回溯
    public void push(int n){

        if(n == max){  //n==8,表示八个皇后摆放完毕了
            print();
            return;
        }

        //依次放入皇后，并判断是否冲突
        for (int i = 0;i < max;i++){
               arr[n] = i;  //摆放

               if(isConflict(n)){  //判断是否冲突
                   push(n+1);  //不冲突，接着放n+1个皇后,即开始递归
               }

        }
    }

    //判断是否冲突
    public Boolean isConflict(int n){

        for (int i = 0;i < n;i++) {

            //判断是否在同一列 和 判断是否在同一斜线上
            if (arr[n] == arr[i] || Math.abs(n-i) == Math.abs(arr[n]-arr[i])){
                return false;
            }
        }
        return true;
    }

    //遍历数组，输出摆放好的位置
    public void print(){

        for (int i = 0;i<arr.length;i++) {
            System.out.print(arr[i] + " ");
        }
        count++;
        System.out.println();
    }

}
