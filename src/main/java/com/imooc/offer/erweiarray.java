package com.imooc.offer;

public class erweiarray {
    public static void main(String[] args) {
        int[][] array = {
                {1, 2, 3, 4, 5, 8, 12, 20},
                {2, 3, 4, 5, 7, 9, 27, 36},
                {3, 5, 6, 7, 24, 28, 36, 42},
                {6, 7, 8, 9, 25, 30, 45, 53},
        };
        boolean res = find(array, 44);
        System.out.println(res);

    }

    static boolean find(int[][] arr, int gloa) {
        if (arr == null || arr.length <= 0) {
            return false;
        }
        if (arr[0][0] == gloa) {
            return true;
        }
        int rowLength = arr[0].length;//行长度
        int clomLength = arr.length;//列长度
        int leng = rowLength;
//蛮力法
//        for (int i = 0; i < clomLength; i++) {
//            for (int j = 0; j < rowLength; j++) {
//                if (arr[i][j] == gloa) {
//                    return true;
//                }
//            }
//        }
        for (int i = 0; i < clomLength; i++) {
            leng = rowLength;
            for (int j = 0; j < rowLength; j++) {
                leng--;
                if (arr[i][leng] == gloa) {
                    return true;
                } else if (arr[i][leng] < gloa) {
                    break;
                }
            }
        }
        return false;
    }
}
