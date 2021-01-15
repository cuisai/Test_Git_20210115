package com.sai.sparsearray;

/**
 * @Author sai
 * @Description 稀疏数组
 * @Time 2020-06-29 15:39
 */
public class SparseArray {
    public static void main(String[] args) {
        //  0-无  1-白棋子  2-黑棋子

        //1.创建二维数组
        int[][] chessArr1 = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;

        //  遍历创建好的原始的二维数组
        System.out.println("原始的二维数组----->");
        for (int[] arr:chessArr1) {
            for (int b:arr) {
                System.out.print("\t"+b);
            }
            System.out.println();
        }

        //2.将数组转化为稀疏数组
        int sum = 0;  //计算非空的个数
        for(int i=0;i<11;i++){
            for(int j=0;j<11;j++){
                if(chessArr1[i][j] != 0){
                    sum++;
                }
            }
        }

        //创建稀疏数组
        int[][] chessArr = new int[sum+1][3];

        chessArr[0][0] = 11;
        chessArr[0][1] = 11;
        chessArr[0][2] = sum;

        int count = 0;
        for(int i=0;i<11;i++){
            for(int j=0;j<11;j++){
                if(chessArr1[i][j] != 0){
                    count++;
                    chessArr[count][0] = i;
                    chessArr[count][1] = j;
                    chessArr[count][2] = chessArr1[i][j];
                }
            }
        }

        //遍历输出稀疏数组
        System.out.println("转换后的稀疏数组----->");
        for(int i=0;i<chessArr.length;i++){
            for(int j=0;j<3;j++){
                System.out.print("\t"+chessArr[i][j]);
            }
            System.out.println();
        }

        //3.稀疏数组再转换为原始二维数组
        int[][] chessArr2 = new int[chessArr[0][0]][chessArr[0][1]];

        for(int i=1;i<chessArr.length;i++){
            for(int j=0;j<3;j++){
                chessArr2[chessArr[i][0]][chessArr[i][1]] = chessArr[i][2];
            }
        }

        //遍历转换好的原始二维数组
        System.out.println("稀疏数组再转换为原始二维数组----->");
        for (int[] arr:chessArr2) {
            for (int b:arr) {
                System.out.print("\t"+b);
            }
            System.out.println();
        }

    }
}
