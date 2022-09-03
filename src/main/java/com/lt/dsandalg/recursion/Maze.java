package com.lt.dsandalg.recursion;

import java.util.Arrays;

/**
 * @description: 递归---迷宫问题
 * @author: ~Teng~
 * @date: 2022/9/3 19:31
 */
public class Maze {
    public static void main(String[] args) {
        // 先创建一个二维数组，模拟迷宫
        int[][] map = new int[8][7];

        // 使用1表示墙，上下左右边界全部置为1
        for (int i = 0; i < map.length; i++) {
            if (i == 0 || i == map.length - 1) {
                Arrays.fill(map[i], 1);
            } else {
                map[i][0] = 1;
                map[i][map[i].length - 1] = 1;
            }
        }

        // 设置挡板，1表示
        map[3][1] = 1;
        map[3][2] = 1;

        // 打印地图
        System.out.println("原本地图的情况");
        printMap(map);

        // 使用递归回溯
        setWay(map, 1, 1);
        System.out.println("小球走过并且标识的地图的情况：");
        printMap(map);
    }

    /**
     * 终点为右下角位置
     * 当map[i][j]为0时，表示没有走过
     * 当map[i][j]为1时，表示墙
     * 当map[i][j]为2时，表示通路可以走
     * 当map[i][j]为3时，表示该点走不通
     * 在走迷宫时，需要确定一个测略（方法） 下 -> 右 -> 上 -> 左 ， 如果该点走不通，再回溯
     *
     * @param map 地图
     * @param i   出发点x坐标
     * @param j   出发点y坐标
     * @return true or false
     */
    public static boolean setWay(int[][] map, int i, int j) {
        // 递归出口
        int row = map.length - 2;
        int col = map[0].length - 2;
        if (map[row][col] == 2) {
            // 找到出口
            return true;
        } else {
            // 说明当前这个点还没有走过
            if (map[i][j] == 0) {
                // 按照策略 下 -> 右 -> 上 -> 左
                // 假定该点是可以走通的
                map[i][j] = 2;

                if (setWay(map, i + 1, j)) {
                    // 向下走
                    return true;
                } else if (setWay(map, i, j + 1)) {
                    // 右
                    return true;
                } else if (setWay(map, i - 1, j)) {
                    // 上
                    return true;
                } else if (setWay(map, i, j - 1)) {
                    // 左
                    return true;
                } else {
                    // 说明该点走不通，是死路，不过既然上下左右都走不通，那么这点不会经过的
                    map[i][j] = 3;
                    return false;
                }
            } else {
                // 说明该节点，可能是1 2 3，2的出现是因为迷宫问题不会走重复路，不然会绕圈
                return false;
            }
        }
    }

    /**
     * 打印地图
     *
     * @param map 二维地图
     */
    public static void printMap(int[][] map) {
        // 打印地图
        for (int[] ints : map) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}
