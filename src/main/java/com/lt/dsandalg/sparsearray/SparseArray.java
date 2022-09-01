package com.lt.dsandalg.sparsearray;

/**
 * @description: 稀疏数组与二维数组的相互转换
 * @author: ~Teng~
 * @date: 2022/9/1 22:52
 */
public class SparseArray {
    public static void main(String[] args) {
        // 创建一个原始的二维数组 11 * 11
        // 0：表示没有棋子，1表示黑子，2表示篮子
        int[][] chessArr1 = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][4] = 2;

        // 输出原始的二维数组
        System.out.println("原始的二维数组是：");
        printArray(chessArr1);

        // 原始二维数组转换为稀疏数组
        // 1. 首先得到二维数组中非零的个数
        int row = chessArr1[0].length;
        int col = chessArr1.length;
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (chessArr1[i][j] != 0) {
                    count++;
                }
            }
        }

        // 2. 创建对应的稀疏数组
        int[][] sparseArr = new int[count + 1][3];
        // 3. 给稀疏数组的第一行赋值
        sparseArr[0][0] = row;
        sparseArr[0][1] = col;
        sparseArr[0][2] = count;

        // 4. 对稀疏数组内部进行赋值
        // 进行计录第几个非零数据
        int times = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (chessArr1[i][j] != 0) {
                    times++;
                    sparseArr[times][0] = i;
                    sparseArr[times][1] = j;
                    sparseArr[times][2] = chessArr1[i][j];
                }
            }
        }

        // 5. 输出稀疏数组的形式
        System.out.println("\n得到的稀疏数组");
        for (int[] ints : sparseArr) {
            System.out.printf("%d\t%d\t%d\t\n", ints[0], ints[1], ints[2]);
        }
        System.out.println();

        // 将稀疏数组恢复成原始数组
        // 1.先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组
        int[][] chessArr2 = new int[sparseArr[0][0]][sparseArr[0][1]];

        // 2. 读取稀疏数组的后几行数据（从第二行开始），并复制给原始的二维数组即可
        for (int i = 1; i < sparseArr[0].length; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }

        // 3.输出恢复后的二维数组
        System.out.println("恢复后的二维数组~~");
        printArray(chessArr2);
    }

    /**
     * 打印棋盘的方法
     *
     * @param array 原始二维数组
     */
    public static void printArray(int[][] array) {
        for (int[] row : array) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }
}
