package com.sai.recursion;

/**
 * @Author sai
 * @Description 迷宫回溯问题
 * @Time 2020-07-10 10:46
 */
public class MiGong {

    /**
     * @deprecated 出迷宫操作 :  0.未走的路  1.墙壁  2.已通过的路  3.无法通过的路（死路）
     * @param arr  二维数组
     * @param i  开始时的坐标
     * @param j  开始时的坐标
     */
    public Boolean getLabyrinthMethod(int[][] arr,int i,int j){

        if(arr[6][5] == 2){  //找到出口

            return true;
        }else {
            if(arr[i][j] == 0){  //如果该点还没有走过

                arr[i][j] = 2;
                if(getLabyrinthMethod(arr,i+1,j)){  //向下走
                    return true;
                }else if(getLabyrinthMethod(arr,i,j+1)){  //向右走
                    return true;
                }else if(getLabyrinthMethod(arr,i-1,j)){  //向上走
                    return true;
                }else if(getLabyrinthMethod(arr,i,j-1)){  //向左走
                    return true;
                }else {  //上下左右都不能走（死路）
                    arr[i][j] = 3;
                    return false;
                }
            }else {  //上下左右都不能走，或者都走过了
                return false;
            }
        }

    }

    //创建墙壁，障碍  将外围设成1，表示墙壁
    public void createWall(int[][] arr){

        for(int i=0;i<7;i++){
            arr[0][i] = 1;
            arr[7][i] = 1;
        }
        for (int i=0;i<8;i++){
            arr[i][0] = 1;
            arr[i][6] = 1;
        }
        arr[3][1] = 1;
        arr[3][2] = 1;
    }

    //遍历二维数组
    public void getArr(int[][] arr){
        for(int i=0;i<8;i++){
            for(int j=0;j<7;j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }


}
